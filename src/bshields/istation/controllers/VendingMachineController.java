package bshields.istation.controllers;

import java.math.BigDecimal;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachine;

import static java.lang.System.out;

public class VendingMachineController {
	private VendingMachine machine;
	
	public VendingMachineController(VendingMachine machine) { this.machine = machine; }
	
	public void requestItem(String keyCode) {
		ShelfSlot requestedSlot = machine.getShelves().stream()
			.flatMap(shelf -> shelf.getSlots().stream())
			.filter(slot -> slot.getKeyCode().equals(keyCode))
			.findFirst().get();
		
		if (requestedSlot.getPrice().compareTo(machine.getCash()) > 0) {
			// Customer has put less cash into machine than requested item costs
			out.println(requestedSlot);
		} else {
			machine.chargeCash(requestedSlot.getPrice());
			machine.refundCash();
		}
	}
	
	public void requestChange() { machine.refundCash(); }
	
	public void addCash(BigDecimal cash) { machine.addCash(cash); }
}
