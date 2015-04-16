package bshields.istation.views;

import java.text.NumberFormat;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.SlotView;
import static java.lang.System.out;

/**
 * {@inheritDoc}
 * 
 * @author Brian
 */
public class SlotConsoleView implements SlotView {
	private ShelfSlot slot;
	
	public SlotConsoleView(ShelfSlot slot) { this.slot = slot; }
	
	@Override
	public void showSlot() {
		out.printf("[%s] %s :: %s",
				slot.getKeyCode(),
				NumberFormat.getCurrencyInstance().format(slot.getPrice().toString()),
				slot.peek().getName());
	}
}
