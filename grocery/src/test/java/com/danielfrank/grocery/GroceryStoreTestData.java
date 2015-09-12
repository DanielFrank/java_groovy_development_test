package com.danielfrank.grocery;

public class GroceryStoreTestData {
	public GroceryStore grocery;
	public GroceryStore groceryWithEmptyRegister;
	public GroceryStore groceryWithTwoEmptyRegisters;
	public GroceryStore groceryWithTwoEqualSizedLines;
	public GroceryStore groceryWithTwoEqualSizedLastCustomerItems;

	public GroceryStoreTestData() {
		setUpGrocery();
		setUpGroceryWithEmptyRegister();
		setUpGroceryWithTwoEmptyRegisters();
		setUpGroceryWithTwoEqualSizedLastCustomerItems();
		setUpGroceryWithTwoEqualSizedLines();
		setUpGroceryWithTwoEqualSizedLastCustomerItems();
	}
	
	/**sets up "normal" grocery with two registers
	 * Register 1 has 1 customer with 5 items
	 * Register 2 has 2 customers with 1 items and 4 items
	 */
	protected void setUpGrocery(){
		grocery = new GroceryStore(2);
		grocery.getRegister(2).addCustomer(new CustomerA(1,4));
		grocery.getRegister(2).addCustomer(new CustomerA(1,1));
		grocery.getRegister(1).addCustomer(new CustomerA(1,5));
	}

	/**sets up grocery with three registers
	 * Registers 1 and 2 has 1 customer with 1 item
	 * Register 3 has no customers
	 */
	protected void setUpGroceryWithEmptyRegister(){
		groceryWithEmptyRegister = new GroceryStore(3);
		Customer customer = new CustomerA(1,1);
		groceryWithEmptyRegister.getRegister(2).addCustomer(customer);
		groceryWithEmptyRegister.getRegister(1).addCustomer(customer);
	}

	/**sets up grocery with three registers
	 * Register 2 has 1 customer with 1 item
	 * Registers 1 and 3 has no customers
	 */
	protected void setUpGroceryWithTwoEmptyRegisters(){
		groceryWithTwoEmptyRegisters = new GroceryStore(3);
		Customer customer = new CustomerA(1,1);
		groceryWithTwoEmptyRegisters.getRegister(2).addCustomer(customer);
		groceryWithTwoEmptyRegisters.getRegister(1).addCustomer(customer);
	}
	
	/**sets up "normal" grocery with three registers
	 * Register 2 and register 3 has 2 customers
	 * Register 1 has 3 customers
	 * Total items is equal
	 * Last customer on each line has 6 items
	 */
	protected void setUpGroceryWithTwoEqualSizedLines(){
		groceryWithTwoEqualSizedLines = new GroceryStore(3);
		groceryWithTwoEqualSizedLines.getRegister(2).addCustomer(new CustomerA(1,5));
		groceryWithTwoEqualSizedLines.getRegister(2).addCustomer(new CustomerA(1,6));
		groceryWithTwoEqualSizedLines.getRegister(3).addCustomer(new CustomerA(1,5));
		groceryWithTwoEqualSizedLines.getRegister(3).addCustomer(new CustomerA(1,6));
		groceryWithTwoEqualSizedLines.getRegister(1).addCustomer(new CustomerA(1,2));
		groceryWithTwoEqualSizedLines.getRegister(1).addCustomer(new CustomerA(1,3));
		groceryWithTwoEqualSizedLines.getRegister(1).addCustomer(new CustomerA(1,6));
	}

	/**sets up grocery with three registers
	 * Register 2 has 2 customers, last customer has 6 items
	 * Register 3 has 1 customer with 6 items
	 * Register 1 has 2 customers, last customer has 7 items
	 */
	protected void setUpGroceryWithTwoEqualSizedLastCustomerItems(){
		groceryWithTwoEqualSizedLastCustomerItems = new GroceryStore(3);
		groceryWithTwoEqualSizedLastCustomerItems.getRegister(3).addCustomer(new CustomerA(1,6));
		groceryWithTwoEqualSizedLastCustomerItems.getRegister(1).addCustomer(new CustomerA(1,5));
		groceryWithTwoEqualSizedLastCustomerItems.getRegister(1).addCustomer(new CustomerA(1,7));
		groceryWithTwoEqualSizedLastCustomerItems.getRegister(2).addCustomer(new CustomerA(1,2));
		groceryWithTwoEqualSizedLastCustomerItems.getRegister(2).addCustomer(new CustomerA(1,6));
	}
}