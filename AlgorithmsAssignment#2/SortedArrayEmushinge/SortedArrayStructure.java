import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 2/11/2016
 * Course#: IT 2660
 * Assignment#: 2
 *This data structure class will store data from
 *StudentListings class. It will contain error checking
 *in the code of a basic operation methods.
 *It will contain a constructor to permit a client to specify
 *the maximum size of the data set and a method
 *to display the content of the entire data set in a sorted array
 */

public class SortedArrayStructure extends StudentListings {

	public int next = 0;// this was next; not = 0;
	private int low;
	private int high;
	private int i;

	protected StudentListings[] students;
	Scanner ns = new Scanner(System.in);
	// StudentListings newStudent = new StudentListings();

	public SortedArrayStructure(int specifySize) {

		int Size;
		// to allow user's to specify size of an array
		System.out.println(" Please Enter size of an Array");
		Size = ns.nextInt();
		specifySize = Size;

		students = new StudentListings[specifySize];

		// for(int l = 0; l<students.length;l++)
		// {
		// input();
		// // Checking to see if the array is empty
		// if (next == 0)// this statement has to be true
		// {
		// students[next] = newStudent;
		// // then we want to increment next
		// next = next + 1;
		// // return true if successful
		// //return true;
		// }
		//
		// students[next] = newStudent;
		// insertRevised(newStudent);
		// }
	}

	public SortedArrayStructure() {
		// Empty constructor
	}

	// This method will output all the student information in the sorted order
	public void output() {
		for (int f = 0; f < next; f++) {
			System.out.println(
					students[f].toString() + "\n____________________________\n\nfrom an array in the sorted order");

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
		//The name of student inserted is not an array
		if (student.compareTo(students[0].name) < 0)// that means it's -1 and
											
		{
			// at this point j = next that is
											
			{
				students[j] = students[j - 1];
			}

			students[0] = student;
			next = next + 1;
			return true;

		}

		// One last age case
		if (student.compareTo(students[next - 1].name) > 0) {
			students[next] = student;
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
			students[_i] = student;
			// my own code

		}

		return true;
	}
	// END TESTING

	// We will be fetching from StudentListing Array called students and output
	// the student information
	// THAT IS WHY I DECIDED TO FETCH A NODE NOT A STRING
	public StudentListings fetch(StudentListings node) {

		low = 0;
		high = next - 1;
		i = (low + high) / 2;
		while (node.compareTo(students[i].name) > 0)// come back here and put !=
		// instead ==I SORTED IT OUT
		{
			if (node.compareTo(students[i].name) > 0 && high != low) {
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
		while (StudentObj.compareTo(students[i].name) > 0) {
			if (StudentObj.compareTo(students[i].name) > 0 && high != low) {
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

		return true;

	}

	// I HAVE TO WORK ON THIS UPDATE METHOD TO USE A SORTED ARRAY
	// This method will update the student array
	public boolean update(StudentListings StudentName, StudentListings newStudent) {
		// to update an array with a student
		if (delete(StudentName) == false)// node not into structure
			return false;
		else if (insertRevised(newStudent) == false)// in case of insufficient
			// memory
			return false;
		else
			return true; // node found and updated

	}

	// Main method
	public static void main(String[] args) {

		StudentListings lb3 = new StudentListings();
		lb3.ProgrammerName();
		SortedArrayStructure st = new SortedArrayStructure(100);
		TrackOfStudentInfo f = new TrackOfStudentInfo();

		lb3.input();
		st.insertRevised(lb3);
		StudentListings lb4 = new StudentListings();
		lb4.input();
		 st.insertRevised(lb4);
		 StudentListings lb5 = new StudentListings();
		
		 lb5.input();
		 st.insertRevised(lb5);
		// st.output();
		// st.delete(lb3);
		// st.fetch(lb4);
		st.output();

	}

}
