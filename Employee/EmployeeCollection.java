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
     * returns the unique collection of employees
     * on the basis of their ids
     */
    public Set<Employee> getUniqueEmployees(){
        Map<Integer,Employee> uniqueEmployeeMapList = new HashMap<Integer,Employee>();
        for(int emp=0;emp<employees.size();emp++){
            Employee tempEmployee = employees.get(emp);
            uniqueEmployeeMapList.put(Integer.parseInt(tempEmployee.getEmployeeId()), tempEmployee);
        }
        Set<Employee> uniqueEmployee = new HashSet<Employee>(uniqueEmployeeMapList.values());    
        return uniqueEmployee;
    }
}
