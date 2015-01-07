package com.thamil.grocery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.thamil.grocery.datamodel.Customer;
import com.thamil.grocery.datamodel.CustomerType;
import com.thamil.grocery.datamodel.Grocery;

/** 
 * The GrocerySimulator class implements an application that
 * a grocery store / cashier line simulation.
 * @author  Thamilvanan R
 * @version 1.0
 * @since   01-07-2005 
 */

public class GrocerySimulator {

	Grocery grocery = null;
	private static Queue<Customer> queues = new LinkedList<Customer>();

	public GrocerySimulator(Grocery grocery) {
		this.grocery = grocery;
	}

	public Grocery getGrocery() {
		return grocery;
	}

	public void setGrocery(Grocery grocery) {
		this.grocery = grocery;
	}

	public Queue<Customer> getCustomers() {
		return queues;
	}

	//Main method
	public static void main(String[] args) {
		validateTheInput(args);
		GrocerySimulator simulator = initSimulator(args);
		Grocery grocery = simulator.getGrocery();
		int t = 1;
		while (!queues.isEmpty() || grocery.isCustomerWaitingInRegisters()) {
			List<Customer> customersAtNthMinute = new ArrayList<Customer>();
			processTheCustomerArrivedAtSameTime(t, customersAtNthMinute);
			Collections.sort(customersAtNthMinute);
			grocery.assignCustomers(customersAtNthMinute);
			int index = 0;
			while (index < grocery.getRegisters().size()) {
				LinkedList<Customer> register = grocery.getRegisters().get(index);
				if (index == (grocery.getRegisters().size() - 1)) {
					serveCustomerWithTrainee(register);
				} else {
					serveCustomerWithExpert(register);

				}
				index++;
			}
			t++;
		}

		System.out.println("Finished at: t="+t+" minutes");

	}

	//Findout sametime customer arrival time	
	private static void processTheCustomerArrivedAtSameTime(int t,
			List<Customer> customersAtNthMinute) {
		Customer customer = queues.peek();
		while (customer != null && customer.getArrivedAt() == t) {
			customersAtNthMinute.add(queues.poll());
			customer = queues.peek();
		}
	}

	//Normal cashier service
	private static void serveCustomerWithExpert(LinkedList<Customer> register) {
		Customer cust = register.peek();
		if (cust != null && cust.decrementItems() == 0) {
			register.poll();
		}
	}

	//Trainee cashier service
	private static void serveCustomerWithTrainee(LinkedList<Customer> register) {
		Customer cust = register.peek();
		if (cust != null) {
			if (!cust.isServiceStarted()) {
				cust.setServiceStarted(true);
			} else {
				if (cust.decrementItems() == 0) {
					register.poll();
				} else {
					cust.setServiceStarted(false);
				}
			}

		}
	}


	//Initialize Grocery Store Simulator
	private static GrocerySimulator initSimulator(String[] args) {
		GrocerySimulator simulator = null;
		BufferedReader bufferedReader = null;
		Grocery grocery = null;
		try {
			String line;
			int index = 0;
			int totalRegisters = 0;
			bufferedReader = new BufferedReader(new FileReader(
					new File(args[0])));
			while ((line = bufferedReader.readLine()) != null) {
				if (index == 0) {
					totalRegisters = readTheTotalRegisters(line);
				} else {
					Customer customer = readCustomerRecords(line);
					if (null != customer) {
						queues.add(customer);
					}
				}
				index++;
			}
			grocery = new Grocery(totalRegisters);
			simulator = new GrocerySimulator(grocery);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return simulator;
	}

	//Find out number of Registers
	private static int readTheTotalRegisters(String line) {
		int totalRegisters = 0;
		try {
			totalRegisters = Integer.parseInt(line);
		} catch (NumberFormatException exception) {
			showErrorMessage("Error in Parsing Line :" + line);
		}
		return totalRegisters;
	}

	//Find out number of Item for each customer	
	private static Customer readCustomerRecords(String customerRecord)
			throws Exception {
		if (!customerRecord.isEmpty()) {
			String[] lineItem = customerRecord.split(" ");
			if (lineItem.length != 3) {
				showErrorMessage("Line Item should have correct entry: "
						+ lineItem);
			} else {
				CustomerType customerType = null;
				if (lineItem[0].equals(CustomerType.A.name())) {
					customerType = CustomerType.A;
				} else {
					customerType = CustomerType.B;
				}
				return new Customer(customerType,
						Integer.parseInt(lineItem[1]),
						Integer.parseInt(lineItem[2]));
			}
		}
		return null;
	}

	//Validate the input
	private static void validateTheInput(String[] args) {
		if (args.length != 1) {
			showErrorMessage("Enter correct command");
		}
	}
	
	//Show error message if empty
	private static void showErrorMessage(String message) {
		System.out.println(message);
		System.exit(-1);
	}

}
