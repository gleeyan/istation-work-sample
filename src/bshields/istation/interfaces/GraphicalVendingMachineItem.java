package bshields.istation.interfaces;

import java.awt.Image;

/**
 * Graphical vending machine items additionally have a sprite to represent them.
 * 
 * @author Brian
 */
public interface GraphicalVendingMachineItem extends VendingMachineItem {
	Image getSprite();
	void setSprite(Image sprite);
}
