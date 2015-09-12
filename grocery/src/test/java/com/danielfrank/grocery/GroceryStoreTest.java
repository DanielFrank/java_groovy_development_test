package com.danielfrank.grocery;

import junit.framework.TestCase;

public class GroceryStoreTest extends TestCase {
	GroceryStore myGroceryStore;

	protected void setUp() throws Exception {
		super.setUp();
		myGroceryStore = new GroceryStore(3);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests creation has expected number of registers
	 */
	public void testCreate(){
		assertEquals(3, myGroceryStore.getRegisterCount());
	}


}
