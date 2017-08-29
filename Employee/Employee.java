package DS6.NewEmployee;
public class Employee implements Comparable<Object> {
	private int emp_ID;
	private String name;
	private String address;
	public Employee(int emp_ID, String name, String address) {
		this.emp_ID = emp_ID;
		this.name = name;
		this.address = address;
	}
	public void setEmpID(int emp_ID){
		this.emp_ID = emp_ID;
	}
	public int getEmpID() {
		return this.emp_ID;
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
		return ((Integer)this.getEmpID()).compareTo((Integer)((Employee) o).getEmpID());
	}
	public String toString(){
		String str="";	
		str+= "emp id="+this.emp_ID+" name= "+this.name+" address= "+this.address+"\n";
		return str;
	}
}
