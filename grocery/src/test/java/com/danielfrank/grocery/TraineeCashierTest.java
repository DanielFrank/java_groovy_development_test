package com.danielfrank.grocery;

import junit.framework.TestCase;

public class TraineeCashierTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests Cashier decrements customer item count every other call to serveCustomer
	 */
	public void testCashierServeCustomers(){
		CustomerA myCustomer = new CustomerA(1, 12);
		TraineeCashier myCashier = new TraineeCashier();
		//minute 1
		myCashier.serveCustomer(myCustomer);
		assertEquals(12, myCustomer.getItemCount());
		//minute 2
		myCashier.serveCustomer(myCustomer);
		assertEquals(11, myCustomer.getItemCount());
		//minute 3
		myCashier.serveCustomer(myCustomer);
		assertEquals(11, myCustomer.getItemCount());
		//minute 4
		myCashier.serveCustomer(myCustomer);
		assertEquals(10, myCustomer.getItemCount());
	}
	
	
}
