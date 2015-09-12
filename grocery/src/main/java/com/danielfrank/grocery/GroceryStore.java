package com.danielfrank.grocery;

public class GroceryStore {
	
	private Register[] registers;
	
	public GroceryStore(int numStores){
		registers = new Register[numStores];
		for (int i = 0; i < registers.length; i++) {
			registers[i] = new Register(new Cashier());
		}
	}
	
	public int getRegisterCount() {
		return registers.length;
	}
	

}
