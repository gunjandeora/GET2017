package DS2.CounsellingSystem;
import java.io.IOException;
public class CounsellingMain {
    public static void main(String[] args) throws IOException {
        Entity entity = new Entity();
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter College file path");
        entity.setFilePath(scan.nextLine());
        MyArrayList temp1 = entity.getCollegeDetail();                  //get college list
        System.out.println("Enter Student file path");
        entity.setFilePath(scan.nextLine());                            
        MyArrayList temp2 = entity.getStudentDetail();                  //get student list
        CounsellingProcess cprocess = new CounsellingProcess(temp1, temp2);             //starting process
        cprocess.display();
    }
}
