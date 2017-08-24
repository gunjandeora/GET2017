package DS2.CounsellingSystem;
import DS2.CounsellingSystem.MyQueue;
import DS2.CounsellingSystem.MyArrayList;
import java.util.Scanner;
/**
 *This class is used to perform all Counseling operations 
 */
public class CounsellingProcess {
    MyQueue studentsQueue, collegeQueue;
    MyArrayList studentsList, collegeList;    
    public CounsellingProcess(MyArrayList colList, MyArrayList studList) {
		this.collegeList = colList;
		this.studentsList = studList; 
		studentsQueue = getQueue(studentsList);
		collegeQueue = getQueue(collegeList);
	}
    MyQueue getQueue(MyArrayList list){
    	MyQueue temp = new MyQueue();
    	//list.sort();
    	for(int i=0;i<list.size();i++){
    		temp.enqueue(list.get(i));                      //retrieving queue from list
    	}
    	return temp;
    }
    //This method will display Initial Menu
    public void display() {
        int choice;
        String option[] = new String[] { "Student List", "College List",
                        "Start Counselling Process" };
        for (int index = 0; index < option.length; index++) {
                System.out.println((index + 1) + "." + option[index]);
        }
        choice = getChoice(option.length);
        switch (choice) {
        case 1:
            showStudentDetail();
            display();
            break;
        case 2:
            showCollegeDetail();
            display();
            break;
        case 3:
            startProcess();
            break;
        default:
            System.out.println("Choose Correct Option");
            display();
        }
    }
    /* This method will select each student rank wise
    * and perform counseling
    */
    public void startProcess() {
        int allSeats = getAllSeats();
        while (!studentsQueue.isEmpty()) {
            if (allSeats > 0) {
                Student studObj = (Student) studentsQueue.dequeue();
                System.out.println("\n\nWelcome  " + studObj.getName()
                    + " in Counseling Process.....!!!!\n");
                System.out.println("College List :--");
                showCollegeDetail();
                chooseCollege(studObj);
                allSeats--;
            } else {
                System.out.println("\nThere are no more seats available in any college\n");
                System.out.println("Student Name\t College Assigned");
                for (int index = 0; index < studentsList.size(); index++) {
                    Student obj = (Student) studentsList.get(index);
                    if (index < getAllSeats())
                        System.out.println(obj.getName() + "\t\t  "
                                        + obj.getCollege().getName());
                    else
                        System.out.println(obj.getName()
                                        + "\t\t No college assigned");
                }
                System.exit(0);
            }
        }
    }
    /**
     * This will assign college to specific student
     */
    void chooseCollege(Student studObj) {
        System.out.println("Choose your Option:- ");
        int choice = getChoice(collegeList.size());
        College clgObject = ((College) collegeList.get(choice - 1));
        if (clgObject.getAvailSeats() != 0) {
            studObj.setCollege(clgObject);
            clgObject.setAvailSeats(clgObject.getAvailSeats() - 1);
            System.out.println(clgObject.getName()
                            + " college is Successfully Allocated");
        } else {
            System.out.println("No seats Available in this college");
            chooseCollege(studObj);
        }
    }
    // method to get choice from the user within the given range of size of list
    public int getChoice(int range) {
        Scanner sc = new Scanner(System.in);
        int ch=0 ;
        try {
            do {
            	System.out.println("Enter choice");
                ch = sc.nextInt();
            } while (ch < 1 || ch > range);
        } catch (Exception e) {
            getChoice(range);
        }
        return ch;
    }
    public void showStudentDetail() {
        System.out.println("Name\t Rank\t College Name");
        for (int index = 0; index < studentsList.size(); index++) {
            Student obj = (Student) studentsList.get(index);
            if (obj.getCollege() == null)
                System.out.println(obj.getName() + "\t   " + obj.getRank()
                                + "\t No College Assigned");
            else
                System.out.println(obj.getName() + "\t    " + obj.getRank()
                                + "\t " + obj.getCollege().getName());
        }
    }
    public void showCollegeDetail() {
        System.out.println("S.No\tName\tRank\tTotal Seats\tAvailable Seats");
        for (int index = 0; index < collegeList.size(); index++) {
            College obj = (College) collegeList.get(index);
            System.out.println((index + 1) + "\t" + obj.getName() + "\t  "
                + obj.getRank() + "\t  " + obj.getTotalSeats() + "\t\t   "
                + obj.getAvailSeats());
        }
    }
    //This will return total seats of all colleges
    public int getAllSeats() {
        int allSeats = 0;
        for (int index = 0; index < collegeList.size(); index++) {
            College obj = (College) collegeList.get(index);
            allSeats += obj.getTotalSeats();
        }
        return allSeats;
    }
}
