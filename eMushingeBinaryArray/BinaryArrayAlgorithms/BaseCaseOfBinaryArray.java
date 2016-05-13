import java.util.Scanner;

/*Name: Ernest Mushinge
 * Date: 4/5/2016
 * Course#: IT 2660
 * Assignment#: 6
 *
 *This program will give the base case, reduced problem
 *and general solution of the a recursive algorithm for
 *a Binary search array to locate a value key
 */
public class BaseCaseOfBinaryArray {

	// [Notes] Problem is Binary search of an array to find X
	// Base Case is if array size = 0, X not present. If middle array element =
	// X, then return middle element’s index.
	// Reduced Problem is Binary Search a sub-array(an array is divided in 2
	// segment theLow and theHigh, if the # searched for is lower than midPoint,
	// search lower part)
	// General Solution is if middle element > X, make the sub- array the upper
	// half of the array, else make it lower half of the array. Binary search
	// the sub-array

	// The Array
	// int[] ArrayOfNumbers = {2,0,3,4,5,6,7,8,9,10,13,45};
	int[] ArrayOfNumbers;
	Scanner sn = new Scanner(System.in);
	int SizeOfArray;

	// Constructor
	public BaseCaseOfBinaryArray() {
		System.out.println(Author);
		System.out.println("Please specify the size of an array (Numbers only)-->");
		SizeOfArray = sn.nextInt();
		ArrayOfNumbers = new int[SizeOfArray];
		AskUser();
		Sort1(ArrayOfNumbers);
		
			ToSearch();

	}

	/**
	 * This Method performs a binary search on the array assuming the values in
	 * the array are sorted
	 * 
	 * @param Array
	 * @param Key
	 *            is the value we are looking for
	 * @param Start
	 *            is the index of the search
	 * @param End
	 *            is the end of the index where value is stored(-1) if key not
	 *            in the array
	 * @return
	 */
	// I decided to implement a method to ask users to input numbers in the
	// array then search them

	public void AskUser() {

		int count = 1;

		for (int i = 0; i < SizeOfArray; i++) {
			System.out.println("( " + count++ + " )" + " Enter Number to Insert -->>");
			ArrayOfNumbers[i] = sn.nextInt();

		}

	}

	public void ToSearch() {
		// prompt the user to enter a number to search in an array
		System.out.println("Please enter a number to search in an array ->> ");
		int NumberToSearch = sn.nextInt();
		System.out.println(" The Number being searched for is stored at index "
				+ theBinarySearch(ArrayOfNumbers, NumberToSearch, 0, ArrayOfNumbers.length));

	}

	// Sort the array for easy search

	// Bubble Sort the array for easy search
	public void Sort1(int[] arrayToSort) {
		int a, b, temp;
		int compare = (arrayToSort.length);
		for (a = 0; a < compare; a++) {
			for (b = a; b < compare; ++b) {
				if (arrayToSort[b] < arrayToSort[a]) {
					temp = arrayToSort[b];
					arrayToSort[b] = arrayToSort[a];
					arrayToSort[a] = temp;
				}
			}

			System.out.println(" ________________________________________________");
			System.out.println(" You Entered " + arrayToSort[a] + " in the Array ");
			System.out.println(" ________________________________________________");

		}

	}

	// The method
	public int theBinarySearch(int[] Array, int Key, int lower, int higher) {
		// , int lower, int higher

		// base case
		if (higher == lower)// in this case the array has only one element
		{
			if (Array[lower] == Key) {
				// our base case
				return lower;
			} else {
				String printThis = "The Number is not in the array";
				System.out.println(printThis);
			}
		}

		if ((higher - lower) == 1) {
			if (Array[lower] == Key) {
				return lower;
			}
			if (Array[higher] == Key) {
				return higher;
			} else {
				String printThis = "The Number is not in the array";
				System.out.println(printThis);
			}
		}
		
	

		// if the array is bigger then we will need to start iterating the array
		// from mid-point (in the middle)
		int midPoint = (lower + higher) / 2;
		if (Array[midPoint] > Key) {
			// we want to call theBinarySearch Recursively
			return theBinarySearch(Array, Key, 0, midPoint);
		} else {
			return theBinarySearch(Array, Key, midPoint, higher);
		}

	}

	int lower = 0;
	int higher = SizeOfArray;
	int median = (lower + higher) / 2;

//	public int binarySearch1(int key, int median) {
//		// if the array is bigger then we will need to start iterating the array
//		// from mid-point (in the middle)
//
//		if (median < 0 || median > ArrayOfNumbers.length - 1) { // element not
//																// found
//			String printThis = "The Number is not in the array";
//			System.out.println(printThis);
//		}
//		if (key == median) {
//			// Base Case
//			return key;
//		} else if (key < median) {
//			// median = median-1;
//			System.out.println(binarySearch1(key, median - 1));
//			return binarySearch1(key, median - 1);
//		} else {
//			// median = median+1;
//			System.out.println(binarySearch1(key, median + 1));
//			return binarySearch1(key, median + 1);
//		}
//
//	}

	// Programmer's Name
	// This is the String format for assignment information
	String Author = (" Ernest Mushinge \n" + " Assignment #6 \n" + " IT 2660 Data Structure and Algorithms"
			+ " CRN 15724 \n" + " Due date: 04/14/2016 \n" + " Spring 2016 \n" + " Chapter 6, Exercise 16\n"
			+ "_______________________\n\n");
}
