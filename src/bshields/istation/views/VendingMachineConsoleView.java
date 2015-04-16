package bshields.istation.views;

import static java.lang.System.out;

import java.text.NumberFormat;

import bshields.istation.interfaces.VendingMachine;
import bshields.istation.interfaces.VendingMachineView;

public class VendingMachineConsoleView implements VendingMachineView {
	private VendingMachine machine;
	
	public VendingMachineConsoleView(VendingMachine machine) { this.machine = machine; }

	@Override
	public void showVendingMachine() {
		machine.getShelves().stream()
			.forEach(shelf -> {
				shelf.getSlots().stream().forEach(slot -> {
					out.printf("[(%s) %s :: %s]  ",
						slot.getKeyCode(),
						NumberFormat.getCurrencyInstance().format(slot.getPrice().toString()),
						slot.peek().getName());
				});
				out.println();
			});
						
	}

}
