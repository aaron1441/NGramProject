package ie.gmit.sw;

import java.util.*;

public class Runner {

	// global variables used
	public static String textFilePath;
	public static String outFileName;
	public static int nGramSize;

	Scanner scanner = new Scanner(System.in);// Instantiating the scanner

	public static void main(String[] args) throws Exception {

		// creating objects of the classes used. 
		//O(1)
		Parser p = new Parser();// parser class carries out the ngram counting
		Menu m = new Menu();// menu displays the menu and takes the users option
		Files fileInfo = new Files();// Files contains methods to get the file names from user
		Output output = new Output();// output puts the ngram map to a csv file
		ProgressMeter meter = new ProgressMeter();// creating the progress meter object
		m.Menu();
		while (m.selection != 5) {
			switch (m.selection) {//0(N)
			case 1: // specify text file directory break;
				textFilePath = fileInfo.setTextFileDir();
				System.out.println("The text file directory has been set as " + textFilePath);
				break;

			case 2: // specify n-Gram size
				nGramSize();
				System.out.println("The N-Gram size has been set to: " + nGramSize);
				break;
			case 3: // specify output file
				outFileName = fileInfo.outFileDir();
				System.out.println("The output file will be " + outFileName);
				break;

			case 4: // build n-grams break;
				p.parse(textFilePath);
				
				meter.main();
				output.out(outFileName);
				break;

			default:
				System.out.println("You have entered an incorrect value please choose an option [1-5]");
				break;
			}

			m.Menu();
		}
		
		System.out.println("N-Gram Frequency Builder closed");
		System.exit(0); // close the java program

	}

	// method to get the ngram size from the user
	public static void nGramSize() {
		//0(1)
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What size N-Gram would you like to use? [1-5]");
		nGramSize = keyboard.nextInt();
		
		//0(N)
		if(nGramSize > 5 || nGramSize < 1) {
			System.out.println("That ngram size is invalid. Please select a size [1-5]");
			nGramSize = keyboard.nextInt();
		}
	}

	// method to return the ngram size
	public static long getSize() {
		return nGramSize;
	}

}