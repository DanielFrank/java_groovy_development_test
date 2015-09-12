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
	
	/** Checks if all the registers have empty customer lines
	 * @return true unless any register has a customer
	 * */
	public boolean checkAllRegistersEmpty(){
		for (int i = 0; i < registers.length; i++) {
			if (registers[i].getCustomerCount()>0) return false;
		}
		return true;
	}
	
	/** Gets register with least number of Customers
	 * Returns lower number register all else being equal
	 * @return Register
	 * */
	public Register getShortestLine() {
		Register result = registers[0];
		if (result.getCustomerCount() == 0) return result;
		for (int i = 1; i < registers.length; i++) {
			if (registers[i].getCustomerCount() < result.getCustomerCount()) {
				result = registers[i];
				if (result.getCustomerCount() == 0) return result;
			}
		}
		return result;
	}
	
	/** Gets register with last customer having least number of items
	 * Returns lower number register all else being equal
	 * @return Register
	 * */
	public Register getLineWithCustomerLastLeastItems() {
		Register result = registers[0];
		if (result.getCustomerCount() == 0) return result;
		for (int i = 1; i < registers.length; i++) {
			if (registers[i].getCustomerCount() == 0) return registers[i];
			if (registers[i].getLastCustomer().getItemCount() < result.getLastCustomer().getItemCount()) {
				result = registers[i];
			}
		}
		return result;
	}
	
	/** Loop through Registers and run minutePass on them all
	 * 
	 */
	public void minutePass() {
		for (int i = 0; i < registers.length; i++) {
			registers[i].minutePass();
		}
	}

	

	
}
