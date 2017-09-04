package DS6.NewEmployee;
import java.util.Set;
public class EmployeeCollectionImplementation {
    public static void main(String args[]) {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.employees.add(new Employee("5", "Avni", "MNO"));
        employeeCollection.employees.add(new Employee("4", "Falak", "DEF"));
        employeeCollection.employees.add(new Employee("4", "Chitra", "PQR"));
        employeeCollection.employees.add(new Employee("3", "Palak", "JKL"));
        employeeCollection.employees.add(new Employee("2", "Esha", "ABC"));
        employeeCollection.employees.add(new Employee("1", "Babita", "GHI"));
        System.out.println("List before Sorting");
        System.out.println(employeeCollection.employees);
        // Natural Sorting
        System.out.println("After Natural Sorting");
        employeeCollection.sort();
        System.out.println(employeeCollection.employees);
        // Sorting By Name
        System.out.println("After sorting By Name");
        employeeCollection.sortByName();
        System.out.println(employeeCollection.employees);		
        // Getting unique Collections for Employee Collections
        System.out.println("After removing duplicate values");
        Set<Employee> uniqueEmployees = employeeCollection.getUniqueEmployees();
        System.out.println(uniqueEmployees);		
    }
}
