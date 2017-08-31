package DS8.TreeSort;

/**
 * This class contains getter and setter methods of student properties
 */
public class Student {
	private int rollNo;
	private String name;

	public Student(int roll, String name) {
		this.rollNo = roll;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}