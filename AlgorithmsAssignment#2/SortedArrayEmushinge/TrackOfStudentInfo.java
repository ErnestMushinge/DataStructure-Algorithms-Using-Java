import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 2/11/2016
 * Course#: IT 2660
 * Assignment#: 2
 *
 *This data structure class will keep track of student information
 *at college. Names, identification numbers, and grade point average in 
 *a fully encapsulated (homogeneous) Sorted array-based data structure. 
 *When launched the user will be asked to input the maximum size
 *of the data set, the initial number of students,and the initial data set.  
 */

public class TrackOfStudentInfo extends SortedArrayStructure {

	// I have to initialize the Size because what if the user doesn't specify
	// size
	private static int Size;
	private int size;

	String name;
	int IdNumber;
	int totalGrades;
	int NumOfStudents;
	int GradePointAverage;

	// this is the conversion type, String to integer
	int TotalGrades;
	int numOfStudents;

	public int next = 0;// this was next; not = 0;
	private int low;
	private int high;
	private int i;

	// this is the Array to track students objects
	// TrackOfStudentInfo[] studentsArray;
	// Scanner for input from the user
	Scanner scan = new Scanner(System.in);
	// StudentListings listing;
	// StudentListings List;

	public TrackOfStudentInfo() {

		// super(Size);

		System.out.println("Enter a maxmum size of data set (size of array)");
		size = scan.nextInt();
		size = Size;

		System.out.println("Enter the initial number of students(#ofStudents)");
		NumOfStudents = scan.nextInt();

		System.out.println("Enter the initial data set (total grades)");
		totalGrades = scan.nextInt();

		// This code is to prompt the user to enter data for an array
		// depends on the size entered
		// for(int v = 0; v<size;v++){
		// StudentListings listing = new StudentListings();
		// listing.input();
		//
		// insertRevised(listing);
		// }

		askUser();

	}

	// I have to create a method that calculates Student gradePointAverage
	public int StudentPointAverage(int totalAveragePoint) {
		int TotalPointAverage = 0;
		totalAveragePoint = TotalPointAverage;
		TotalPointAverage = numOfStudents / TotalGrades;

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
				+ "         5 to output all student's information in sorted order\n" + "         6 to exit a program");

		// To collect the input from user and convert it to integer
		// If I used JOptionPane I would have parsed the input, but
		// System.Scanner does all that for me
		ConvertUserEntry = scan.nextInt();

		switch (ConvertUserEntry) {
		case 1:

			StudentListings st = new StudentListings();
			SortedArrayStructure nw = new SortedArrayStructure();
			st.input();
			nw.insertRevised(st.deepCopy());
			System.out.println(" You inserted " + st.name + " into an array");

			break;
		case 2:

			StudentListings sk = new StudentListings();
			SortedArrayStructure sl = new SortedArrayStructure();

			String fetchKey;
			System.out.println(" Enter a name of a student to fetch");
			fetchKey = scan.nextLine();
			// I want to compare the name entered to the names in the array
			// then fetch the object with the name entered
			if (sk.compareTo(fetchKey) == sk.compareTo(students[next].name))

				// fetchKey = sk.name;
				sl.fetch(sk);
			break;
		case 3:
			// here
			String nameToDelete;

			System.out.println("Enter a name of a student to delete");
			nameToDelete = scan.next();
			// delete(nameToDelete);
			break;
		case 4:
			// I decided to instantiate a new student object
			StudentListings newStudent = new StudentListings();
			String nameToBeUpDatedOn = "";
			System.out.println(" Enter name to be updated ");
			nameToBeUpDatedOn = scan.next();
			// update(nameToBeUpDatedOn, newStudent);
			break;
		case 5:

			// check if the array in null

			output();
			System.out.println(" Sorry the array is empty, please insert a student");

			// SortedArrayStructure k = new SortedArrayStructure();
			// k.showAll();
			break;
		case 6:

			exit();
			break;

		}

	}

}
