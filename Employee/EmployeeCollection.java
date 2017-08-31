package DS6.NewEmployee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Class to perform operation on Employee Collection.
public class EmployeeCollection {
    ArrayList<Employee> employees;
    // Constructor
    public EmployeeCollection(){
        employees = new ArrayList();
    }
    /*
     * Performs the Natural Sorting on the collection of employees
     */
    public void sort() {
        Collections.sort(employees);
    }
    /*
     * Sort the employee collection on the basis of their names
     */
    public void sortByName() {
        Collections.sort(employees, new SortByName());
    }
    /*
     * Sort the employee collection on the basis of their address
     */
    public void sortByAddress() {
        Collections.sort(employees, new SortByAddress());
    }
    /*
     * returns the boolean value to check if employee can be added in list or not
     */
    public boolean getUniqueEmployee(Employee employee){
        for(int emp=0;emp<employees.size();emp++){
            Employee tempEmployee = employees.get(emp);
            if(tempEmployee.getEmployeeId().equals(employee.getEmployeeId())){
                return false;
            }
        }
       return true;
    }
    /*
     * adding employee to ArrayList
     */
    public String addEmployee(Employee emp){
        if(getUniqueEmployee()){
            employees.add(emp);
            return "employee added successfully";
        }
        else{
            return "Employee cannot be Added";
        }
    }
}
