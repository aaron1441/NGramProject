package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
	// creating a map with a string and long variables
	//0(1)
	private static Map<String, Long> frequency = new HashMap<>();
	public static long sum;
	
	// returns the map if needed in a different class
	//0(1)
	public static Map<String, Long> getMap() {
		return Parser.frequency;
	}

	// this method gets the directory name from the user from earlier and puts all
	// the files names of that dir into
	// a string array
	public void parse(String dir) throws Exception {
		//0(1)
		String[] files = new File(dir).list();
		for (String f : files) {//0(n)
			String filename = dir + "/" + f;// this string adjust the file name so the / is included
			process(filename);// calls the process method
		}
	}

	public void process(String file) throws Exception {
		// Instantiating the reader to get the information from the file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			// variables used during the process
			String line = null;
			long value = 0;
			long nGram = 0;
			while ((line = br.readLine()) != null) {// while the next line isnt blank the loop continues

				nGram = Runner.getSize();// gets the ngram size that the user had specified

				// this gets rid of any unwanted characters and leaves just lowercase letters
				// behind
				line = line.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();

				String[] words = line.toLowerCase().split(" ");// this splits the lines into words and puts into a
															   // string array
				//O(N log N)
				for (String word : words) {
					char[] w = word.toCharArray();
					List<Character> chars = new ArrayList<Character>();// i used an arraylist because it was more
																		// versatile than the char array
					for (int i = 0; i < w.length; i++) {
						
						char c = w[i];
						chars.add(c);

						if (chars.size() == nGram) {
							// Making object of StringBuilder class
							StringBuilder sb = new StringBuilder();

							// Adding to character array
							for (Character x : chars) {
								sb.append(x);
							}

							// Seeing if NGram is already present in the Frequency and if so just increases
							// the value
							if (frequency.containsKey(sb.toString())) {
								value = frequency.get(sb.toString());
								value++;
								sum++;
							}

							// Adding each word to the map
							frequency.put(sb.toString(), value);
							sum++;
						}

						value = 1;

					}
				}
			}
		}

	}
	
public static long getSum() {
	return sum;
}
}
