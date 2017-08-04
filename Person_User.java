package OOPs_Session5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Person_User extends Entity{
	Connection withUsers = new Connection(), 
	withOrganizations = new Connection();
	double[] phoneNumber;
	//map<id, arraylist of id's of connected nodes>
	HashMap<String,ArrayList<String>> connections=new HashMap<String,ArrayList<String>>(); 
	//displaying summary of employee , that is , its entity , organization , and connections.
}
