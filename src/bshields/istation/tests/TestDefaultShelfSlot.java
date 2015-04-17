package bshields.istation.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bshields.istation.interfaces.ShelfSlot;
import bshields.istation.interfaces.VendingMachineItem;
import bshields.istation.models.DefaultShelf;
import bshields.istation.models.DefaultShelfSlot;
import bshields.istation.models.DefaultVendingMachineItem;

/**
 * JUnit tests for {@link DefaultShelfSlot}
 * 
 * @author Brian
 */
public class TestDefaultShelfSlot {
	private ShelfSlot slot;
	private static VendingMachineItem item1;
	private static VendingMachineItem item2;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		item1 = new DefaultVendingMachineItem("Example 1");
		item2 = new DefaultVendingMachineItem("Example 2");
	}

	@Before
	public void setUp() throws Exception {
		slot = new DefaultShelfSlot("A1");
	}

	@Test
	public void testRemoveFirst() {
		slot.addLast(item1);
		slot.addLast(item2);
		
		assertEquals("Removed item should be item1", item1, slot.removeFirst());
	}

	@Test
	public void testRemoveLast() {
		slot.addFirst(item1);
		slot.addFirst(item2);
		
		assertEquals("Removed item should be item1", item1, slot.removeLast());
	}

	@Test
	public void testPeek() {
		slot.addLast(item1);
		slot.addLast(item2);
		
		assertEquals("Front item name should be item1's name", item1.getName(), slot.peek().getName());
	}

	@Test
	public void testToString() {
		slot.setPrice(new BigDecimal(12.5));
		slot.addFirst(item1);
		
		assertEquals("Slot should be formatted correctly", "[(A1) $12.50 :: Example 1]  ", slot.toString());
	}

}
