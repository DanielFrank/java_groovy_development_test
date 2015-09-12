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
	
	/**
	 * Tests allEmpty function for both cases
	 */
	public void testAllEmpty(){
		assertTrue(data.groceryWithAllEmptyRegister.checkAllRegistersEmpty());
		assertFalse(data.groceryWithEmptyRegister.checkAllRegistersEmpty());
	}

	/**Tests getShortestLine chooses register with fewest people*/
	public void testGetShortestLine(){
		Register register = data.grocery.getShortestLine();
		assertEquals(register,data.grocery.getRegister(1));
	}
	
	/**Tests customer B chooses register with fewest items at end*/
	public void testGetLineWithCustomerLastLeastItemsChoosesCorrectly(){
		Register register = data.grocery.getLineWithCustomerLastLeastItems();
		assertEquals(register,data.grocery.getRegister(2));
	}
	
	/**Tests getShortestLine chooses empty register*/
	public void testGetShortestLineWithEmptyRegister(){
		Register register = data.groceryWithEmptyRegister.getShortestLine();
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(3));
	}

	/**Tests customer B chooses empty register*/
	public void testGetLineWithCustomerLastLeastItemsWithEmptyRegister(){
		Register register = data.groceryWithEmptyRegister.getLineWithCustomerLastLeastItems();
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(3));
	}
	
	/**Tests getShortestLine chooses empty register with smallest number*/
	public void testGetShortestLineWithTwoEmptyRegisters(){
		Register register = data.groceryWithTwoEmptyRegisters.getShortestLine();
		assertEquals(register,data.groceryWithTwoEmptyRegisters.getRegister(1));
	}

	/**Tests customer B chooses empty register*/
	public void testGetLineWithCustomerLastLeastItemsWithTwoEmptyRegisters(){
		Register register = data.groceryWithTwoEmptyRegisters.getLineWithCustomerLastLeastItems();
		assertEquals(register,data.groceryWithTwoEmptyRegisters.getRegister(1));
	}

	/**Tests getShortestLine chooses equal-sized-line register with smallest number*/
	public void testGetShortestLineWithTwoEqualSizedLines(){
		Register register = data.groceryWithTwoEqualSizedLines.getShortestLine();
		assertEquals(register,data.groceryWithTwoEqualSizedLines.getRegister(2));
	}
	
	/**Tests customer A chooses equal-item register with smallest number
	 * Unsure if size of line should be considered (see GetLineWithCustomerLastLeastItems.chooseRegister notes)
	 * so logic change may break this test.
	 * 
	 * */
	public void testGetLineWithCustomerLastLeastItemsWithTwoEqualSizedLines(){
		Register register = data.groceryWithTwoEqualSizedLastCustomerItems.getLineWithCustomerLastLeastItems();
		assertEquals(register,data.groceryWithTwoEqualSizedLastCustomerItems.getRegister(2));
	}	
}
