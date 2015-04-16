package bshields.istation.models;

import java.util.LinkedList;
import java.util.List;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachineItem;

public class DefaultShelfSlot implements ShelfSlot {
	private LinkedList<VendingMachineItem> items;
	private int price;
	private int width;
	
	/**
	 * Creates an empty shelf slot with 0 width and $0.00 price
	 * @see #DefaultShelfSlot(int, int, List)
	 */
	public DefaultShelfSlot() { this(0, 0, new LinkedList<VendingMachineItem>()); }
	/**
	 * Creates an empty shelf slot with 0 width and a specified price
	 * @param price the price for items in this slot
	 * @see #DefaultShelfSlot(int, int, List)
	 */
	public DefaultShelfSlot(int price) { this(price, 0, new LinkedList<VendingMachineItem>()); }
	/**
	 * Creates an empty shelf slot with the specified width and price
	 * @param price the price for items in this slot
	 * @param width the width of this slot
	 * @see #DefaultShelfSlot(int, int, List)
	 */
	public DefaultShelfSlot(int price, int width) { this(price, width, new LinkedList<VendingMachineItem>()); }
	/**
	 * Creates a pre-filled shelf slot
	 * @param price the price for items in this slot
	 * @param width the width of this slot
	 * @param items a collection of items to initially fill this slot with
	 */
	public DefaultShelfSlot(int price, int width, List<VendingMachineItem> items) {
		this.price = price;
		this.width = width;
		this.items = new LinkedList<VendingMachineItem>(items);
	}
	
	@Override
	public void addFirst(VendingMachineItem item) { items.addFirst(item); }

	@Override
	public void addLast(VendingMachineItem item) { items.addLast(item); }

	@Override
	public VendingMachineItem removeFirst() { return items.removeFirst(); }

	@Override
	public VendingMachineItem removeLast() { return items.removeLast(); }

	@Override
	public VendingMachineItem peek() { return items.peek().newInstance(); }

	@Override
	public int getPrice() { return price; }

	@Override
	public void setPrice(int price) { this.price = price; }

	@Override
	public int getWidth() { return width; }

	@Override
	public void setWidth(int width) { this.width = width; }
}
