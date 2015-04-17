package bshields.istation.controllers;

import java.math.BigDecimal;
import java.text.NumberFormat;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachine;
import bshields.istation.interfaces.VendingMachineItem;
import bshields.istation.interfaces.VendingMachineView;
import bshields.istation.models.Message;

public class VendingMachineController {
	private VendingMachine machine;
	private VendingMachineView view;
	
	public VendingMachineController(VendingMachine machine, VendingMachineView view) {
		this.machine = machine;
		this.view = view; 
	}
	
	public Message[] requestItem(String keyCode) {
		ShelfSlot requestedSlot = machine.getShelves().stream()
			.flatMap(shelf -> shelf.getSlots().stream())
			.filter(slot -> slot.getKeyCode().equalsIgnoreCase(keyCode))
			.findFirst().get();
		
		if (requestedSlot.getPrice().compareTo(machine.getCash()) > 0) {
			// Customer has put less cash into machine than requested item costs
			return new Message[] { new Message(requestedSlot.toString()) };
		} else {
			machine.chargeCash(requestedSlot.getPrice());
			BigDecimal refund = machine.refundCash();
			VendingMachineItem item = requestedSlot.removeFirst();
			
			return new Message[] {
				new Message(String.format("Received %s in change", NumberFormat.getCurrencyInstance().format(refund.doubleValue()))),
				new Message(String.format("Received %s", item.getName()))
			};
		}
	}
	
	public BigDecimal requestChange() { return machine.refundCash(); }
	
	public void addCash(BigDecimal cash) { machine.addCash(cash); }
	
	public BigDecimal getCash() { return machine.getCash(); }
	
	public void lookAtAvailableItems() { view.showVendingMachine(); }
}
