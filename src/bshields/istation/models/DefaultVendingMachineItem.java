package bshields.istation.models;

import java.awt.Image;
import java.awt.image.BufferedImage;

import bshields.istation.interfaces.GraphicalVendingMachineItem;
import bshields.istation.interfaces.VendingMachineItem;

/**
 * Represents an item in the vending machine. Items do not track their own price, as the price is
 * dependent upon the location in the vending machine it is place, rather than what the item is,
 * and it is not possible for two items in the same slot (even two different items) to have
 * different prices.
 * 
 * @author Brian
 */
public class DefaultVendingMachineItem implements GraphicalVendingMachineItem {
	private String name;
	private Image sprite;
	
	/**
	 * Creates a default vending machine item. The item's name will be the empty string, and
	 * the item's sprite will be a 0x0px image.
	 * 
	 * @see #VendingMachineItem(String, Image)
	 */
	public DefaultVendingMachineItem() {
		this("", new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB));
	}
	
	/**
	 * Creates a named vending machine item. The item's sprite will be a 0x0px image.
	 * 
	 * @param name the name of the item
	 * @see #VendingMachineItem(String, Image)
	 */
	public DefaultVendingMachineItem(String name) {
		this(name, new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB));
	}
	
	/**
	 * Creates a fully-defined vending machine item.
	 * 
	 * @param name the name of the item
	 * @param sprite an image to represent the item in a graphical interface
	 */
	public DefaultVendingMachineItem(String name, Image sprite) {
		this.name = name;
		this.sprite = sprite;
	}

	@Override
	public String getName() { return this.name; }
	@Override
	public void setName(String name) { this.name = name; }

	@Override
	public Image getSprite() { return this.sprite; }
	@Override
	public void setSprite(Image sprite) { this.sprite = sprite; }

	@Override
	public VendingMachineItem newInstance() { return new DefaultVendingMachineItem(name, sprite); }
}
