
import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 04/21/2016
 * Course#: IT 2660
 * Assignment#: 7
 *
 *This program keeps track of students at college that will be stored in a binary tree
 *it includes there names, identification numbers and grade points in a fully encapsulated,
 *homogeneous, linked-based binary search tree
 * 
 */

public class KeepsTrackOfStudents  {

	String name;
	int IdNumber;
	int totalGrades;
	int NumOfStudents;
	int GradePointAverage;
	//int InitialDataSet;
	//this is the name of student to fetch
	String fetchKeyName;
	Scanner scanInt = new Scanner(System.in);
	Scanner scanStr = new Scanner(System.in);
	
	
	 StudentClass student = new StudentClass();
	 BinaryTreeWithLNRTraversal binaryTree = new BinaryTreeWithLNRTraversal();

	 //constructor
	public KeepsTrackOfStudents() {

       student.ProgrammerName();
		//this numbers here will be used to calculate the average number/grades
		//System.out.println("Enter the initial number of students");
       // NumOfStudents = scanInt.nextInt();

		//I don't understand this
		//System.out.println("Enter the initial data set");
		// InitialDataSet = scanInt.nextInt();

		
		//This code will prompt the user the number of times of a data set
		 //and insert the node list into SinglyLinkedList
		
//         for(int i = 0; i < InitialDataSet;i++)
//           {
//	          Listing list = new Listing();
//	          
//	          list.input();
//	          linked.insert(list);
//	         
//          }
       //Am calling askUser() method
		askUser();

	}

	// I have to create a method that calculates Student gradePointAverage
//	public int StudentPointAverage(int totalAveragePoint) {
//		int TotalPointAverage = 0;
//		totalAveragePoint = TotalPointAverage;
//		TotalPointAverage = NumOfStudents / totalGrades;
//
//		return TotalPointAverage;
//	}

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
		
			student.input();
			binaryTree.insert(student.deepCopy());
			//Since traversing a tree to show all nodes can take a little bit of time
			//I wouldn't show all nodes unless it's necessary
			//binaryTree.showAll();
			System.out.println("\n________________________________________\n");
			askUser();

			break;
		case 2:
			StudentClass sk;
			System.out.println(" Enter a name of a student to fetch");
			fetchKeyName = scanStr.nextLine();
			sk = binaryTree.fetch(fetchKeyName);
			//if the name is not in the Linked binary tree, out put should be "Node not in the structure"
			//I THINK CODE BELOW IS ALREADY IMPLEMENTED IN BinaryTreeWithLNTraversal
			if(!(sk == null)){
			System.out.println("The Student fetched is :\n______________________________________\n" + sk.toString());//we want to store the returned deepCopy in sk of type Listing
			}
			
			else if(fetchKeyName!=sk.getKey())
			{
				System.out.println("Node not in the tree structure");
			}
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 3:
			String nameToDelete;
			System.out.println("Enter a name of a student to be deleted");
			nameToDelete = scanStr.nextLine();
			//We want to pass that name to be compared among stored names
			binaryTree.delete(nameToDelete);
			
			//This code will display only if delete is = false if not it will display else bloke
//			if(binaryTree.delete(nameToDelete)== false)
//			{
//				//We want to show that indeed it was deleted by printing every node in the SinglyList
//				System.out.println("Node Not in the structure");
//			
//				
//				
//			}
//			else
//			{
//				System.out.println("Delete Successfull"+"\n________________________________________\n"+ nameToDelete.toString() + "  Was Deleted from a binary tree\n");
//				//binaryTree.showAll();
//				
//			}
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 4:
			String nameToBeUpDatedOn;
			System.out.println(" Enter name to be updated on");
			nameToBeUpDatedOn = scanStr.nextLine();
			// We what to call the UpDate Method from sh
			//I HAVE TO COME BACK AND SEE IF IT WORKS, AM NOT SURE ABOUT sw
			StudentClass newNode = new StudentClass();
			newNode.input();
			
			//we want to show that it was updated
		     
		   //This code will display only if Update is successful if not it will display else bloke
				if(!(nameToBeUpDatedOn==null))
				{
					
					//I want to put newNode into the linked list
					binaryTree.update(nameToBeUpDatedOn, newNode);
					//We want to show that indeed it was deleted by printing every node in the SinglyList
					System.out.println("Update successful");
					binaryTree.showAll();	
				}
				if ((nameToBeUpDatedOn == null))
				{
					System.out.println("Node not in the structure\nSelect another option");
					
				}
				
				System.out.println("\n________________________________________\n");
				
				binaryTree.showAll();
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 5:
			System.out.println(" These are all the students from the list \n________________________________________\n");
			binaryTree.showAll();
			System.out.println("\n________________________________________\n");
			askUser();
			break;
		case 6:
            //WORKING
			exit();
			break;

		}

	}

}


