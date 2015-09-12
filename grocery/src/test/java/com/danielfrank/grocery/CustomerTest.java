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
	
}
