package bshields.istation.tests;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bshields.istation.controllers.VendingMachineController;
import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachine;
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
		char useDefault = (char)0;
		String line = "";
		do {
			out.println();
			out.print("Do you want to use the default machine [Y], or set up your own [N]? ");
			line = in.nextLine();
			if (line.length() > 0) {
				useDefault = Character.toLowerCase(line.charAt(0));
			}
		} while (!(useDefault == 'y' || useDefault == 'n'));
		
		if (useDefault == 'y') {
			List<Shelf> shelves = new ArrayList<Shelf>();
			List<ShelfSlot> slots = new ArrayList<ShelfSlot>();
			ShelfSlot slot = new DefaultShelfSlot("C0", new BigDecimal(1.75));
			slot.addFirst(new DefaultVendingMachineItem("White Cheddar Popcorn"));
			slots.add(slot);
			slot = new DefaultShelfSlot("C2", new BigDecimal(1.75));
			slot.addFirst(new DefaultVendingMachineItem("White Cheddar Popcorn"));
			slots.add(slot);
			slot = new DefaultShelfSlot("C4", new BigDecimal(1.75));
			slot.addFirst(new DefaultVendingMachineItem("Sea Salt Potato Chips"));
			slots.add(slot);
			slot = new DefaultShelfSlot("C6", new BigDecimal(1.75));
			slot.addFirst(new DefaultVendingMachineItem("Sour Cream Potato Chips"));
			slots.add(slot);
			slot = new DefaultShelfSlot("C8", new BigDecimal(1.75));
			slot.addFirst(new DefaultVendingMachineItem("Classic Potato Chips"));
			slots.add(slot);
			Shelf shelf = new DefaultShelf(slots);
			shelves.add(shelf);
			slots = new ArrayList<ShelfSlot>();
			slot = new DefaultShelfSlot("D0", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Hard Fruit Candy"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D1", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Chocolate & Caramel Sticks"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D2", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Rice Chocolate Bar"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D3", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("W & Ws"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D4", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Honey Bar"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D5", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("White Chocolate Bar"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D6", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Chocolate-Covered Coffee Beans"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D7", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Gourmet Chocolate Squares"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D8", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Soft Fruit Candy"));
			slots.add(slot);
			slot = new DefaultShelfSlot("D9", new BigDecimal(1.5));
			slot.addFirst(new DefaultVendingMachineItem("Peanut Butter & Chocolate Bowls"));
			slots.add(slot);
			shelf = new DefaultShelf(slots);
			shelves.add(shelf);
			slot = new DefaultShelfSlot("E0", new BigDecimal(1.25));
			slot.addFirst(new DefaultVendingMachineItem("Cinnamon Bun"));
			slots.add(slot);
			slot = new DefaultShelfSlot("E2", new BigDecimal(1.25));
			slot.addFirst(new DefaultVendingMachineItem("Corn Chips"));
			slots.add(slot);
			slot = new DefaultShelfSlot("E4", new BigDecimal(1.25));
			slot.addFirst(new DefaultVendingMachineItem("Cheesy Chips"));
			slots.add(slot);
			slot = new DefaultShelfSlot("E6", new BigDecimal(1.25));
			slot.addFirst(new DefaultVendingMachineItem("Trail Mix"));
			slots.add(slot);
			slot = new DefaultShelfSlot("E8", new BigDecimal(1.25));
			slot.addFirst(new DefaultVendingMachineItem("Potato Strings"));
			slots.add(slot);
			shelf = new DefaultShelf(slots);
			shelves.add(shelf);
			VendingMachine defaultMachine = new DefaultVendingMachine(new BigDecimal(32.25), shelves);
			controller = new VendingMachineController(defaultMachine);
		} else {
			setupCustomMachine();
		}
	}
	
	private static void setupCustomMachine() {
		VendingMachine machine = new DefaultVendingMachine(BigDecimal.ZERO);
		
		int selection = 0;
		do {
			printShelfMenu();
			try { selection = Integer.parseInt(in.nextLine()); }
			catch (NumberFormatException nfe) { continue; }
			
			int index = -1;
			switch (selection) {
				case 1:
					machine.addShelf(setupShelf(new DefaultShelf()));
					break;
				case 2:
					List<Shelf> shelves = machine.getShelves();
					index = getSelectedShelfIndex(shelves) - 1;
					Shelf editedShelf = setupShelf(shelves.get(index));
					shelves.set(index, editedShelf);
					while (machine.getShelves().size() > 0) { machine.removeShelf(0); }
					
					Shelf tmp;
					while ((tmp = shelves.remove(0)) != null) { machine.addShelf(tmp); }
					break;
				case 3:
					index = getSelectedShelfIndex(machine.getShelves()) - 1;
					machine.removeShelf(index);
					break;
			}
		} while (selection != 4);
		
		controller = new VendingMachineController(machine);
	}
	
	private static Shelf setupShelf(Shelf shelf) {
		int selection = 0;
		do {
			printSlotMenu();
			try { selection = Integer.parseInt(in.nextLine()); }
			catch (NumberFormatException nfe) { continue; }
			
			int index = -1;
			switch (selection) {
				case 1:
					shelf.addSlot(setupSlot(new DefaultShelfSlot("")));
					break;
				case 2:
					List<ShelfSlot> slots = shelf.getSlots();
					index = getSelectedSlotIndex(shelf.getSlots()) - 1;
					ShelfSlot editedSlot = setupSlot(slots.get(index));
					slots.set(index, editedSlot);
					while (shelf.getSlots().size() > 0) { shelf.removeSlot(0); }
					
					ShelfSlot tmp;
					while ((tmp = slots.remove(0)) != null) { shelf.addSlot(tmp); }
					break;
				case 3:
					index = getSelectedSlotIndex(shelf.getSlots()) - 1;
					shelf.removeSlot(index);
					break;
			}
		} while (selection != 4);
		
		return shelf;
	}
	
	private static ShelfSlot setupSlot(ShelfSlot slot) {
		
	}
	
	private static int getSelectedSlotIndex(List<ShelfSlot> slots) {
		
	}
	
	private static int getSelectedShelfIndex(List<Shelf> shelves) {
		int index = 0;
		do {
			printShelfIndices(shelves);
			try { index = Integer.parseInt(in.nextLine()); }
			catch (NumberFormatException nfe) { continue; }
		} while (!(index > 0 && index < shelves.size() + 1));
		return index;
	}
	
	private static void printSlotIndices(List<ShelfSlot> slots) {
		out.println();
		out.println(" ==== Existing Slots");
		for (int i = 0; i < slots.size(); i++) {
			out.printf("[%d] %s%s\n",
					i + 1,
					slots.get(i).toString().substring(0, 70),
					slots.get(i).toString().length() > 70 ? "..." : "");
		}
		out.print("> ");
	}
	
	private static void printSlotMenu() {
		out.println();
		out.println(" === Slots");
		out.println("[1] Create new slot");
		out.println("[2] Edit existing slot");
		out.println("[3] Remove slot");
		out.println("[4] Finished");
		out.print("> ");
	}
	
	private static void printShelfIndices(List<Shelf> shelves) {
		out.println();
		out.println(" === Existing Shelves");
		for (int i = 0; i < shelves.size(); i++) {
			out.printf("[%d] %s%s\n",
					i + 1,
					shelves.get(i).toString().substring(0, 70),
					shelves.get(i).toString().length() > 70 ? "..." : "");
		}
		out.print("> ");
	}
	
	private static void printShelfMenu() {
		out.println();
		out.println(" == Shelves");
		out.println("[1] Create new shelf");
		out.println("[2] Edit existing shelf");
		out.println("[3] Remove shelf");
		out.println("[4] Finished");
		out.print("> ");
	}
}
