import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 1/28/2016
 * Course#: IT 2660
 * Assignment#: 1
 * 
 * This program gets Listing objects and stores them in an array 
 * called threeListing, then a method loops through the array to print 
 * the element of an array in reverse
 * 
 * 
 * 
 */

public class ArrayOfThreeListings extends Listing {

	String NameFromListing;
	int AgeFromListing;

	// Constructor
	public ArrayOfThreeListings(String name, int age) {
		NameFromListing = name;
		AgeFromListing = age;
	}

	// encapsulate data array

	private Listing[] threeListing = new Listing[3];

	// Empty constructor
	public ArrayOfThreeListings() {

		// empty
	}

	private int i = 0;

	public void add(Listing a) {

		if (i < threeListing.length) {

			threeListing[i] = a;
			System.out.println("Object added at index  " + i + "\n "+ "_______________________" +"\n");
			i++;
		}

	}

	Listing lb1 = new Listing(NameFromListing, AgeFromListing);

	public void showAll() {
		for (int b = 3; b > 0; b--) {
			System.out.println(threeListing[b - 1].toString() + ", from an array");

		}

	}

	
}
