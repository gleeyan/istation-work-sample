package bshields.istation.views;

import static java.lang.System.out;

import bshields.istation.interfaces.VendingMachine;
import bshields.istation.interfaces.VendingMachineView;

/**
 * {@inheritDoc}
 * 
 * @author Brian
 */
public class VendingMachineConsoleView implements VendingMachineView {
	private VendingMachine machine;
	
	public VendingMachineConsoleView(VendingMachine machine) { this.machine = machine; }

	@Override
	public void showVendingMachine() {
		machine.getShelves().stream()
			.forEach(shelf -> {
				shelf.getSlots().stream().forEach(slot -> out.println(slot));
				out.println();
			});
	}
}
