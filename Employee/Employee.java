package DS6.NewEmployee;
public class Employee implements Comparable<Object> {
	private int employeeId;
	private String name;
	private String address;
	public Employee(int employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	/*
	 * Overriding compareTo method and 
	 * Comparing according to employee IDs(Natural Order)
	 */
	@Override
	public int compareTo(Object o) {
		return ((Integer)this.getEmployeeId()).compareTo((Integer)((Employee) o).getEmployeeId());
	}
	public String toString(){
		String str="";	
		str+= "emp id="+this.emp_ID+" name= "+this.name+" address= "+this.address+"\n";
		return str;
	}
}
