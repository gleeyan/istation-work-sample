package bshields.istation.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.models.DefaultShelf;
import bshields.istation.models.DefaultShelfSlot;

/**
 * JUnit tests for {@link DefaultShelf}
 * 
 * @author Brian
 */
public class TestDefaultShelf {
	private Shelf shelf;
	private static List<ShelfSlot> slots;
	private static ShelfSlot slot1;
	private static ShelfSlot slot2;
	private static ShelfSlot slot3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		slots = new ArrayList<ShelfSlot>();
		slot1 = new DefaultShelfSlot("A1", new BigDecimal(12.5));
		slot2 = new DefaultShelfSlot("B2", new BigDecimal(7.4));
		slot3 = new DefaultShelfSlot("C3", new BigDecimal(3));
		slots.add(slot1);
		slots.add(slot2);
	}

	@Before
	public void setUp() throws Exception {
		shelf = new DefaultShelf(slots);
	}

	@Test
	public void testAddSlotShelfSlot() {
		shelf.addSlot(slot3);
		
		assertEquals("Slots length is 3", 3, shelf.getSlots().size());
		assertEquals("slots[2] is slot3", slot3, shelf.getSlots().get(2));
	}

	@Test
	public void testAddSlotShelfSlotInt() {
		shelf.addSlot(slot3, 0);
		
		assertEquals("Slots length is 3", 3, shelf.getSlots().size());
		assertEquals("slots[0] is slot3", slot3, shelf.getSlots().get(0));
	}

	@Test
	public void testRemoveSlotShelfSlot() {
		assertTrue("Shelf contained slot1", shelf.removeSlot(slot1));
		assertFalse("Shelf did not contain slot3", shelf.removeSlot(slot3));
	}

	@Test
	public void testRemoveSlotInt() {
		assertEquals("slots[0] is slot1", slot1, shelf.removeSlot(0));
		assertEquals("slots length is 1", 1, shelf.getSlots().size());
	}

}
