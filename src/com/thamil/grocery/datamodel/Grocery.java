package com.thamil.grocery.datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** 
 * The Grocery class is for register and assign the customer 
 * in grocery store / cashier line simulation.
 * @author  Thamilvanan R
 * @version 1.0
 * @since   01-07-2005 
 */
public class Grocery {

	private List<Register<Customer>> registers = new ArrayList<Register<Customer>>();

	public List<Register<Customer>> getRegisters() {
		return registers;
	}

	public Grocery(Integer noOfRegisters) {
		for (int i = 0; i < noOfRegisters; i++) {
			registers.add(new Register<Customer>("" + i));
		}
	}

	public Register<Customer> getTheShortestRegister() {
		if (! registers.isEmpty()) {
			List<CustomRegister> registerSortedBySize = sortRegistersBySize();
			List<Register<Customer>> tempRegisters = new ArrayList<Register<Customer>>(registerSortedBySize.size());
			int index = 0;
			int size = 0;
			for (CustomRegister customRegister : registerSortedBySize) {
				if (index == 0) {
					size = customRegister.getSize();
				} else if(size != customRegister.getSize()){
					break;
				}
				tempRegisters.add(registers.get(customRegister.getIndex()));
				index++;
			}
			Collections.sort(tempRegisters);
			return tempRegisters.get(0);
		}
		return null;
	}

	private Register<Customer> sortRegisterByIndex(List<CustomRegister> customRegisters) {
		List<Register<Customer>> tempRegisters = new ArrayList<Register<Customer>>(customRegisters.size());
		for (CustomRegister customRegister : customRegisters) {
			tempRegisters.add(registers.get(customRegister.getIndex()));
		}
		Collections.sort(tempRegisters);
		return tempRegisters.get(0);
	}

	private List<CustomRegister> sortRegistersBySize() {
		List<CustomRegister> registerSortedBySize = new ArrayList<CustomRegister>();
		int index = 0;
		for (Register<Customer> register : registers) {
			registerSortedBySize.add(new CustomRegister(index, register.size()));
			index++;
		}
		Collections.sort(registerSortedBySize);
		return registerSortedBySize;
	}

	public Register<Customer> getTheRegisterWithLeastItemsAtTheEnd() {
		List<CustomRegister> registerOfLessItems = new ArrayList<CustomRegister>();
		List<CustomRegister> emptyRegisters = new ArrayList<CustomRegister>();
		int index = 0;
		for (Register<Customer> register : registers) {
			if (!register.isEmpty()) {
				registerOfLessItems.add(new CustomRegister(index, register.getLast()
						.getItems()));
			} else {
				emptyRegisters.add(new CustomRegister(index, -1));
			}
			index++;
		}
		if (emptyRegisters.size() > 0) {
			sortRegisterByIndex(emptyRegisters);
			return registers.get(emptyRegisters.get(0).getIndex());
		} else {
			return registers.get(registerOfLessItems.get(0).getIndex());
		}
	}
	
	public boolean isCustomerWaitingInRegisters() {
		for (Register<Customer> register : registers) {
			if(!register.isEmpty())  {
				return true;
			}
		}
		return false;
	}
	
	public void assignCustomers(List<Customer> customers) {
		for(Customer customer : customers) {
			if (customer.getCustomerType().equals(CustomerType.A)) {
				Register<Customer> theShortestRegister = getTheShortestRegister();
				theShortestRegister.offer(customer);
			}else {
				Register<Customer> theRegisterWithLeastItemsAtTheEnd = getTheRegisterWithLeastItemsAtTheEnd();
				theRegisterWithLeastItemsAtTheEnd.offer(customer);
			}
		}
	}

}
