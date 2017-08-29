package DS6.NewEmployee;
import java.util.Comparator;
public class Employee implements Comparable<Object>{
    private String employeeId;
    private String name;
    private String address;
    public Employee(String employeeId, String name, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }
    public void setEmployeeName(String name){
        this.name = name;
    }
    public String getEmployeeName() {
        return this.name;
    }
    public void setEmployeeAddress(String address){
        this.address = address;
    }
    public String getEmployeeAddress() {
        return this.address;
    }
    /*
     * Overriding compareTo method and 
     * Comparing according to employee IDs(Natural Order)
     */   
    @Override
    public int compareTo(Object o) {
       //return getEmployeeId().compareTo(o.getEmployeeId());
       return getEmployeeId().compareTo( ((Employee)o).getEmployeeId() );
    }
    public String toString(){
        String str="";	
        str+= "emp id="+this.employeeId+" name= "+this.name+" address= "+this.address+"\n";
        return str;
    }
}
// Comparator for sorting according to Name
class SortByName implements Comparator<Object>{
    @Override
    public int compare(Object emp1, Object emp2) {
       return ( ((Employee)emp1).getEmployeeName() ).compareTo( ((Employee)emp2).getEmployeeName() );
    }
}
// Comparator for sorting according to Name
class SortByAddress implements Comparator<Object>{
    @Override
    public int compare(Object emp1, Object emp2) {
       return ( ((Employee)emp1).getEmployeeAddress() ).compareTo( ((Employee)emp2).getEmployeeAddress() );
    }
}
