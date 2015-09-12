package com.danielfrank.grocery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

/**
 * Given arg of file name, processes file into grocery store and customer list, processes each customer
 * and returns amount of minutes spent
 * 
 * Customers ordered by arrival time, amount of groceries and customer type
 * 
 * Assuming file formatted correctly. Will modify if time allows
 *
 */
public class App 
{
	private static GroceryStore grocerySim;
	private static ArrayList<Customer> customers;
	
    public static void main( String[] args )
    {
    	BufferedReader bufferedReader = null;
    	grocerySim = null;
    	customers = new ArrayList<Customer>();
		try {
			String line;
			bufferedReader = new BufferedReader(new FileReader(new File(args[0])));
			if ((line = bufferedReader.readLine())  != null) {
				grocerySim = new GroceryStore(Integer.parseInt(line));
			}
			while ((line = bufferedReader.readLine()) != null) {
				Customer customer = CustomerFactory.createCustomer(line);
				if (null != customer) {
					customers.add(customer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(customers);
		int index = 0;
		int minute = 1;
		while (index < customers.size()) {
			grocerySim.minutePass(); //Process customers in line
			Customer customer = customers.get(index); 
			//Put any customers in queue that arrived "now"
			while(index < customers.size() && customer.getArrivalTime() == minute) {
				customer.chooseRegister(grocerySim);
				index++;
				if (index < customers.size()) customer = customers.get(index);
			}
			minute++;
		}
		//We've put all the customers in a register line, now process those still in line
		while(!grocerySim.checkAllRegistersEmpty()) {
			grocerySim.minutePass();
			minute++;
		}
		System.out.println("Finished at t="+minute+" minutes");
    }
}
