package DS2.CounsellingSystem;
import DS2.CounsellingSystem.MyArrayList;
import DS2.CounsellingSystem.MyQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * This will read data from file and
 *  initializes student and college queue
 */
public class Entity {
	File f; 
	String path;
	Scanner scan;
	static MyArrayList studentList,collegeList;
	public Entity(){
		studentList = new MyArrayList();
		collegeList = new MyArrayList();
	}
	public void setFilePath(String path) {
		this.path = path;
	}
	// saving details of students in the list
	public MyArrayList getStudentDetail() throws IOException {
		String line;
		try {
			System.out.println(path + "Student");
			f = new File(path);
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			String str[] = line.split(",");
			Student student = new Student(str[0], Integer.parseInt(str[1]));
			studentList.add(student);
		}
		return studentList;
	}
	// saving details of colleges in the list
	public MyArrayList getCollegeDetail() throws IOException {
		String line;
		try {
			f = new File(path);
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			String str[] = line.split(",");
			College college = new College(str[0], Integer.parseInt(str[1]),
					Integer.parseInt(str[2]));
			collegeList.add(college);
		}
		return collegeList;
	}
	public static MyArrayList getStudentList() {
		return studentList;
	}
	public static MyArrayList getCollegeList() {
		return collegeList;
	}
}
