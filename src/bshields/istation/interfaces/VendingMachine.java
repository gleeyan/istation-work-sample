package bshields.istation.interfaces;

import java.util.List;

/**
 * Represents a whole vending machine, from snack contents to money to keypad.
 * 
 * @author Brian
 */
public interface VendingMachine {
	List<Shelf> getShelves();
	void addEmptyShelf();
	void addEmptyShelf(int index);
	void addShelf(Shelf shelf);
	void addShelf(Shelf shelf, int index);
	void removeShelf(Shelf shelf);
	void removeShelf(int index);
}
