package bshields.istation.interfaces;

/**
 * Represents a slot on a vending machine's shelf. The slot holds items in the vending machine, and
 * all items in a slot cost the same.
 * 
 * @author Brian
 */
public interface ShelfSlot {
	/**
	 * Adds an item to the front of the slot
	 * @param item the item to add
	 * @see #addLast(VendingMachineItem)
	 * @see #removeFirst()
	 */
	void addFirst(VendingMachineItem item);
	/**
	 * Adds an item to the back of the slot
	 * @param item the item to add
	 * @see #addFirst(VendingMachineItem)
	 * @see #removeLast()
	 */
	void addLast(VendingMachineItem item);
	/**
	 * Removes an item from the front of the slot. This method should be called when purchasing items.
	 * @return the item that was removed from the slot
	 * @see #removeLast()
	 * @see #addFirst(VendingMachineItem)
	 */
	VendingMachineItem removeFirst();
	/**
	 * Removes an item from the back of the slot.
	 * @return the item that was removed from the slot
	 * @see #removeFirst()
	 * @see #addLast(VendingMachineItem)
	 */
	VendingMachineItem removeLast();
	/**
	 * Gets a copy of the item at the front of the slot. This method is useful for presenting what items
	 * are visible to the customer. The returned object is a copy, so that a consuming class cannot modify
	 * the item without removing it.
	 * @return a copy of the item at the front of the slot
	 */
	VendingMachineItem peek();
	
	int getPrice();
	void setPrice(int price);
	
	int getWidth();
	void setWidth(int width);
	
	String getKeyCode();
	void steKeyCode(String keyCode);
}
