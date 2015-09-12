package com.danielfrank.grocery;

/**
 * Cashier class
 */
public class Cashier {

	/** check out a customer's item
	 * @param the Customer in question
	 * */
	public void serveCustomer(Customer customer){
		customer.checkOutItem();
	}
}
