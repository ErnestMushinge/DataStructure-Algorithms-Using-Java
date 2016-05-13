/*Name: Ernest Mushinge
 * Date: 2/25/2016
 * Course#: IT 2660
 * Assignment#: 3
 * 
 * This class declares a stack array, push and pop methods for pushing into the stack and popping
 * out the stack. The values are then used in Post fix Notation Number Class for calculations
 */
public class Stack {
	private int[] data;
	private int top;
	private int size;

	public Stack() {
		top = -1;
		size = 100;
		data = new int[100];
	}

	public Stack(int n) {
		top = -1;
		size = n;
		data = new int[n];
	}

	// This a push/insert method
	public boolean push(int newNum) {
		if (top == size - 1)
			return false; // ** overflow error **
		else {
			top = top + 1;
			data[top] = newNum;
			return true; // push operation successful
		}
	}

	// This is a pop/ fetch & delete method in stack
	public int pop() {
		int topLocation;
		if (top == -1)
			return 0; // ** underflow error **
		else {
			topLocation = top;
			top = top - 1;
			return data[topLocation];
		}
	}

}
