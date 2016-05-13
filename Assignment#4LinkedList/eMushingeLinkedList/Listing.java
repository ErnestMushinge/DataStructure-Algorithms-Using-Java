
import java.util.Scanner;

/*Name: Ernest Mushinge 
 * Date: 2/11/2016
 * Course#: IT 2660
 * Assignment#: 4
 * 
 * This is a Student class that will be used to be stored as one Object in a SinglyLinkedList class
 * 
 * 
 * 
 * 
 */
public class Listing {

	private String name;
	private int studentGradePoint;
	private String Address;

	private int IDnumber;

	// No parameter constructor
	public Listing() {

	}

	// Constructor with parameter
	public Listing(String Name, int StudentgradePoint, int IdNum, String address) {

		name = Name;

		studentGradePoint = StudentgradePoint;
		IDnumber = IdNum;
		this.Address = address;
	}

	// toString method
	public String toString() {
		return ("Name is " + name 
				+ "\nGrade is " + studentGradePoint
				+ "\nAddress is " + Address

				+ "\nId number is " + IDnumber + "\n"

		);

	}

	// I included the course information to be added to StringBulder
	public void ProgrammerName() {
		String Programmer = (" Ernest Mushinge \n" + " Assignment #4 \n" + " IT 2660 Data Structure and Algorithms"
				+ " CRN 15724 \n" + " Due date: 3/10/2016 \n" + " Spring 2016 \n"
				+ " Chapter 4, Exercise 25\n" + "_______________________\n\n");
		System.out.println(Programmer);

	}

	// deepCopy method
	public Listing deepCopy() {
		Listing clone = new Listing(name, studentGradePoint, IDnumber, Address);
		return clone;
	}

	// This method compares the target key with the name
	public int compareTo(String Name) {
		return (name.compareTo(Name));
	}

	// This method will allow the user to input data, 
	//there is no need to parse the data because the 
	//variables are integers already and in.nextInt parses the value into integer
	public void input() {

		Scanner intM = new Scanner(System.in);
		Scanner StringM = new Scanner(System.in);
		System.out.println(" Enter a name ");
		name = StringM.nextLine();
		System.out.println(" Enter student grade point");
		studentGradePoint = intM.nextInt();
		System.out.println(" Enter student ID #");
		IDnumber = intM.nextInt();
		//to get address
		System.out.println(" Enter student address ");
		 Address = StringM.nextLine();
		

	}

}

