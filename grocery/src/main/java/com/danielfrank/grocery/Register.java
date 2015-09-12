package com.danielfrank.grocery;

import java.util.LinkedList;

public class Register {
	Cashier cashier;
	LinkedList<Customer> checkOutLine;
	
	public Register(Cashier cashier) {
		this.cashier = cashier;
		checkOutLine = new LinkedList<Customer>();
	}

	/** add Customer to end of line 
	 * @param the customer in question
	 * */
	public void addCustomer(Customer c) {
		checkOutLine.add(c);
	}
	
	/** returns number of customers on line 
	 * @return number of customers
	 * */
	public int getCustomerCount(){
		return checkOutLine.size();
	}
	
	/** returns first customer on line (w/o removing him)
	 * Assumes not called if no customers
	 * @return first customer
	 * */
	public Customer getFirstCustomer(){
		return checkOutLine.peekFirst();
	}
	
	/** returns last customer on line (w/o removing him)
	 * Assumes not called if no customers
	 * @return last customer
	 * */
	public Customer getLastCustomer(){
		return checkOutLine.peekLast();
	}

}
