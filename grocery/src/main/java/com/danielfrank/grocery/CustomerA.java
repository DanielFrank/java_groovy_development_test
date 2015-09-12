/**
 * 
 */
package com.danielfrank.grocery;

/**
 * @author danielfrank
 *
 */
public class CustomerA extends Customer {

	/** Creates Customer of type A
	 *  
	 * @param Time in minutes customer arrived
	 * @param Count of items customer has
	 * @return Customer A
	 */
	public CustomerA(int arrival_time, int item_count) {
		super(arrival_time, item_count);
		this.setCustomerType("A");
	}

	/** Implements chooseRegister for Customer of type A
	 *  Defined as least number of customers (and lowest register number failing that)
	 * @return Register returned
	 */
	protected Register chooseRegister(GroceryStore g){
		return g.getShortestLine();
	}

}
