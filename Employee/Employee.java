package DS6.NewEmployee;
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
       //return getEmployeeId().compareTo(o.getEmployeeId());
       return getEmployeeId().compareTo( ((Employee)o).getEmployeeId() );
    }
    
    public String toString(){
        String str="";	
        str+= "emp id="+this.employeeId+" name= "+this.name+" address= "+this.address+"\n";
        return str;
    }
}
