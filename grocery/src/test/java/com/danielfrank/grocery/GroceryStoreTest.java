package com.danielfrank.grocery;

import junit.framework.TestCase;

public class GroceryStoreTest extends TestCase {
	GroceryStoreTestData data = new GroceryStoreTestData();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests creation has expected number of registers
	 */
	public void testCreate(){
		assertEquals(2, data.grocery.getRegisterCount());
	}

	/**
	 * Tests last register is Trainee
	 */
	public void testLastRegister(){
		assertTrue(data.grocery.getRegister(2).getCashier() instanceof TraineeCashier );
	}
	
	

	
}
