/**
 * 
 */
package com.danielfrank.grocery;

import junit.framework.TestCase;

/**
 * @author danielfrank
 *
 */
public class CustomerTest extends TestCase {
	GroceryStoreTestData data = new GroceryStoreTestData();

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	

	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests customers with different arrival times
	 */
	public void testCompareDifferentArrivalTimes(){
		Customer customer1 = new CustomerA(1, 2);
		Customer customer2 = new CustomerA(2, 2);
		assertTrue(customer1.compareTo(customer2) < 0);
		assertTrue(customer2.compareTo(customer1)  > 0);
	}

	/**
	 * Tests customers with same arrival times
	 * but different item count
	 */
	public void testCompareDifferentItemCounts(){
		Customer customer1 = new CustomerA(1, 2);
		Customer customer2 = new CustomerA(1, 3);
		assertTrue(customer1.compareTo(customer2) < 0);
		assertTrue(customer2.compareTo(customer1)  > 0);
	}
	
	/**
	 * Tests customers with same arrival time, same item count
     * but different CustomerTypes.
	 */
	public void testCompareDifferentCustomerTypes(){
		Customer customer1 = new CustomerA(1, 2);
		Customer customer2 = new CustomerB(1, 2);
		assertTrue(customer1.compareTo(customer2) < 0);
		assertTrue(customer2.compareTo(customer1)  > 0);
	}

	/**
	 * Tests customers same values across the board
	 */
	public void testEqualCustomers(){
		Customer customer1 = new CustomerA(1, 2);
		Customer customer2 = new CustomerA(1, 2);
		assertEquals(0,customer1.compareTo(customer2));
		assertEquals(0,customer2.compareTo(customer1));
	}

	/**Tests customer A chooses register with fewest people*/
	public void testCustomerAChoosesCorrectly(){
		Customer customer = new CustomerA(1, 2);
		Register register = customer.chooseRegister(data.grocery);
		assertEquals(register,data.grocery.getRegister(1));
	}
	
	/**Tests customer B chooses register with fewest items at end*/
	public void testCustomerBChoosesCorrectly(){
		Customer customer = new CustomerB(1, 2);
		Register register = customer.chooseRegister(data.grocery);
		assertEquals(register,data.grocery.getRegister(2));
	}
	
	/**Tests customer A chooses empty register*/
	public void testCustomerAWithEmptyRegister(){
		Customer customer = new CustomerA(1, 2);
		Register register = customer.chooseRegister(data.groceryWithEmptyRegister);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(3));
	}

	/**Tests customer B chooses empty register*/
	public void testCustomerBWithEmptyRegister(){
		Customer customer = new CustomerB(1, 2);
		Register register = customer.chooseRegister(data.groceryWithEmptyRegister);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(3));
	}
	
	/**Tests customer A chooses empty register with smallest number*/
	public void testCustomerAWithTwoEmptyRegisters(){
		Customer customer = new CustomerA(1, 2);
		Register register = customer.chooseRegister(data.groceryWithTwoEmptyRegisters);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(1));
	}

	/**Tests customer B chooses empty register*/
	public void testCustomerBWithTwoEmptyRegisters(){
		Customer customer = new CustomerB(1, 2);
		Register register = customer.chooseRegister(data.groceryWithTwoEmptyRegisters);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(1));
	}

	/**Tests customer A chooses equal-sized-line register with smallest number*/
	public void testCustomerAWithTwoEqualSizedLines(){
		Customer customer = new CustomerA(1, 2);
		Register register = customer.chooseRegister(data.groceryWithTwoEmptyRegisters);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(2));
	}
	
	/**Tests customer A chooses equal-item register with smallest number
	 * Unsure if size of line should be considered (see CustomerB.chooseRegister notes)
	 * so logic change may break this test.
	 * 
	 * */
	public void testCustomerBWithTwoEqualSizedLines(){
		Customer customer = new CustomerA(1, 2);
		Register register = customer.chooseRegister(data.groceryWithTwoEmptyRegisters);
		assertEquals(register,data.groceryWithEmptyRegister.getRegister(2));
	}
}
