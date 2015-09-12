/** Creates customers from given strings
 * 
 */
package com.danielfrank.grocery;

/** 
 * @author danielfrank
 *
 */
public class CustomerFactory {
	/** Creates customer from string
	 *
	 * Given a string that's a whitespace-separated.
	 *  Each list specifies the customer type, customer arrival time (in minutes),
	 *   and how many items that customer has respectively
	 *   Assumes correct formatting and types of A or B. Returns null if not A or B
	 * 
	 * @param A whitespace-separated list of values. 
	 *
	 */
	
	static Customer createCustomer(String line){
		String[] tokens = line.split(" ");
		if (tokens[0].equals("A")) {
			return new CustomerA(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
		} else if (tokens[0].equals("B")) {
			return new CustomerB(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
		}
		return null;
		
	}

}
