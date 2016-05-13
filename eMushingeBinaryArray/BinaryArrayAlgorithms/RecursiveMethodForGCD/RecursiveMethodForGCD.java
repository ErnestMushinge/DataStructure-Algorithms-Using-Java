
/*Name: Ernest Mushinge
 * Date: 4/5/2016
 * Course#: IT 2660
 * Assignment#: 6
 *
 *This program will implement a recursive method that calculates
 *the greatest common denominator of two integer
 */

package RecursiveMethodForGCD;

import java.util.Scanner;

public class RecursiveMethodForGCD {

	int Number1;
	int Number2;

	// Constructor
	public RecursiveMethodForGCD() {
		// empty constructor
	}

	// Recursive Great Common Denominator
	// Problem is Calculate the greatest common denominator of two integers m
	// and n (m>n), GCD(n,m)
	// Base Case is n = 1, GCD(m,n) = 1 ,n = 0, GCD(m,n) is m
	// Reduced Problem is GCD(n, m%n)
	// General Solution is GCD(n,m) = GCD (n, m%n)

	public int gcd(int x, int y) {
		//I used a conditional operator that simply means
		//if y = 0 return x, else call a recursive method
		return (y == 0) ? x : gcd(y, x % y);
	}

	public void AskUser() {

		Scanner sn = new Scanner(System.in);
		System.out.println("Please Enter two numbers to find the Greatest Common Denominator");
		System.out.println("First Number -->");
		Number1 = sn.nextInt();
		System.out.println("Second Number -->");
		Number2 = sn.nextInt();
		
		//I decided to call the gcd() method in here to minimize code possible
		System.out.println("The Greatest Common Denominator is " + gcd(Number1, Number2));
	}

	// Programmer's Name
	// This is the String format for assignment information
	String Author = (" Ernest Mushinge \n" + " Assignment #6 \n" + " IT 2660 Data Structure and Algorithms"
			+ " CRN 15724 \n" + " Due date: 04/14/2016 \n" + " Spring 2016 \n" + " Chapter 6, Exercise 18\n"
			+ "_______________________\n\n");

}
