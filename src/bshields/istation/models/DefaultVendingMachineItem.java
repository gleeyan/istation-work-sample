package bshields.istation.models;

import java.awt.Image;
import java.awt.image.BufferedImage;

import bshields.istation.interfaces.VendingMachineItem;

/**
 * Represents an item in the vending machine. Items do not track their own price, as the price is
 * dependent upon the location in the vending machine it is place, rather than what the item is,
 * and it is not possible for two items in the same slot (even two different items) to have
 * different prices.
 * 
 * @author Brian
 */
public class DefaultVendingMachineItem implements VendingMachineItem {
	private String name;
	
	/**
	 * Creates a fully-defined vending machine item.
	 * 
	 * @param name the name of the item
	 */
	public DefaultVendingMachineItem(String name) {
		this.name = name;
	}

	@Override
	public String getName() { return this.name; }
	@Override
	public void setName(String name) { this.name = name; }

	@Override
	public VendingMachineItem newInstance() { return new DefaultVendingMachineItem(name); }
}
