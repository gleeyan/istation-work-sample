package bshields.istation.models;

import java.util.ArrayList;
import java.util.List;

import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.ShelfSlot;

/**
 * Default implementation of shelf interface. {@inheritDoc}
 * @author Brian
 */
public class DefaultShelf implements Shelf {
	private List<ShelfSlot> slots;
	private int height;

	@Override
	public List<ShelfSlot> getSlots() { return new ArrayList<ShelfSlot>(slots); }

	@Override
	public void addSlot(ShelfSlot slot) { slots.add(slot); }

	@Override
	public void addSlot(ShelfSlot slot, int index) { slots.add(index, slot); }

	@Override
	public boolean removeSlot(ShelfSlot slot) { return slots.remove(slot); }

	@Override
	public ShelfSlot removeSlot(int index) { return slots.remove(index); }

}
