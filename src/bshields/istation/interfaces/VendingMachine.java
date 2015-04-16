package bshields.istation.interfaces;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a whole vending machine, from snack contents to money to keypad.
 * 
 * @author Brian
 */
public interface VendingMachine {
	/**
	 * Gets a copy of the list of shelves in the vending machine. Modifications to the copy will not be reflected
	 * in the contents of the machine.
	 * 
	 * @return a copy of the shelf collection
	 */
	List<Shelf> getShelves();
	/**
	 * Adds a shelf to the bottom of the machine
	 * 
	 * @param shelf the shelf to add
	 * @see #addShelf(Shelf, int)
	 */
	void addShelf(Shelf shelf);
	/**
	 * Adds a shelf to the machine
	 * 
	 * @param shelf the shelf to add
	 * @param index the location to add the shelf
	 */
	void addShelf(Shelf shelf, int index);
	/**
	 * Removes the first instance of the given shelf from the machine.
	 * 
	 * @param shelf the shelf to remove
	 * @return {@code true} if the shelf was present in the machine
	 * @see #removeShelf(int)
	 */
	boolean removeShelf(Shelf shelf);
	/**
	 * Removes a shelf from the given location in the machine
	 * 
	 * @param index the location to remove a shelf from
	 * @return the shelf that was removed
	 * @see #removeShelf(Shelf)
	 */
	Shelf removeShelf(int index);
	
	BigDecimal getCash();
	void addCash(BigDecimal cash);
	BigDecimal refundCash();
	void chargeCash(BigDecimal charge);
	BigDecimal getReserve();
}
