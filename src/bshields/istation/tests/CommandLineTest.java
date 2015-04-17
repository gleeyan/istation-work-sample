package bshields.istation.tests;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bshields.istation.controllers.VendingMachineController;
import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachine;
import bshields.istation.interfaces.VendingMachineItem;
import bshields.istation.models.DefaultShelf;
import bshields.istation.models.DefaultShelfSlot;
import bshields.istation.models.DefaultVendingMachine;
import bshields.istation.models.DefaultVendingMachineItem;

public class CommandLineTest {
	private static VendingMachineController controller;
	private static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		setupMachine();
	}
	
	private static void setupMachine() {
		List<Shelf> shelves = new ArrayList<Shelf>();
		shelves.add(setupShelf(
				setupSlot("C0", 1.75, "White Cheddar Popcorn", 3),
				setupSlot("C2", 1.75, "White Cheddar Popcorn", 5),
				setupSlot("C4", 1.75, "Sea Salt Potato Chips", 7),
				setupSlot("C6", 1.75, "Sour Cream Potato Chips", 3),
				setupSlot("C8", 1.75, "Classic Potato Chips", 1)
			));
		shelves.add(setupShelf(
				setupSlot("D0", 1.5, "Hard Fruit Candy", 9),
				setupSlot("D1", 1.5, "Chocolate & Caramel Sticks", 5),
				setupSlot("D2", 1.5, "Rice Chocolate Bar", 13),
				setupSlot("D3", 1.5, "W & Ws", 4),
				setupSlot("D4", 1.5, "Honey Bar", 15),
				setupSlot("D5", 1.5, "White Chocolate Bar", 22),
				setupSlot("D6", 1.5, "Chocolate-Covered Coffee Beans", 10),
				setupSlot("D7", 1.5, "Gourmet Chocolate Squares", 1),
				setupSlot("D8", 1.5, "Soft Fruit Candy", 6),
				setupSlot("D9", 1.5, "Peanut Butter & Chocolate Bowls", 2)
			));
		shelves.add(setupShelf(
				setupSlot("E0", 1.25, "Cinnamon Bun", 9),
				setupSlot("E2", 1.25, "Corn Chips", 3),
				setupSlot("E4", 1.25, "Cheesy Chips", 8),
				setupSlot("E6", 1.25, "Trail Mix", 11),
				setupSlot("E8", 1.25, "Potato Strings", 7)
			));
		VendingMachine defaultMachine = new DefaultVendingMachine(new BigDecimal(32.25), shelves);
		controller = new VendingMachineController(defaultMachine);
	}
	
	private static Shelf setupShelf(ShelfSlot...slots) {
		Shelf shelf = new DefaultShelf();
		for (ShelfSlot slot : slots) {
			shelf.addSlot(slot);
		}
		return shelf;
	}

	private static ShelfSlot setupSlot(String keyCode, double price, String name, int count) {
		ShelfSlot slot = new DefaultShelfSlot(keyCode, new BigDecimal(price));
		for (int i = 0; i < count; i++) {
			slot.addLast(new DefaultVendingMachineItem(name));
		}
		return slot;
	}
}
