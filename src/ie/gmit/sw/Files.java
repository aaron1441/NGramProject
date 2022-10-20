package ie.gmit.sw;

import java.util.Scanner;

public class Files {

	// this method gets the name of the directory
	public String setTextFileDir() {
		//0(1)
		Scanner scanner = new Scanner(System.in);
		String path = "";
		String folderName = "";
		System.out.println("What is the name of the folder the Text files are located?");
		folderName = scanner.nextLine();
		path = "../" + folderName;
		return path;
	}

	// this method gets and sets the name of the output file
	public String outFileDir() {
		//0(1)
		long nGramSize = Runner.getSize();
		Scanner scanner = new Scanner(System.in);
		String path = "";
		String fileName = "";
		System.out.println("What would you like to name the output file?");
		fileName = scanner.nextLine();
		path = "./" + fileName + nGramSize + ".csv";
		return path;
	}
}
