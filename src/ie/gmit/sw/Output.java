package ie.gmit.sw;

import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Output {

	public void out(String outFile) throws Exception {

		// Creating the file writer
		//0(1)
		FileWriter fw = new FileWriter(new File(outFile));

		// Creating a map and copying the info from the parser map
		Map<String, Long> frequency = new HashMap<>();
		frequency = Parser.getMap();
		long sum = Parser.getSum();
		long percentage = 0;
		//0(N)
		for (Entry<String, Long> kvs : frequency.entrySet()) {
			long value = kvs.getValue();
			percentage = (value/sum) *100;
			fw.write(kvs.getKey() + "," + value + ","+ percentage + "%\n");
		}
		System.out.println("Map has been written to a file.");
		fw.flush();
		fw.close();
	}
}
