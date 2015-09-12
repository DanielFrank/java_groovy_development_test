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
	 *   (and lowest register number failing that)
	 *   Empty is defined as less items than one with a customer that has items
	 * @return Register returned
	 */
	protected Register chooseRegister(GroceryStore g){
		return new Register(new Cashier());
	}


}
