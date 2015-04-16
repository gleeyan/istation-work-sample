package bshields.istation.models;

import java.util.ArrayList;
import java.util.List;

import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.VendingMachine;

/**
 * {@inheritDoc}
 * 
 * @author Brian
 */
public class DefaultVendingMachine implements VendingMachine {
	private List<Shelf> shelves;

	@Override
	public List<Shelf> getShelves() { return new ArrayList<Shelf>(shelves); }

	@Override
	public void addShelf(Shelf shelf) { shelves.add(shelf); }

	@Override
	public void addShelf(Shelf shelf, int index) { shelves.add(index, shelf); }

	@Override
	public boolean removeShelf(Shelf shelf) { return shelves.remove(shelf); }

	@Override
	public Shelf removeShelf(int index) { return shelves.remove(index); }
}
