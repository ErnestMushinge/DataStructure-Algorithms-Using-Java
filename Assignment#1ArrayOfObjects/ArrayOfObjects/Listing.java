import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 1/28/2016
 * Course#: IT 2660
 * Assignment#: 1
 * 
 * This program gets user input an populates the class members
 * String name and int age
 * 
 */


public class Listing {

	 String name;
	 int age;

	public Listing() {
		// // The default constructor initializes
		// // the String and age

		 name = "";
		 age = 0;
	}

	// below is the constructor with parameter
	public Listing(String Name, int Age) {
		this.name = Name;
		this.age = Age;
	}

	// void input method to input the data from the user

	public void input() {

		// for (int k = 0;k<4; k++){

		Scanner in = new Scanner(System.in);
		System.out.println(" Please enter the name ");
		name = in.nextLine();
		System.out.println(" Please enter the age ");
		age = in.nextInt();
	}

	// below is the toString() method
	public String toString() {

		return (

		" The name is " + name + " and the age is " + age);

	}

	// getter and setters of name and age

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		// the string age is converted into an integer
		// as shown in the text book
		this.age = Integer.parseInt(age);
	}

	//this method gets returns the name
	public String getName() {
		return name;
	}

	//this method gets returns the age
	public int getAge() {
		return age;
	}

	// Main method

	public static void main(String[] args) {

		//Instantiates the ArrayOfThreeListing object
		ArrayOfThreeListings array = new ArrayOfThreeListings();
		
		//Instantiates the Listing object
		Listing first = new Listing();
		//accesses the Listing input() method for user input
		first.input();
		//Try to add first Listing object to an array in ArrayOfThreeListings class
		array.add(first);

		//Instantiates the Listing second object
		Listing second = new Listing();
		//accesses the Listing input() method for user input
		second.input();
		//Adds first Listing object to an array in ArrayOfThreeListings class
		array.add(second);
		//Instantiates the Listing third object
		Listing third = new Listing();
		//accesses the Listing input() method for user input
		third.input();
		//Adds first Listing object to an array in ArrayOfThreeListings class
		array.add(third);

        //This is the String format for assignment information
		String Author = (" Ernest Mushinge \n" + " Assignment #1 \n" + " IT 2660 Data Structure and Algorithms"
				+ " CRN 15724 \n" + " Due date: 1/28/2016 \n" + " Spring 2016 \n" + " Chapter 1, Exercise 41 and 42\n"
				+ "_______________________\n\n");

		System.out.println(Author);
		//calls the showAll that was suppose to print the objects in the array in reverse
		array.showAll();

	}

}
