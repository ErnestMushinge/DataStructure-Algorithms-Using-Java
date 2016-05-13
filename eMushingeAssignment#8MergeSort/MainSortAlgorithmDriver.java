/*Name: Ernest Mushinge 
 * Date: 5/2/2016
 * Course#: IT 2660
 * Assignment#: 8
 * 
 * This a Driver class of MyOwnMergeSort class that implements merge sort algorithm in such a way that it outputs the number
 * of COMPARISONS and the number of SWAPS performed when sorting random set of items.
 * The merge sort will be used to sort 1000, 5000, 10,000 and 100,000 integers.
 * The results will be tabulated and compared to the number of COMPARISONS and SWAPS calculated using the 
 * formulas in figure 8.6 of Data Structure and Algorithms Using Java ( William McAllister. Page 472)
 * 
 */

public class MainSortAlgorithmDriver {


	public static void main(String[] args) {
		
        //I have to generate 1000, 5000, 10,000 and 100,000 sets of random numbers 
		//and sort them, output the number of swaps and comparison
		int[] ThousandRandomNums = new int[1000];
		int[] FiveThousandRandomNums = new int[5000];
		int[] TenThousandRandomNums = new int[10000];
		int[] OneHundredThousandRandomNums = new int[100000];
		
		//The code below populates the array with random numbers, I has to make 
		//sure that I don't use a built in method. It should be hard coded
			
			MyOwnMergeSort.populateArray(ThousandRandomNums,1000);
			//To print my name to the console
			MyOwnMergeSort.ProgrammerName();
			
			System.out.print("Before Merge Sort Of 1000 numbers\n \n");
			for (int i = 0; i < ThousandRandomNums.length; i++){
				System.out.print(ThousandRandomNums[i] + " ");
			}
		
			//Sorting the Array passed in as a parameter
			MyOwnMergeSort.mergeSort(ThousandRandomNums);
			
			System.out.print("\n__________________________________________________\n\n");
			System.out.println("Merge Sort results of 1000 numbers\n");
			for (int i = 0; i < ThousandRandomNums.length; i++){
				System.out.print(ThousandRandomNums[i] + " ");
			}
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Comparisons in a Merge Sort of 1000 numbers\n");
			System.out.print(MyOwnMergeSort.compCount);
			
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Swaps in a Merge Sort of 1000 numbers\n");
			System.out.print(MyOwnMergeSort.swapCount);
			
			System.out.print("\n__________________________________________________\n");
			
			
	        //MERGE SORT OF 5000 NUMBERS
			System.out.print("\n__________________________________________________\n");
			System.out.print("/////////////////////////////////////////////////////");
			System.out.print("\n__________________________________________________\n");
			
			//The code below populates the array with random numbers, I has to make 
			//sure that I don't use a built in method. It should be hard coded
            MyOwnMergeSort.populateArray(FiveThousandRandomNums,5000);
			
			System.out.print("Before Merge Sort Of 5000 numbers\n \n");
			for (int i = 0; i < FiveThousandRandomNums.length; i++){
				System.out.print(FiveThousandRandomNums[i] + " ");
			}
		
			//Sort 5000 set of numbers
			MyOwnMergeSort.mergeSort(FiveThousandRandomNums);
			
			System.out.print("\n__________________________________________________\n\n");
			System.out.println("Merge Sort results of 5000 numbers\n");
			for (int i = 0; i < FiveThousandRandomNums.length; i++){
				System.out.print(FiveThousandRandomNums[i] + " ");
			}
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Comparisons in a Merge Sort of 5000 numbers\n");
			System.out.print(MyOwnMergeSort.compCount);
			
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Swaps in a Merge Sort of 5000 numbers\n");
			System.out.print(MyOwnMergeSort.swapCount);
			
			System.out.print("\n__________________________________________________\n");
			
			//MERGE SORT OF 10,000 NUMBERS
//			
			System.out.print("\n__________________________________________________\n");
			System.out.print("/////////////////////////////////////////////////////");
			System.out.print("\n__________________________________________________\n");
			
			//The code below populates the array with random numbers, I has to make 
			//sure that I don't use a built in method. It should be hard coded
            MyOwnMergeSort.populateArray(TenThousandRandomNums,10000);
            
            
            
//			
//			System.out.print("Before Merge Sort Of 10,000 numbers\n \n");
//			for (int i = 0; i < TenThousandRandomNums.length; i++){
//				System.out.print(TenThousandRandomNums[i] + " ");
//			}
//		
//			
			MyOwnMergeSort.mergeSort(TenThousandRandomNums);
//			
//			System.out.print("\n__________________________________________________\n\n");
//			System.out.println("Merge Sort results of 10,000 numbers\n");
//			for (int i = 0; i < TenThousandRandomNums.length; i++){
//				System.out.print(TenThousandRandomNums[i] + " ");
//			}
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Comparisons in a Merge Sort of 10,000 numbers\n");
			System.out.print(MyOwnMergeSort.compCount);
			
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Swaps in a Merge Sort of 10,000 numbers\n");
			System.out.print(MyOwnMergeSort.swapCount);
//			
//			System.out.print("\n__________________________________________________\n");
//			
//            //MERGE SORT OF 100,000 NUMBERS
//			
			System.out.print("\n__________________________________________________\n");
			System.out.print("/////////////////////////////////////////////////////");
			System.out.print("\n__________________________________________________\n");
            MyOwnMergeSort.populateArray(OneHundredThousandRandomNums,100000);
//			
//			System.out.print("Before Merge Sort Of 100,000 numbers\n \n");
//			for (int i = 0; i < OneHundredThousandRandomNums.length; i++){
//				System.out.print(OneHundredThousandRandomNums[i] + " ");
//			}
//		
//			
			MyOwnMergeSort.mergeSort(OneHundredThousandRandomNums);
			
			System.out.print("\n__________________________________________________\n\n");
//			System.out.println("Merge Sort results of 100,000 numbers\n");
//			for (int i = 0; i < OneHundredThousandRandomNums.length; i++){
//				System.out.print(OneHundredThousandRandomNums[i] + " ");
//			}
//			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Comparisons in a Merge Sort of 100,000 numbers\n");
			System.out.print(MyOwnMergeSort.compCount);
//			
			System.out.print("\n__________________________________________________\n");
			System.out.println("\n Number of Swaps in a Merge Sort of 100,000 numbers\n");
			System.out.print(MyOwnMergeSort.swapCount);
//			
//			System.out.print("\n__________________________________________________\n");
		

	}

}
