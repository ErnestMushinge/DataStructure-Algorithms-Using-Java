
/*Name: Ernest Mushinge 
 * Date: 5/2/2016
 * Course#: IT 2660
 * Assignment#: 8
 * 
 * This class implements merge sort algorithm in such a way that it outputs the number
 * of COMPARISONS and the number of SWAPS performed when sorting random set of items.
 * The merge sort will be used to sort 1000, 5000, 10,000 and 100,000 integers.
 * The results will be tabulated and compared to the number of COMPARISONS and SWAPS calculated using the 
 * formulas in figure 8.6 of Data Structure and Algorithms Using Java ( William McAllister. Page 472)
 * 
 */

public class MyOwnMergeSort {
	// these variables represents swap Count and compare Count
	static int swapCount = 0;
	static int compCount = 0;

	// I included the course information to be added to StringBulder
	public static void  ProgrammerName() {
		String Programmer = (" Ernest Mushinge \n" + " Assignment # 8 \n" + " IT 2660 Data Structure and Algorithms"
				+ " CRN 15724 \n" + " Due date: 5/05/2016 \n" + " Spring 2016 \n" + " Chapter 8, Exercise 39\n"
				+ "_______________________\n\n");
		System.out.println(Programmer);

	}

	public static void mergeSort(int[] ArrayToSort) {
		// Instantiating []tmp with size of ArrayToSort.length
		int[] tmp = new int[ArrayToSort.length];
		// calling the mergeSort with parameter
		mergeSortWithParameter(ArrayToSort, tmp, 0, ArrayToSort.length - 1);
	}

	private static void mergeSortWithParameter(int[] arrayToSort, int[] tempraryArrayToHelpSort, int leftSideOfArray,
			int rightSideOfArray) {
		// Which will result in true
		if (leftSideOfArray < rightSideOfArray) {
			// The middle of the array
			int center = (leftSideOfArray + rightSideOfArray) / 2;
			// Merge sort starting from the center
			mergeSortWithParameter(arrayToSort, tempraryArrayToHelpSort, leftSideOfArray, center);
			// Merge sort from center going up right
			mergeSortWithParameter(arrayToSort, tempraryArrayToHelpSort, center + 1, rightSideOfArray);

			merge(arrayToSort, tempraryArrayToHelpSort, leftSideOfArray, center + 1, rightSideOfArray);
		}
	}

	// This method below will compare the numbers in groups and if it finds one
	// number is less that the other, it swaps them

	private static void merge(int[] OriginalArrayToSort, int[] tempraryArray, int left, int right, int rightEnd) {
		// this variable ends just before the middle of an array
		int leftEnd = right - 1;
		int k = left;
		int numbersInTheArray = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd)

			if (OriginalArrayToSort[left] <= OriginalArrayToSort[right]) {
				// put left of OriginalArrayToSort into tempraryArray[k] then
				// increment k++
				tempraryArray[k++] = OriginalArrayToSort[left++];
				// increment compCount to get the number of comparing
				compCount++;
			} else {
				// put right of a into tempraryArray[k] then increment k++
				tempraryArray[k++] = OriginalArrayToSort[right++];
				// increment compCount to get the number of comparing
				compCount++;
			}

		while (left <= leftEnd) // Copy rest of first half
			tempraryArray[k++] = OriginalArrayToSort[left++];
		// increment swapCount
		swapCount++;

		while (right <= rightEnd) // Copy rest of right half
			tempraryArray[k++] = OriginalArrayToSort[right++];
		// increment swapCount
		swapCount++;
		// Copy tempraryArray back into OriginalArrayToSort
		for (int i = 0; i < numbersInTheArray; i++, rightEnd--)
			OriginalArrayToSort[rightEnd] = tempraryArray[rightEnd];
	}

	// This method will populate an array with random numbers
	public static int[] populateArray(int[] OriginalArrayToPopulate, int MaxNumbers) {
		for (int i = 0; i < OriginalArrayToPopulate.length; i++) {
			OriginalArrayToPopulate[i] = (int) (Math.random() * MaxNumbers);
		}
		// I want to return the array populated
		return OriginalArrayToPopulate;
	}

}