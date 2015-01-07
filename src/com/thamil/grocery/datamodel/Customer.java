package com.thamil.grocery.datamodel;
/** 
 * The Customer class implements Comparable interface to compare customers
 * in grocery store / cashier line simulation.
 * @author  Thamilvanan R
 * @version 1.0
 * @since   01-07-2005 
 */
public class Customer implements Comparable<Customer>{
	
	private Integer items;
	private CustomerType customerType;
	private Integer arrivedAt;
	private boolean serviceStarted;
	
	public Customer(CustomerType customerType, Integer arrivedAt, Integer items){
		this.customerType = customerType;
		this.arrivedAt = arrivedAt;
		this.items = items;
		
	}

	public Integer getItems() {
		return items;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public Integer getArrivedAt() {
		return arrivedAt;
	}

	public boolean isServiceStarted() {
		return serviceStarted;
	}
	
	

	public void setServiceStarted(boolean serviceStarted) {
		this.serviceStarted = serviceStarted;
	}

	public Integer decrementItems() {
	
			return --this.items;
	
	}
	@Override
	public int compareTo(Customer otherCustomer) {
		String type = customerType.name();
		String otherCust = otherCustomer.customerType.name();
		int value=0;
		if(type!=null && otherCust!=null)
				value = type.compareTo(otherCustomer.customerType.name());
		if (value == 0) {
			return items.compareTo(otherCustomer.items);
		} else {
			return value;
		}
	}
	
	
	@Override
	public String toString() {
		return "\"Type\":"+customerType+";\"ArrivedAt\":"+arrivedAt+";\"items\":"+items;
	}
	

}
