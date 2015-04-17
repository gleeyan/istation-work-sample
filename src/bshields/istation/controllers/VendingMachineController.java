package bshields.istation.controllers;

import java.math.BigDecimal;
import java.text.NumberFormat;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachine;
import bshields.istation.interfaces.VendingMachineItem;
import bshields.istation.interfaces.VendingMachineView;
import bshields.istation.models.Message;

/**
 * Controller for a {@link VendingMachine} object. Consumers can view the contents of the vending machine,
 * add and remove money from the machine, and purchase snacks.
 * 
 * @author Brian
 *
 */
public class VendingMachineController {
	private VendingMachine machine;
	private VendingMachineView view;
	
	/**
	 * Creates a new controller, injecting the machine to be controlled and the view used for output
	 * 
	 * @param machine the machine being controlled
	 * @param view the view which manages the display for the controller
	 */
	public VendingMachineController(VendingMachine machine, VendingMachineView view) {
		this.machine = machine;
		this.view = view; 
	}
	
	/**
	 * Attempt to purchase the item in the slot with the key code {@code keyCode}. If the {@code keyCode}
	 * is invalid or refers to a slot which contains no snacks, an appropriate message will be generated.
	 * If the machine does not have enough money to purchase an item from the specified slot, the information
	 * on the selected slot will be displayed, which should include the correct price of the item.
	 * <p>
	 * If there is enough money to purchase the item, the appropriate amount of money will be kept in the machine,
	 * while the rest of the customer's money and the chosen item are returned to them.
	 * @param keyCode the key code for the slot to check
	 * @return an array of {@link Message Messages}. If an item is successfully purchased, one message will be tagged
	 * with the item and another message will be tagged with a {@link BigDecimal} of the refunded change.
	 */
	public Message[] requestItem(String keyCode) {
		ShelfSlot requestedSlot = machine.getShelves().stream()
			.flatMap(shelf -> shelf.getSlots().stream())
			.filter(slot -> slot.getKeyCode().equalsIgnoreCase(keyCode))
			.findFirst().orElse(null);
		
		if (requestedSlot == null) {
			return new Message[] { new Message(String.format("%s is an invalid key code", keyCode)) };
		}
		
		if (requestedSlot.peek() == null) {
			return new Message[] { new Message(String.format("No snacks left in slot %s", keyCode)) };
		}
		
		if (requestedSlot.getPrice().compareTo(machine.getCash()) > 0) {
			// Customer has put less cash into machine than requested item costs
			return new Message[] { new Message(requestedSlot.toString()) };
		} else {
			machine.chargeCash(requestedSlot.getPrice());
			BigDecimal refund = machine.refundCash();
			VendingMachineItem item = requestedSlot.removeFirst();
			
			return new Message[] {
				new Message(String.format("Received %s in change", NumberFormat.getCurrencyInstance().format(refund.doubleValue())), item),
				new Message(String.format("Received %s", item.getName()), refund)
			};
		}
	}
	
	public BigDecimal requestChange() { return machine.refundCash(); }
	
	public void addCash(BigDecimal cash) { machine.addCash(cash); }
	
	public BigDecimal getCash() { return machine.getCash(); }
	
	public void lookAtAvailableItems() { view.showVendingMachine(); }
}
