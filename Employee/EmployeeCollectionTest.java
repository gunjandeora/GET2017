package DS6.NewEmployee;
import static org.junit.Assert.*;
import org.junit.Test;
import Assignment1.Employee;
import Assignment1.EmployeeCollection;
public class EmployeeCollectionTest {
	EmployeeCollection employeeCollection;
	@Before
	public void setUp() throws Exception {
	employeeCollection = new EmployeeCollection();
	employeeCollection.employees.add(new Employee("5", "Avni", "MNO"));
        employeeCollection.employees.add(new Employee("4", "Falak", "DEF"));
        employeeCollection.employees.add(new Employee("4", "Chitra", "PQR"));
        employeeCollection.employees.add(new Employee("3", "Palak", "JKL"));
        employeeCollection.employees.add(new Employee("2", "Esha", "ABC"));
        employeeCollection.employees.add(new Employee("1", "Babita", "GHI"));
	}
	/*
	 * Test method for natural sorting of employee collection
	 */
	@Test
	public void testNaturalSorting() {
		String fExpected = "[Employee:Id= 1|Name= Babita|Address= GHI, Employee:Id= 2|Name= Esha|Address= ABC, Employee:Id= 3|Name= Palak|Address= JKL, Employee:Id= 4|Name= Chitra|Address= PQR, Employee:Id= 4|Name= Falak|Address= DEF, Employee:Id= 5|Name= Avni|Address= MNO]";
		employeeCollection.sort();
		assertEquals(fExpected, employeeCollection.employees.toString());
	}
	/*
	 * Test method for sorting by name of employee collection.
	 */
	@Test
	public void testSortingByName() {
		String fExpected = "[Employee:Id= 6|Name= Avni|Address= MNO, Employee:Id= 1|Name= Babita|Address= GHI, Employee:Id= 4|Name= Chitra|Address= PQR, Employee:Id= 2|Name= Esha|Address= ABC, Employee:Id= 4|Name= Falak|Address= DEF, Employee:Id= 3|Name= Palak|Address= JKL]";
		employeeCollection.sortByName();
		assertEquals(fExpected, employeeCollection.employees.toString());
	}
	/*
	 * Test method for getting unique collection of employees
	 */
	@Test
	public void testGetUniqueEmployees() {
		String fExpected = "[Employee:Id= 1|Name= Babita|Address= GHI, Employee:Id= 2|Name= Esha|Address= ABC, Employee:Id= 3|Name= Palak|Address= JKL, Employee:Id= 4|Name= Chitra|Address= PQR, Employee:Id= 5|Name= Avni|Address= MNO]";
		assertEquals(fExpected, employeeCollection.getUniqueEmployees().toString());
	}
}
