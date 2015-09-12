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
	
	/**
	 * Tests that lastCustomer is correct and that it does not remove customer
	 */
	public void testLastCustomer(){
		Register testRegister = new Register(new Cashier());
		Customer firstCustomer = new CustomerA(1,12);
		Customer testCustomer2 = new CustomerA(2,15);
		testRegister.addCustomer(firstCustomer);
		testRegister.addCustomer(testCustomer2);
		//first customer is same object as customer inserted first
		assertTrue(testCustomer2 == testRegister.getLastCustomer());
		//first customer was not removed
		assertTrue(testCustomer2 == testRegister.getLastCustomer());
	}
	
	/**
	 * Tests that when a minute passes and the customer no longer has items,
	 * that the customer is removed from the line.
	 * Assumes Cashier serves a customer per minute.
	 * (And yes I should mock up a cashier to ensure that result but I'm not 100% familiar with Java's mock platforms)
	 */
	public void testCustomerRemovedIfNoItems(){
		Register testRegister = new Register(new Cashier());
		Customer firstCustomer = new CustomerA(1,1);
		Customer secondCustomer = new CustomerA(2,15);
		testRegister.addCustomer(firstCustomer);
		testRegister.addCustomer(secondCustomer);
		testRegister.addCustomer(new CustomerA(3,11));
		testRegister.minutePass();
		assertTrue(firstCustomer != testRegister.getFirstCustomer());
		assertTrue(secondCustomer != testRegister.getFirstCustomer());
	}

	
}
