package com.danielfrank.grocery;

import junit.framework.TestCase;

public class CashierTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests Cashier decrements customer item count
	 */
	public void testCashierServeCustomers(){
		CustomerA myCustomer = new CustomerA(1, 12);
		Cashier myCashier = new Cashier();
		myCashier.serveCustomer(myCustomer);
		assertEquals(11, myCustomer.getItemCount());
	}

}
