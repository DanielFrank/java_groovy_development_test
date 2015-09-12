package com.danielfrank.grocery;

import junit.framework.TestCase;

public class CustomerFactoryTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**Tests Customer A is returned with correct values*/
	public void testCustomerALine(){
		String line = "A 10 12";
		Customer customer = CustomerFactory.createCustomer(line);
		
		assertEquals(10, customer.getArrivalTime());
		assertEquals(12, customer.getItemCount());
		assertTrue(customer instanceof CustomerA );
	}

	/**Tests Customer A is returned with correct values*/
	public void testCustomerBLine(){
		String line = "B 13 11";
		Customer customer = CustomerFactory.createCustomer(line);
		
		assertEquals(13, customer.getArrivalTime());
		assertEquals(11, customer.getItemCount());
		assertTrue(customer instanceof CustomerB );
	}

}
