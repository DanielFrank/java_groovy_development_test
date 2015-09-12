package com.danielfrank.grocery;

public class GroceryStore {
	
	private Register[] registers;
	
	/** creates store with numRegisters registers.
	 * The last register is staffed with a trainee cashier
	 * @param number of Registers
	 * */
	public GroceryStore(int numRegisters){
		registers = new Register[numRegisters];
		for (int i = 0; i < registers.length -1; i++) {
			registers[i] = new Register(new Cashier());
		}
		registers[registers.length-1] = new Register(new TraineeCashier());
	}

	/** Gets Register "#number".
	 * Assumes valid number 
	 * @param which Register to get
	 * @return the Register in question
	 * */
	public Register getRegister(int number){
		return registers[number-1];
	}
	
	public int getRegisterCount() {
		return registers.length;
	}
	

	
}
