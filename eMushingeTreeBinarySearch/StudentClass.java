
import java.util.Scanner;

/*Name: Ernest Mushinge 
 * Date: 4/21/2016
 * Course#: IT 2660
 * Assignment#: 7
 * 
 * This is a Student class that will be used to be stored as one Object in a linked-based binary search tree class
 * 
 * 
 * 
 * 
 */
public class StudentClass {

	private String name;
	private int studentGradePoint;
	private int IDnumber;

	// No parameter constructor
	public StudentClass() {

	}

	// Constructor with parameter
	public StudentClass(String Name, int StudentgradePoint, int IdNum) {

		name = Name;

		studentGradePoint = StudentgradePoint;
		IDnumber = IdNum;
		//this.Address = address;
	}

	// toString method
	public String toString() {
		return ("Name is " + name 
				+ "\nGrade is " + studentGradePoint
				+ "\nId number is " + IDnumber + "\n"

		);

	}

	// I included the course information to be added to StringBulder
	public void ProgrammerName() {
		String Programmer = (" Ernest Mushinge \n" + " Assignment #7 \n" + " IT 2660 Data Structure and Algorithms"
				+ " CRN 15724 \n" + " Due date: 4/28/2016 \n" + " Spring 2016 \n"
				+ " Chapter 7, Exercise 31\n" + "_______________________\n\n");
		System.out.println(Programmer);

	}

	// deepCopy method
	public StudentClass deepCopy() {
		StudentClass clone = new StudentClass(name, studentGradePoint, IDnumber);
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
		System.out.println(" Enter a name of a student");
		name = StringM.nextLine();
		System.out.println(" Enter student grade point");
		studentGradePoint = intM.nextInt();
		System.out.println(" Enter student ID #");
		IDnumber = intM.nextInt();
		//input();
		
		//this line of code will terminate the insertion 
		// or input after calling itself recursively
//		System.out.println(" To inter another student, press 7\n To stop and go to the next step, press 8 ->>");
//		int Continual = intM.nextInt();
//		int Stop = intM.nextInt();
//	    Switch(intM.hasNext())
//	    {
//	    	case  7:
//	    	
//	    	break;
//	    	
//	    }
		
	}
	
	//this will return a name associated to the key passed
	public String getKey()
	   {   return name;
	   }

}

