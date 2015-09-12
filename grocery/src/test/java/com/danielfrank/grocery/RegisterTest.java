package com.danielfrank.grocery;

import junit.framework.TestCase;

public class RegisterTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests that customer gets added
	 */
	public void testAddCustomer(){
		Register testRegister = new Register(new Cashier());
		Customer testCustomer = new CustomerA(1,1);
		testRegister.addCustomer(testCustomer);
		assertEquals(1, testRegister.getCustomerCount());
	}

	/**
	 * Tests that firstCustomer is correct and that it does not remove customer
	 */
	public void testFirstCustomer(){
		Register testRegister = new Register(new Cashier());
		Customer firstCustomer = new CustomerA(1,12);
		Customer testCustomer2 = new CustomerA(2,15);
		testRegister.addCustomer(firstCustomer);
		testRegister.addCustomer(testCustomer2);
		//first customer is same object as customer inserted first
		assertTrue(firstCustomer == testRegister.getFirstCustomer());
		//first customer was not removed
		assertTrue(firstCustomer == testRegister.getFirstCustomer());
	}
	
	
}
