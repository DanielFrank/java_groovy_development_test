/**
 * 
 */
package com.danielfrank.grocery;

/**
 * @author danielfrank
 *
 */
public class CustomerB extends Customer {

	/**
	 * @param arrival_time
	 * @param item_count
	 */
	public CustomerB(int arrival_time, int item_count) {
		super(arrival_time, item_count);
		this.setCustomerType("B");
	}
	
	/** Implements chooseRegister for Customer of type B
	 *  Defined as checkout where last customer has least number of items
	 *  Note that specs don't say what to do if two lines have the same least number of items
	 *  Assuming that I should choose lowest register number
	 *  IRL, I would ask if we should consider the number of people on line all-else-being-equal
	 *  
	 *  An empty line is defined as less items than one with a customer that has items
	 * @return Register returned
	 */
	protected Register chooseRegister(GroceryStore g){
		return new Register(new Cashier());
	}


}
