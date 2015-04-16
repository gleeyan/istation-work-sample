package bshields.istation.interfaces;

import java.util.List;

/**
 * A shelf contains a number of shelf slots, and has a given height.
 * 
 * @author Brian
 */
public interface Shelf {
	/**
	 * Gets a copy of the shelf slots on this shelf. Only a copy is returned; the list is not directly editable.
	 * @return a copy of the collection of slots on this shelf
	 * @see #addSlot(ShelfSlot, int)
	 * @see #removeSlot(int)
	 * @see #removeSlot(ShelfSlot)
	 */
	List<ShelfSlot> getSlots();
	/**
	 * Adds a slot to the right side of this shelf
	 * @param slot the slot to add
	 * @see #addSlot(ShelfSlot, int)
	 */
	void addSlot(ShelfSlot slot);
	/**
	 * Adds a slot to this shelf
	 * @param slot the slot to add
	 * @param index the location to add it at
	 */
	void addSlot(ShelfSlot slot, int index);
	/**
	 * Removes the first instance of the specified slot from this shelf
	 * @param slot the slot to remove
	 * @return {@code true} if the specified slot was on this shelf
	 * @see #removeSlot(int)
	 */
	boolean removeSlot(ShelfSlot slot);
	/**
	 * Removes a slot from a position on the shelf
	 * @param index the location to remove the slot from
	 * @return the slot that was removed
	 * @see #removeSlot(ShelfSlot)
	 */
	ShelfSlot removeSlot(int index);
}
