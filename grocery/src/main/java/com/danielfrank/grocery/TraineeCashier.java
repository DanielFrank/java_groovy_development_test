package com.danielfrank.grocery;

/**
 * Trainee Cashier class
 * Difference is Cashier checks out one item per minute whereas trainee checks out item every two minutes
 */

public class TraineeCashier extends Cashier {
	/** Measures whether it's time to check out an item */
	private boolean	otherMinute = false;
	
	/** check out a customer's item every other call 
	 * (assumes called every minute that there's a customer)
	 * @param the Customer in question
	 * */
	public void serveCustomer(Customer customer){
		if (otherMinute) customer.checkOutItem();
		otherMinute = !otherMinute; 
	}

	
}
