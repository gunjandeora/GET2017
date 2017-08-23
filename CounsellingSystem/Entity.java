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
	BufferedWriter out;
	File f; 
	Scanner scan;
	static MyQueue studentQueue = new MyQueue();
	static MyQueue collegeQueue = new MyQueue();
	static MyArrayList studentList = new MyArrayList();
	static MyArrayList collegeList = new MyArrayList();
	public void getStudentDetail() throws IOException {
		String line;
		try {
			f = new File("D://Training 2017/DataStructure/src/DS2/CounsellingSystem/student.txt");
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while ((line = scan.nextLine()) != null) {
			String str[] = line.split(",");
			Student student = new Student(str[0], Integer.parseInt(str[1]));
			studentQueue.enqueue(student);
			studentList.add(student);
		}
	}
	public void getCollegeDetail() throws IOException {
		String line;
		try {
			f = new File("D://Training 2017/DataStructure/src/DS2/CounsellingSystem/college.txt");
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while ((line = scan.nextLine()) != null) {
			String str[] = line.split(",");
			College college = new College(str[0], Integer.parseInt(str[1]),
					Integer.parseInt(str[2]));
			collegeQueue.enqueue(college);
			collegeList.add(college);
		}
	}
	public static MyQueue getStudentQueue() {
		return studentQueue;
	}
	public static MyQueue getCollegeQueue() {
		return collegeQueue;
	}
	public static MyArrayList getStudentList() {
		return studentList;
	}
	public static MyArrayList getCollegeList() {
		return collegeList;
	}
}
