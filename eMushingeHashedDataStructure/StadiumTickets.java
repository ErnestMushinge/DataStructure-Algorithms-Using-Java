
/*Name: Ernest Mushinge
 * Date: 3/29/2016
 * Course#: IT 2660
 * Assignment#: 5
 *
 *This class represents a Ticket Node
 *this class will be stored in the Direct Hashing data structure
 *also known as Perfect Hashed Structure
 *
 * 
 */

import java.util.Scanner;

public class StadiumTickets {

	private String name; // key field
	// private String address;
	private int number;

	Scanner intM = new Scanner(System.in);
	Scanner StringM = new Scanner(System.in);

	// Empty Constructor
	public StadiumTickets() {
	}

	// Constructor
	public StadiumTickets(String n, int num) {
		name = n;
		number = num;
	}

	// Programmer defined toString() method
	public String toString() {
		return ("Customer Name is " + name + " and Ticket Number is " + number + "\n");
	}

	// This method will allow the user to input data,
	// there is no need to parse the data because the
	// variables are integers already and in.nextInt parses the value into
	// integer
	public void input() {

		// BasicOperations bn = new BasicOperations();
		System.out.println(" Enter a name ");
		name = StringM.nextLine();
		// System.out.println(" Enter Ticket Number Starting From 2000");
		getInt();
	
	}

	// This method below encapsulates the input to get integers only from the
	// user
	// and not strings
	// Gets the next integer from the console.
	public int getInt() {

		System.out.print("Please enter a Ticket Number ");
		
		while (!intM.hasNextInt()) {
			System.out.println("Input is not an integer!");
			intM.next();
			System.out.print("\n_______________________________\n");
			// bn.askUser();
			System.out.println("Please enter a Ticket Number ");// While true, we want to populate number with an integer
			
		}
		number = intM.nextInt();
		
		// if integer is greater 60000 or less than 2000
		while (number < 2000 || number > 60000) {
			System.out.println("Ticket Number must be between 2000 and 60000");
			System.out.print("\n_______________________________\n");
			System.out.println("Please enter a Ticket Number ");
			number = intM.nextInt();
		}
		//number = intM.nextInt();
		return number;

	}

	// deep copy
	public StadiumTickets deepCopy() {
		StadiumTickets clone = new StadiumTickets(name, number);
		return clone;
	}

	// public String getKey() {
	// return name;
	// }

	// This method will return a number that will be
	// used in a preprocessing algorithm to rout a perfect index
	public int getKeyNum() {
		return number;
	}
}// end of class StadiumTickets
