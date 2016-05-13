
import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 2/28/2016
 * Course#: IT 2660
 * Assignment#: 4
 *
 * 
 */

public class KeepsTrackOfStudentInfo {

	String name;
	int IdNumber;
	int totalGrades;
	int NumOfStudents;
	int GradePointAverage;
	int InitialDataSet;
	//this is the name of student to fetch
	String fetchKeyName;
	Scanner scanInt = new Scanner(System.in);
	Scanner scanStr = new Scanner(System.in);
	// StudentListings listing;
	// StudentListings List;
	
	 SinglyLinkedList linked = new SinglyLinkedList();
	 Listing list = new Listing();

	public KeepsTrackOfStudentInfo() {


		//this numbers here will be used to calculate the average number/grades
		System.out.println("Enter the initial number of students(#ofStudents)");
        NumOfStudents = scanInt.nextInt();

		//I don't understand this
		System.out.println("Enter the initial data set");
		 InitialDataSet = scanInt.nextInt();

		
		//This code will prompt the user the number of times of a data set
		 //and insert the node list into SinglyLinkedList
		
         for(int i = 0; i < InitialDataSet;i++)
           {
	          Listing list = new Listing();
	          
	          list.input();
	          linked.insert(list);
	         
          }
       //Am calling askUser() method
		askUser();

	}

	// I have to create a method that calculates Student gradePointAverage
	public int StudentPointAverage(int totalAveragePoint) {
		int TotalPointAverage = 0;
		totalAveragePoint = TotalPointAverage;
		TotalPointAverage = NumOfStudents / totalGrades;

		return TotalPointAverage;
	}

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
				+ "         5 to output all student's information in sorted order\n" 
				+ "         6 to exit a program");

		// To collect the input from user and convert it to integer
		// If I used JOptionPane I would have parsed the input, but
		// System.Scanner does all that for me i.e scan.nextInt()
		ConvertUserEntry = scanInt.nextInt();

		switch (ConvertUserEntry) {
		case 1:
		
			list.input();
			linked.insert(list.deepCopy());
			linked.showAll();
			askUser();

			break;
		case 2:
			Listing sk;
			System.out.println(" Enter a name of a student to fetch");
			fetchKeyName = scanStr.nextLine();
			sk = linked.fetch(fetchKeyName);
			System.out.println("The Student fetched is " + sk.toString());//we want to store the returned deepCopy in sk of type Listing
			askUser();
			break;
		case 3:
			String nameToDelete;
			System.out.println("Enter a name of a student to be deleted");
			nameToDelete = scanStr.nextLine();
			//We want to pass that name to be compared among stored names
			linked.delete(nameToDelete);
			//We want to show that indeed it was deleted by printing every node in the SinglyList
			linked.showAll();
			askUser();
			break;
		case 4:
			String nameToBeUpDatedOn;
			System.out.println(" Enter name to be updated on");
			nameToBeUpDatedOn = scanStr.nextLine();
			// We what to call the UpDate Method from sh
			//I HAVE TO COME BACK AND SEE IF IT WORKS, AM NOT SURE ABOUT sw
			Listing newNode = new Listing();
			newNode.input();
			//I want to put newNode into the linked list
		     linked.update(nameToBeUpDatedOn, newNode);
			//we want to show that it was updated
			linked.showAll();
			askUser();
			break;
		case 5:
			System.out.println(" These are all the students from the list \n________________________________________\n");
			linked.showAll();
	
			askUser();
			break;
		case 6:
            //WORKING
			exit();
			break;

		}

	}

}

