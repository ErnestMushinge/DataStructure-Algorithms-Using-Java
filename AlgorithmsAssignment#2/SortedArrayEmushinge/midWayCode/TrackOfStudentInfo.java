import java.util.Scanner;

/*Name: 
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
	private int size = Size;
	String name;
	int IdNumber;
	int totalGrades;
	int NumOfStudents;
	int GradePointAverage;

	// this is the conversion type, String to integer
	int TotalGrades;
	int numOfStudents;
	// int Size;

	///////////////
	public int next = 0;// this was next; not = 0;
	private int low;
	private int high;
	private int i;

	// this is the Array to track students objects
	TrackOfStudentInfo[] studentsArray;
	// Scanner for input from the user
	Scanner scan = new Scanner(System.in);

	public TrackOfStudentInfo() {

		super(Size);

		System.out.println("Enter a maxmum size of data set (size of array)");
		size = scan.nextInt();

		System.out.println("Enter the initial number of students(#ofStudents)");
		NumOfStudents = scan.nextInt();

		System.out.println("Enter the initial data set (total grades)");
		totalGrades = scan.nextInt();

	}
	
	//The reason I created this method is to call the input() the number of array size
	//and inserting in the array
	
	public void finalInput()
	{
		for(int t = 0; t < size; t++)
		{
			StudentListings lst = new StudentListings();
			lst.input();
			insertRevised(lst);
		}
	}
	// TESTING INSERT METHOD HERE

	public boolean insertRevised(StudentListings student) {

		int _low;
		int _high;
		int _i;

		_low = 0;
		// next has to be a global valuable
		_high = next - 1;

		// Checking to see if the array is empty
		if (next == 0)// this statement has to be true
		{
			students[next] = student.deepCopy();
			// then we want to increment next
			next = next + 1;
			// return true if successful
			return true;
		}

		// here we are comparing against student in first index
		if (student.compareTo(students[0].name) < 0)// that means it's -1 and
													// the name of student
													// inserted is not in the
													// array
		{
			for (int j = next; j > 0; j--)// at this point j = next that is
											// next+1 already so, j>0 which is
											// true
			{
				students[j] = students[j - 1];
			}

			students[0] = student.deepCopy();
			next = next + 1;
			return true;

		}

		// One last age case
		if (student.compareTo(students[next - 1].name) > 0) {
			students[next] = student.deepCopy();
			next = next + 1;
			return true;
		}

		// this will start a loop in the middle of an array
		// it will know whether to loop up(high) or down (low) the array
		// this cuts time in half the loops takes
		_i = (_low + _high) / 2;

		// This loop here will compare a name from a student being inserted
		// toREMEMBER TO PUT BACK ! IN FRONT OF STUDENT.COMPARETO
		// students in the array
		while ((student.compareTo(students[_i].name) < 0) && student.compareTo(students[_i - 1].name) > 0)

		{
			// This code below seeks to see if the integer returned from
			// compareTo() is -1 or 1 to go ahead
			if (student.compareTo(students[_i].name) < 0) {
				_high = _i - 1;// move high down to eliminate the lower half of
								// the array
			} else {
				_low = _i + 1;// move low up to eliminate the lower half of the
								// array
			}

			// this line ins coded twice in an original algorithm
			_i = (_high + _low) / 2;

			// Move all the nodes down to " open up" a spot for the new node

			for (int J = next; J >= _i; J--) {
				students[J] = students[J - 1];
			}

			next = next + 1; // prepares for next insert(index)
			// Add a deep copy of new node to the structure
			students[_i] = student.deepCopy();
			// my own code

		}

		return true;
	}
	// END TESTING

	// THE REAL INSERT HERE

	// To be deleted//I changed void to boolean
	public boolean insert(StudentListings student) {

		low = 0;
		high = next - 1;

		// this will start a loop in the middle of an array
		// it will know whether to loop up(high) or down (low) the array
		// this cuts time in half the loops takes
		i = (low + high) / 2;

		// MY OWN CODE HERE
		// input();
		// this is to insert at least 2 objects
		// if(students[i] == null)
		// {
		// students[i] = student;
		// }

		// MY OWN OCODE HERE TO BE DELETED
		// I was trying to come up with an algorithm that inserts in an empty
		// array
		// for (int k = 0; k < 3; k++) {
		// // if (next < students.length) {
		//
		// students[k] = student;
		// System.out.println("Object added at index " + students[k] + "\n " +
		// "_______________________" + "\n");
		// //f++;
		// }
		// for (int k = next; k < (students.length-1); k++) {
		// students[k] = student;
		// System.out.println("K inserted successfully");
		// }

		for (int m = next; m < students.length; m++) {
			// input();
			// if (next >= Size1 && students[next] ==null)
			// return false;
			students[next] = student;
			System.out.println("insert successful");
			next = next + 1;

			// This loop here will compare a name from a student being inserted
			// to
			// students in the array
			while (!(student.compareTo(student.name) < students[i].compareTo(students[i].name)))

			{
				// This code below seeks to see if the integer returned from
				// compareTo() is -1 or 1 to go ahead
				if (student.compareTo(student.name) < students[i].compareTo(students[i].name)) {
					high = i - 1;// move high down to eliminate the lower half
									// of
									// the array
				} else {
					low = i + 1;// move low up to eliminate the lower half of
								// the
								// array
				}

				// this line ins coded twice in an original algorithm
				i = (high + low) / 2;

				// Move all the nodes down to " open up" a spot for the new node

				for (int J = next; J >= i; J--) {
					students[J] = students[J - 1];
				}

				next = next + 1; // prepares for next insert(index)
				// Add a deep copy of new node to the structure
				students[i] = student.deepCopy();
				// my own code

			}

		}
		return true;
	}
	// INSERT ENDS

	// I will implement an insert method to insert Students objects into
	// an Array

	public boolean insert1(StudentListings student) {
		// I will prompt the user to insert a new student then store the new
		// student in a Students array in Sorted array structure class
		// student.input();
		low = 0;
		high = next - 1;

		// this will start a loop in the middle of an array
		// it will know whether to loop up(high) or down (low) the array
		// this cuts time in half the loops takes
		i = (low + high) / 2;

		// if (next < students.length) {
		//
		// students[next] = student;
		// System.out.println("Object added at index " + students[next] + "\n "
		// + "_______________________" + "\n");
		// next++;
		// }
		// THIS LOOP WILL INSERT 3 students to start with
		for (int k = 0; k < 3; k++) {

			students[k] = student;
			System.out.println(
					"Object added at index  " + students[k].toString() + "\n " + "_______________________" + "\n");
			next++;
		}

		if (student.compareTo(student.name) < students[i].compareTo(students[i].name)) {

			high = i - 1;// move high down to eliminate the lower lower half
							// of the array
		} else {
			low = i + 1;// move low up to eliminate the lower lower half of
						// the array
		}

		for (int J = next; J >= i; J--) {
			students[J] = students[J - 1];
		}

		next = next + 1; // prepares for next insert(index)
		// Add a deep copy of new node to the structure
		students[i] = student.deepCopy();
		return true;

	}

	// END OF BINARY INSERT METHOD

	// This is unsorted insert method IS
	public boolean insert2(StudentListings student2) {
		if (next >= Size)
			return false;
		students[next] = student2.deepCopy();
		System.out.println("insert successful at" + students[next]);

		if (students[next] == null)
			return false;
		next = next + 1;
		return true;
	}

	// TO BE DELETED
	// this is unsorted insert
	public boolean insert3(StudentListings student2) {

		if (next >= Size)
			return false;
		students[next] = student2.deepCopy();

		if (students[next] == null)
			return false;
		next = next + 1;
		return true;
	}

	// to be deleted
	// new insertTobe deleted
	private int it = 0;

	public void add(StudentListings a) {

		if (it < students.length) {

			students[it] = a;
			System.out.println("Object added at index  " + students[it] + "\n " + "_______________________" + "\n");
			it++;
		}

	}

	// I have to create a method that calculates Student gradePointAverage
	public int StudentPointAverage(int totalAveragePoint) {
		int TotalPointAverage = 0;
		totalAveragePoint = TotalPointAverage;
		TotalPointAverage = numOfStudents / TotalGrades;

		return TotalPointAverage;
	}

	// We will be fetching from StudentListing Array called students and output
	// the student information
	// THAT IS WHY I DECIDED TO FETCH A NODE NOT A STRING
	public StudentListings fetch(StudentListings node) {

		low = 0;
		high = next - 1;
		i = (low + high) / 2;
		while (node.name != students[i].name)// come back here and put !=
												// instead ==I SORTED IT OUT
		{
			if (node.compareTo(name) < students[i].compareTo(name) && high != low) {
				high = i - 1;
			} else {
				low = i + 1;
			}
			i = (low + high) / 2;
		}

		return students[i].deepCopy();// fetch

	}

	// This method will access the nodes in the students array using
	// sequential/binary search

	public boolean delete(StudentListings StudentObj) {

		/// ACCESS THE NODE USING BINARY SEARCH
		low = 0;
		high = next - 1;
		i = (low + high) / 2;
		while (StudentObj.name != students[i].name) {
			if (StudentObj.compareTo(name) < students[i].compareTo(name) && high != low) {
				high = i - 1;
			} else {
				low = i + 1;
			}
			i = (low + high) / 2;
		}

		// deletion occurs here
		// Move all the reference up to delete the node and collect garbage
		for (int j = i; j < next - 1; j++) {
			students[j] = students[j - 1];
		}
		next = next - 1;
		students[next] = null;
		// My code here
		return true;

	}

	// I HAVE TO WORK ON THIS UPDATE METHOD TO USE A SORTED ARRAY
	// This method will update the student array
	public boolean update(StudentListings name, StudentListings newStudent) {
		// to update an array with a student
		if (delete(name) == false)// node not into structure
			return false;
		else if (insert(newStudent) == false)// in case of insufficient
			// memory
			return false;
		else
			return true; // node found and updated

	}

	// This method will exit the program
	public void exit() {
		// to exit the program
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
			// insert();
			// size = JOptionPane.showInputDialog("Enter a maximum size of data
			// set");
			StudentListings st = new StudentListings();
			st.input();
			insert(st);

			break;
		case 2:
			StudentListings fetchKey;
			System.out.println(" Enter a name of a student to fetch");
			// fetchKey.name = scan.next();
			// fetch(fetchKey);
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
			// output();THINK ABOUT THIS TOO
			SortedArrayStructure k = new SortedArrayStructure();
			// k.showAll();
			break;
		case 6:
			exit();
			break;

		}

	}

}
