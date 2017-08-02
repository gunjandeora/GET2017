package OOPs_Session5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Record {
	/*
	 * displaying record on console and also saving in text file. 
	 * taking String array for each entity, whether it's organization or Person, receiving data in String array, 
	 * and saving in text file. 
	 */
	static void saveData(ArrayList<String> data , String fileName) throws IOException{
		String path = "C://Users/User28/Desktop/"+ fileName + ".txt";
		File file = new File(path);
		PrintWriter pw = new PrintWriter(file);
		for(int i=0;i<data.size();i++){
			pw.write(data.get(i));
		}
	}
}
