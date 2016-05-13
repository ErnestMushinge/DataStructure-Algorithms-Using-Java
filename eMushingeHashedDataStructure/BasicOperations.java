
import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 3/29/2016
 * Course#: IT 2660
 * Assignment#: 5
 *
 *This program presents options to the user to select
 *from the program's four basic method to perform a fuction.
 *
 * 
 */

public class BasicOperations {

	String name;
	int IdNumber;
	int fetchKeyName;
	Scanner scanInt = new Scanner(System.in);
	Scanner scanStr = new Scanner(System.in);

	StadiumTickets node = new StadiumTickets();
	Perfect_Hashed_dataStructure dtStructure = new Perfect_Hashed_dataStructure();

	// Constructor
	public BasicOperations() {
		// to print my name and class information
		System.out.println(Author);
		askUser();

	}

	// Programmer's Name
	// This is the String format for assignment information
	String Author = (" Ernest Mushinge \n" + " Assignment #5 \n" + " IT 2660 Data Structure and Algorithms"
			+ " CRN 15724 \n" + " Due date: 03/30/2016 \n" + " Spring 2016 \n" + " Chapter 5, Exercise 40\n"
			+ "_______________________\n\n");

	// This method will exit the program
	public void exit() {
		// to exit the program
		System.out.println("System shutting down");
		System.exit(0);

	}

	// This method will present the user with option
	public void askUser() {

		int ConvertUserEntry; // fetch, delete,update,output, exit;

		System.out.println(" Enter : 1 to insert a new student's information \n"
				+ "         2 to fetch and output a student's information \n"
				+ "         3 to delete a student's information \n"
				+ "         4 to update a new student's information \n"
				+ "         5 to output all student's information in sorted order\n" + "  "
				+ "       6 to exit a program");

		// To collect the input from user and convert it to integer
		// If I used JOptionPane I would have parsed the input, but
		// System.Scanner does all that for me i.e scan.nextInt()
		ConvertUserEntry = scanInt.nextInt();

		switch (ConvertUserEntry) {
		case 1:

			node.input();
			dtStructure.Insert(node.deepCopy());
			dtStructure.showAll();
			System.out.println("\n________________________________________\n");
			askUser();

			break;
		case 2:
			// This instance of the StadiumTickets will store the returned
			// Ticket node
			StadiumTickets sk;
			System.out.println(" Enter a ticket # to be fetched");
			fetchKeyName = scanInt.nextInt();
			sk = dtStructure.Fetch(fetchKeyName);

			if (!(sk == null)) {
				System.out.println("The ticket fetched is :\n______________________________________\n" + sk.toString());
			} else {
				System.out.println("Ticket not in the structure\tPress 1 to insert");
			}
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 3:
			int nameToDelete;
			System.out.println("Enter a ticket # to delete");
			nameToDelete = scanInt.nextInt();
			// We want to pass that name to be compared among stored names

			// This code will display only if delete is equal to true if not it
			// will display else bloke
			if (!dtStructure.Delete(nameToDelete)) {
				// We want to show that indeed it was deleted by printing every
				// node in the SinglyList
				System.out.println("Node Not in the structure\tPress 1 to insert");

			} else {
				dtStructure.Delete(nameToDelete);
				System.out.println("Delete Successfull" + "\n________________________________________\n"
						+ "Ticket number " + nameToDelete + "  Was Deleted from a structure\n");
				dtStructure.showAll();

			}
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 4:
			int NumberToBeUpDatedOn;

			System.out.println(" Enter a ticket # to be updated on");
			NumberToBeUpDatedOn = scanInt.nextInt();
			// We what to call the UpDate Method from

			StadiumTickets newNode = new StadiumTickets();
			newNode.input();

			// we want to show that it was updated

			// This code will display only if Update is successful if not it
			// will display else bloke
			if (!(newNode == null)) {

				// I want to put newNode into the linked list
				dtStructure.Update(NumberToBeUpDatedOn, newNode);
				// We want to show that indeed it was deleted by printing every
				// node in the SinglyList
				System.out.println("Update successful");
				dtStructure.showAll();
			}

			break;
		case 5:
			System.out.println("\n________________________________________\n");
			dtStructure.showAll();
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 6:
			// System will shut down
			exit();
			break;

		}

	}

}
