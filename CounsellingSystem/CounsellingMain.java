package DS2.CounsellingSystem;
import java.io.IOException;
public class CounsellingMain {
    public static void main(String[] args) throws IOException {
        Entity entity = new Entity();
        entity.getCollegeDetail();
        entity.getStudentDetail();
        CounsellingProcess cprocess = new CounsellingProcess();
        cprocess.display();
    }
}