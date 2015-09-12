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
	
	/** Gets count of Registers
	 * @return count of Registers
	 * */
	public int getRegisterCount() {
		return registers.length;
	}
	
	/** Gets register with least number of Customers
	 * Returns lower number register all else being equal
	 * @return Register
	 * */
	public Register getShortestLine() {
		return registers[0];
	}
	
	/** Gets register with last customer having least number of items
	 * Returns lower number register all else being equal
	 * @return Register
	 * */
	public Register getLineWithCustomerLastLeastItems() {
		return registers[0];
	}
	

	
}
