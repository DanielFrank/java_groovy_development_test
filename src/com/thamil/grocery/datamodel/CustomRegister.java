package com.thamil.grocery.datamodel;

import java.util.Comparator;

/** 
 * The CustomRegister class is for register the customer
 * in grocery store / cashier line simulation.
 * @author  Thamilvanan R
 * @version 1.0
 * @since   01-07-2005 
 */
public class CustomRegister implements Comparable<CustomRegister> {

	private Integer index;
	private Integer size;
	
	public static final Comparator<CustomRegister> indexComparator = new Comparator<CustomRegister>() {

		@Override
		public int compare(CustomRegister sortObject1, CustomRegister sortObject2) {
			return sortObject1.getIndex().compareTo(sortObject2.getIndex());
		}
	};

	public CustomRegister(Integer index, Integer size) {
		this.index = index;
		this.size = size;
	}
	
	public Integer getIndex() {
		return index;
	}
	public Integer getSize() {
		return size;
	}
	
	@Override
	public int compareTo(CustomRegister sortObject) {
		return this.getSize().compareTo(sortObject.getSize());
	}
	
}
