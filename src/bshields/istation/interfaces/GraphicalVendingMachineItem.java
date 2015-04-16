package bshields.istation.interfaces;

import java.awt.Image;

/**
 * @author Brian
 *
 */
public interface GraphicalVendingMachineItem extends VendingMachineItem {
	Image getSprite();
	void setSprite(Image sprite);
}
