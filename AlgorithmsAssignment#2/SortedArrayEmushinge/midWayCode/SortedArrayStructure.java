import java.util.Scanner;

/*Name: 
 * Date: 2/11/2016
 * Course#: IT 2660
 * Assignment#: 2
 *
 *This data structure class will store data from
 *StudentListings class. It will contain error checking
 *in the code of a basic operation methods.
 *It will contain a constructor to permit a client to specify
 *the maximum size of the data set and a method
 *to display the content of the entire data set in a sorted array
 */

public class SortedArrayStructure extends StudentListings {

	protected StudentListings[] students;

	

	public SortedArrayStructure(int specifySize) {

		super();

		students = new StudentListings[specifySize];
	}
	
	public SortedArrayStructure() {
		// Empty constructor
	}

	// This method will output all the student information in the sorted order
	public void output() {
		for (int f = 0; f < students.length; f++) 
		{
			System.out.println(students[f].toString() + ", from an array in the sorted order");

		}
	}

	// Main method
	public static void main(String[] args) {

		// SortedArrayStructure sa = new SortedArrayStructure(7);
TrackOfStudentInfo f = new TrackOfStudentInfo();

		SortedArrayStructure st = new SortedArrayStructure();
		// StudentListings lt = new StudentListings();
		// StudentListings lk = new StudentListings();
		//StudentListings lb = new StudentListings("Arnest Mushinge1", 9, 7);
		// st.add(lb);
		// f.insert2(lb);
		// f.insert(lb);
		//st.students[0] = lb;
		//StudentListings lb1 = new StudentListings("Cark mub3", 8, 20);
		// st.add(lb1);
		// f.insert(lb1);
		//st.students[1] = lb1;
		//StudentListings lb2 = new StudentListings("Bitos2", 4, 50);

		// st.add(lb2);
		// f.insert2(lb2);
		// f.insert(lb2);
		//st.students[2] = lb2;

		StudentListings lb3 = new StudentListings();
		lb3.input();
		f.insertRevised(lb3);
		StudentListings lb4 = new StudentListings();
		lb4.input();
		f.insertRevised(lb4);
		StudentListings lb5 = new StudentListings();
		// st.add(lb3);
		// f.insert2(lb3);
		// f.insert(lb3);
		//st.students[3] = lb3;

		// lt.input();
		// lk.input();
		// sa.insert1(lt);
		// sa.insert1(lk);

		
		
		lb5.input();
		f.insertRevised(lb5);
		st.output();	
		
		// st.showAll();

	}

}
