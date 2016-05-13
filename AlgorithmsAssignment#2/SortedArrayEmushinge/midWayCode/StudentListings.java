import java.util.Scanner;

/*Name: 
 * Date: 2/11/2016
 * Course#: IT 2660
 * Assignment#: 2
 * 
 * This program gets Listing objects and stores them in an array 
 * called threeListing, then a method loops through the array to print 
 * the element of an array in reverse
 * 
 * 
 * 
 */
public class StudentListings {

	protected String name;
	private int studentGradePoint;

	private int IDnumber;

	// No parameter constructor
	public StudentListings() {

	}

	// Constructor with parameter
	public StudentListings(String Name, int StudentgradePoint, int IdNum) {

		name = Name;

		studentGradePoint = StudentgradePoint;
		IDnumber = IdNum;
	}

	// toString method
	public String toString() {
		return ("Name is " + name + "\nGrade is " + studentGradePoint

				+ "\nId number is" + IDnumber + "\n"

		);

	}

	// I included the course information to be added to StringBulder
public String ProgrammerName(){
	String Programmer = (" Ernest Mushinge \n" + " Assignment #2 \n" + " IT 2660 Data Structure and Algorithms"
			+ " CRN 15724 \n" + " Due date: 2/11/2016 \n" + " Spring 2016 \n" + " Chapter 2, Exercise 19, 20 and 21\n"
			+ "_______________________\n\n");
	return Programmer;
}

	// deepCopy method
	public StudentListings deepCopy() {
		StudentListings clone = new StudentListings(name, studentGradePoint, IDnumber);
		return clone;
	}

	// This method compares the target key with the name
	public int compareTo(String Name) {
		return (name.compareTo(Name));
	}

	// This method will allow the user to input data
	public void input() {
		
		Scanner in = new Scanner(System.in);
		System.out.println(" Enter a name ");
		name = in.nextLine();
		System.out.println(" Enter enter student grade point");
		studentGradePoint = in.nextInt();
		System.out.println(" Enter student ID #");
		IDnumber = in.nextInt();
		
	}



}
