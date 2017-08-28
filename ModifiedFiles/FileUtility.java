package com.metacube.employee;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.tomcat.jni.File;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/*class for handling file operation.
 */
public class FileUtility {
	private String FILE_LOCATION ;
	private static FileUtility fileUtility = null;
	private FileUtility() {}
	// get instance of singleton class FileUtility
	public static FileUtility getInstance() {
		if(fileUtility == null) {
			fileUtility = new FileUtility();
		}
		return fileUtility;
	}
	/*
	* read text file and save employee details in employeeArray
	*/
	public JSONArray readFile(String path) {
		FILE_LOCATION = path;
		JSONArray employeeArray = null;
		JSONParser parser = new JSONParser();
		try {
			employeeArray = (JSONArray) parser.parse(new FileReader(FILE_LOCATION));
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		//System.out.println(employeeArray);
		return employeeArray;
	}
	/*
	* write/update the employee details to txt file 
	*/
	public void writeFile(JSONArray employeeArray) {
		try {
			FileWriter file = new FileWriter(FILE_LOCATION);
			file.write(employeeArray.toJSONString());
			file.flush();
			System.out.println("Successfully Updated Employees Detail to File");
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
