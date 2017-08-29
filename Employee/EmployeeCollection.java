package DS6.NewEmployee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import DS2.CounsellingSystem.*;
/*
 * Class to perform operation on Employee Collection.
 */
public class EmployeeCollection {
	MyArrayList employees;
	/**
	 * Constructor
	 */
	public EmployeeCollection(){
		employees = new MyArrayList();
	}
	/*
	 * Performs the Natural Sorting on the collection
	 * of employees
	 */
	public void sort() {
		employees.sort();
	}
	/*
	 * Sort the employee collection on the basis of their names
	 */
	public void sortByName() {
		employees.sort(employees, new Comparator<Object>() {
            @Override
            public int compare(Object first, Object second) {
               Employee employeeOne = (Employee) first;
               Employee employeeTwo = (Employee) second;
               return(employeeOne.getName().compareTo(employeeTwo.getName()));
            }
        });
	}
	/*
	 * returns the unique collection of employees
	 * on the basis of their ids
	 */
	public Set<Employee> getUniqueEmployees(){
		Map<Integer,Employee> uniqueEmployeeMapList = new HashMap<Integer,Employee>();
		for(Employee employee: employees) {
			uniqueEmployeeMapList.put(employee.getEmpID(), employee);
		}
		for(int emp=0;emp<employees.size();emp++){
			uniqueEmployeeMapList.put(employees[emp].getEmpID(), employees[emp]);
		}
		Set<Employee> uniqueAccs = new HashSet<Employee>(uniqueEmployeeMapList.values());    
		return uniqueAccs;
	}
}