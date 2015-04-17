package bshields.istation.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachineItem;

/**
 * {@inheritDoc}
 * 
 * @author Brian
 */
public class DefaultShelfSlot implements ShelfSlot {
	private LinkedList<VendingMachineItem> items;
	private BigDecimal price;
	private String keyCode;
	
	/**
	 * Creates an empty shelf slot with 0 width and $0.00 price
	 * 
	 * @param keyCode the code for ordering an item from this slot
	 * @see #DefaultShelfSlot(String, int, int, List)
	 */
	public DefaultShelfSlot(String keyCode) { this(keyCode, BigDecimal.ZERO, new LinkedList<VendingMachineItem>()); }
	/**
	 * Creates an empty shelf slot with 0 width and a specified price
	 * 
	 * @param keyCode the code for ordering an item from this slot
	 * @param price the price for items in this slot
	 * @see #DefaultShelfSlot(String, int, int, List)
	 */
	public DefaultShelfSlot(String keyCode, BigDecimal price) { this(keyCode, price, new LinkedList<VendingMachineItem>()); }
	/**
	 * Creates a pre-filled shelf slot
	 * 
	 * @param keyCode the code for ordering an item from this slot
	 * @param price the price for items in this slot
	 * @param items a collection of items to initially fill this slot with
	 */
	public DefaultShelfSlot(String keyCode, BigDecimal price, List<VendingMachineItem> items) {
		this.keyCode = keyCode;
		this.price = price;
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
	public VendingMachineItem peek() { return items.peek() == null ? null : items.peek().newInstance(); }

	@Override
	public BigDecimal getPrice() { return price; }
	@Override
	public void setPrice(BigDecimal price) { this.price = price; }
	
	@Override
	public String getKeyCode() { return keyCode; }
	@Override
	public void setKeyCode(String keyCode) { this.keyCode = keyCode; }
	
	@Override
	public String toString() {
		return String.format("[(%s) %s :: %s]  ",
			getKeyCode(),
			NumberFormat.getCurrencyInstance().format(getPrice().doubleValue()),
			peek() == null ? "" : peek().getName());
	}
}
