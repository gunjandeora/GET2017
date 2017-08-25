package DS2.CounsellingSystem;
import DS2.Queue.MyArrayList;
/**
 * This class is used to store and get student details
 */
public class Student {
    String name;
    int rank;
    College college;
    MyArrayList preferList;
    Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
    String getName() {
        return this.name;
    }
    int getRank() {
        return this.rank;
    }
    void setCollege(College college) {
        this.college = college;
    }
    College getCollege() {
        return this.college;
    }
    void setPreferCollege(College college) {
        preferList.add(college);
    }
    MyArrayList getPreferCollegeList() {
        return preferList;
    }
    College getPreferCollege() {
        return (College) preferList.get(0);
    }
    int compareTo(Student stud) {
        if (this.rank > stud.rank) {
            return 1;
        } else {
            return 0;
        }
    }
}