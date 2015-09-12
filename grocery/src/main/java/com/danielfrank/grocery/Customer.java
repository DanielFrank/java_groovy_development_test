package com.danielfrank.grocery;

public abstract class Customer implements Comparable<Customer> {
	private String customerType;
	private int arrivalTime;
	private int itemCount;

	/** Creates Customer of type A
	 *  
	 * @param Time in minutes customer arrived
	 * @param Count of items customer has
	 * @return Customer 
	 */
	public Customer(int arrival_time, int item_count) {
		this.arrivalTime = arrival_time;
		this.itemCount = item_count;
	}

	/** get Customer's Item Count
	 * 
	 * @return Item Count
	 */
	public int getItemCount() {
		return itemCount;
	}
	
	/** Decrement customer's item count by 1
	 * 
	 */
	public void checkOutItem() {
		itemCount--;
	}
	
	/** get Customer's Type
	 * 
	 * @return Customer Type
	 */
	public String getCustomerType() {
		return customerType;
	}

	protected void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
		
	/** Compare customer's
	 * First off of arrival time, then number of items, then customer type
	 * 
	 * @return 0 for equal, -1 for less than, 1 for greater than
	 */
	public int compareTo(Customer o) {
		int retVal = Integer.compare(arrivalTime, o.getArrivalTime());
		if (retVal != 0) return retVal;
		retVal = Integer.compare(itemCount, o.getItemCount());
		if (retVal != 0) return retVal;
		return customerType.compareTo(o.getCustomerType());
	}

	/** Customer chooses register and gets in line
	 */
	public void getInLine(GroceryStore g){
		Register r = chooseRegister(g);
		r.addCustomer(this);
	}

	protected abstract Register chooseRegister(GroceryStore g);
}
