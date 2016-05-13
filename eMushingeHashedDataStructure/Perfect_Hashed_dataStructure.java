/*
 * Name: Ernest Mushinge
 * Date: 3/29/2016
 * Course#: IT 2660
 * Assignment#: 5
 * 
 * This Perfect Hashed Data Structure class will store
 *  nodes for a stadium tickets where the ticket numbers
 *  will range from 2000 to 100,000 for a 60,000 seat stadium. 
 *  The tickets number will be the key field and the nodes will
 *  also store the purchaser's name
 *  A user should be presented with option to select from to 
 *  perform functions e.g Insert, Delete, Fetch and Update from the Hashing Structure
 *  The type of Hashing is Direct Hashing data Structure also known as Perfect Hashing
 *  no corrosion, clustering, prime number algorithms required, 
 * In this program, a user will enter a ticket number from 2000 to 60,000
 * then a name of the buyer which will be put in the array at the ticket number index
 * 
 * 
 * 
 */
public class Perfect_Hashed_dataStructure {

	// I have to make sure tickets are sold
	// according to stadium seat
	int NumOfTicketsAvailable = 98000;
	// tickets# sold starting from ticket# 2000
	int ticketNumRangeMin = 2000;
	// tickets# ends at 100000 which is over# of
	// seats 60000
	int ticketNumRangeMax = 100000;
	int MaximumStadiamSeats = 60000;
	// REVISIT HERE
	int ticketsToBeSold = ((NumOfTicketsAvailable - MaximumStadiamSeats) - 1);

	int arraysize = 38000;

	// int n = 0; // the number of nodes in the structure

	// StadiumTickets deleted; // the dummy node, v2
	private StadiumTickets[] data; // the primary storage array

	public Perfect_Hashed_dataStructure() {
		data = new StadiumTickets[arraysize];
		// deleted = new StadiumTickets();// null
		// for(int i = 0; i<N; i++)
		for (int i = 0; i < data.length; i++) {
			data[i] = null;// initialize primary storage array to empty
		}
	}// end of constructor

	// preprocessing algorithms String to Int
	// public static int stringToInt(String aKey) // from Figure 5.18
	// {
	// int pseudoKey = 0;
	// int n = 1;
	// int cn = 0;
	// char c[] = aKey.toCharArray();
	// int grouping = 0;
	// while (cn < aKey.length()) // there is still more character in the key
	// {
	// grouping = grouping << 8; // pack next four characters in i
	// grouping = grouping + c[cn];
	// cn = cn + 1;
	// if (n == 4 || cn == aKey.length()) // 4 characters are processed or
	// // no more characters
	// {
	// pseudoKey = pseudoKey + grouping;
	// n = 1;
	// grouping = 0;
	// }
	// n = n + 1;
	// }
	// return Math.abs(pseudoKey);
	// }

	// Subtraction Preprocessing algorithm to generate a number (index)
	// in the range of 2000 and 60,000
	// I HAVE TO COME BACK AND IMPLEMENT EXCEPTION HANDLING ON PREPROCESSING
	// ALGORITHM

	public static int SubstructionPreprocessing(int givenKey) {

		int MinimumKey = 2000;
		int pk;
		pk = givenKey - MinimumKey;
		return pk;

	}

	// Direct Hashed Fetch
	public StadiumTickets Fetch(int targetKey) {
		int PseudoKey = SubstructionPreprocessing(targetKey);
		int ip = PseudoKey;
		// return a copy of a node or a null reference
		if (data[ip] == null) {
			return null;

		} else {
			return data[ip].deepCopy();
		}

	}

	// Direct Hashed Delete
	public boolean Delete(int targetKey) {
		int PseudoKey = SubstructionPreprocessing(targetKey);
		int ip = PseudoKey;
		// return a copy of a node or a null reference
		if (data[ip] == null) {
			return false;

		} else {
			data[ip] = null;
			return true;
		}
	}

	// DELETE ALGORITHM ENDS
	// Direct Hashed Insert
	public boolean Insert(StadiumTickets NewNode) {
		// This line of code passes a key from NewNode to be preprocess
		// for a pseudoKey that generates a perfect hash key to or index
		// to be inserted in the array
		int pseudoKey = SubstructionPreprocessing(NewNode.getKeyNum());

		// insert successfully
		data[pseudoKey] = NewNode.deepCopy();
		System.out.println("\n________________________");
		System.out.println("insert successfull");
		System.out.println("________________________\n");

		return true;

	}

	// Direct Hashed Update

	public boolean Update(int targetKey, StadiumTickets newTicket) {
		// The update algorithm is a combination of delete and insert
		if (Delete(targetKey) == false)
			return false;
		else {
			// if target key not in a structure
			// we want to insert a newTicket #
			Insert(newTicket);
			return true;
		}

	}

	public void showAll() {
		// The counter will show the number of the node
		int counter = 0;
		// I wanted to show a message if data[i] == null
		// So, I declared i as a local variable then use it
		// in if, else block
		int i = 0;

		if (data[i] != null) {
			// The counter is incremented every time a node in showed
			counter++;
			System.out
					.println(" These are all the students from the list \n________________________________________\n");
			for (; i < arraysize; i++) {
				System.out.println("(" + counter + ") " + data[i].toString() + " Stored at Index " + i);
			}

		} else {
			System.out.println(" The Hashed Structure is empty right now. Please press 1 to insert ");
		}
	}

}
