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
import bshields.istation.interfaces.VendingMachine;
import bshields.istation.models.DefaultShelf;
import bshields.istation.models.DefaultShelfSlot;
import bshields.istation.models.DefaultVendingMachine;

/**
 * JUnit tests for {@link DefaultVendingMachine}
 * 
 * @author Brian
 */
public class TestDefaultVendingMachine {
	private VendingMachine machine;
	private static List<Shelf> shelves;
	private static Shelf shelf1;
	private static Shelf shelf2;
	private static List<ShelfSlot> shelfSlots1;
	private static List<ShelfSlot> shelfSlots2;
	private static ShelfSlot slot1;
	private static ShelfSlot slot2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		slot1 = new DefaultShelfSlot("A1", new BigDecimal(12.5));
		slot2 = new DefaultShelfSlot("B2", new BigDecimal(7.4));
		
		shelfSlots1 = new ArrayList<ShelfSlot>();
		shelfSlots1.add(slot1);
		shelfSlots1.add(slot2);
		
		shelfSlots2 = new ArrayList<ShelfSlot>();
		shelfSlots2.add(slot2);
		shelfSlots2.add(slot1);
		
		shelf1 = new DefaultShelf(shelfSlots1);
		shelf2 = new DefaultShelf(shelfSlots2);
		
		shelves = new ArrayList<Shelf>();
		shelves.add(shelf1);
		shelves.add(shelf2);
	}

	@Before
	public void setUp() throws Exception {
		machine = new DefaultVendingMachine(new BigDecimal(10), shelves);
	}

	@Test
	public void testGetCash() {
		assertEquals("Machine contains no customer cash", BigDecimal.ZERO, machine.getCash());
	}

	@Test
	public void testGetReserve() {
		assertEquals("Machine contains starting reserve", new BigDecimal(10), machine.getReserve());
	}

	@Test
	public void testAddCash() {
		machine.addCash(new BigDecimal(1));
		
		assertEquals("Machine has recently added customer cash", new BigDecimal(1), machine.getCash());
		assertEquals("Machine reserve also contains customer cash", new BigDecimal(11), machine.getReserve());
	}

	@Test
	public void testRefundCash() {
		machine.addCash(new BigDecimal(1));
		BigDecimal refund = machine.refundCash();
		
		assertEquals("Refund is added amount", new BigDecimal(1), refund);
		assertEquals("Reserve is back to starting", new BigDecimal(10), machine.getReserve());
	}

	@Test
	public void testChargeCash() {
		machine.addCash(new BigDecimal(1));
		machine.chargeCash(new BigDecimal(.5));
		
		assertEquals("Cash has been charged from", new BigDecimal(.5), machine.getCash());
	}

}
