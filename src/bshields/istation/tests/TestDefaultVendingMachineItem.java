package bshields.istation.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bshields.istation.interfaces.VendingMachineItem;
import bshields.istation.models.DefaultVendingMachineItem;

public class TestDefaultVendingMachineItem {
	private VendingMachineItem item1;

	@Before
	public void setUp() throws Exception {
		item1 = new DefaultVendingMachineItem("Example");
	}
	
	@Test
	public void testGetName() {
		assertEquals("Name must be equal to value in constructor", item1.getName(), "Example");
	}

	@Test
	public void testSetName() {
		item1.setName("Another example");
		
		assertEquals("Name must be equal to value in setName", item1.getName(), "Another example");
	}

	@Test
	public void testNewInstance() {
		VendingMachineItem item2 = item1.newInstance();
		
		assertEquals("Names of both items must be equal", item1.getName(), item2.getName());
	}

}
