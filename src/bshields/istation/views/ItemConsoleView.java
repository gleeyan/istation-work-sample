package bshields.istation.views;

import bshields.istation.interfaces.ItemView;
import bshields.istation.interfaces.VendingMachineItem;

import static java.lang.System.out;

/**
 * {@inheritDoc}
 * 
 * @author Brian
 */
public class ItemConsoleView implements ItemView {
	@Override
	public void showItem(VendingMachineItem item) {
		out.print(item.getName());
	}
}
