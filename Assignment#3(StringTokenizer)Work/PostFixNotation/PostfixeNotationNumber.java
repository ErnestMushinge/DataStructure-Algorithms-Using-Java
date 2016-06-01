
/*Name: Ernest Mushinge
 * Date: 2/25/2016
 * Course#: IT 2660
 * Assignment#: 3
 * 
 * This program evaluates the arithmetic expression written in post fixed notation
 * The arithmetic expression will be input as a string by the user and will contain 
 * only integers operands for the program to work. Then following code below parses the 
 * integers and operators from the input string and outputs the calculation of the expression
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class PostfixeNotationNumber {

	Stack s = new Stack();

	String mathExpression = null;
	Scanner sc = new Scanner(System.in);

	int number1;
	int number2;
	int result = 0;
	String thisToken;

	// Constructor
	public PostfixeNotationNumber() {

		MyName();
		System.out.println(" Enter arithmentic expression seperated by space in post fix notation");

		mathExpression = sc.nextLine();
	}

	// Method that handles String Tokenizer
	public int PostfixEvaluate() {

		try {

			StringTokenizer tokens = new StringTokenizer(mathExpression);

			while (tokens.hasMoreTokens()) {
				//we want to iterate through the mathExpression
				thisToken = tokens.nextToken();

                                //I wanted to saperate operators from operands (math symbols from numbers)
                                //if the iteration encounters a math symbol, push it into a different stack else it's a number
				if (!"+".equals(thisToken) && !"*".equals(thisToken) && !"-".equals(thisToken)
						&& !"/".equals(thisToken)) {
					s.push(Integer.parseInt(thisToken));

				} else {
					String Operator = thisToken;
					number1 = s.pop();
					number2 = s.pop();
					// try and catch for division
					try {
						if (Operator.equals("/")) {
							if (number1 == 0) {
								System.out.println("Sorry, zero can't be divided by any number");
								break;
							}

							result = number2 / number1;
						} else if (Operator.equals("*")) {
							result = number2 * number1;
						} else if (Operator.equals("+")) {
							result = number1 + number2;
						} else if (Operator.equals("-")) {
							result = number2 - number1;
						} else
							System.out.println("Illeagal symbol");
						s.push(result);
					} catch (Exception e) {
						e.toString();
					}
					// try and catch for division ends

				}

			}

			// pop the last value in the stack as a result
			s.pop();

			System.out.println("Postfix Evauation = " + result);

			// This is to catch exception just in case a user enters letter or
			// numbers not in post fixe notation
		} catch (Exception e) {
			e.toString();
			System.out.println("Please Enter Numbers in Post fixe notation and operators\nseperated by space");
		}

		// Method returns a result to main thread
		return result;
	}

	// This method prints my name to the console
	public void MyName() {
		// This is the String format for assignment information
		String Author = (" Ernest Mushinge \n" + " Assignment #3 \n" + " IT 2660 Data Structure and Algorithms"
				+ " CRN 15724 \n" + " Due date: 2/25/2016 \n" + " Spring 2016 \n" + " Chapter 3, Exercise 21\n"
				+ "_______________________\n\n");
		System.out.println(Author);
	}

}
