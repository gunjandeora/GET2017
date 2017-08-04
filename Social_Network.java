package OOPs_Session5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import OOPs_Session5.Graph;
// main class;
public class Social_Network {
	ArrayList<Person_User> person = new ArrayList<Person_User>();
	ArrayList<String> tempArrayList = new ArrayList<String>();
	String[] tempStringArray;
	Person_User p = new Person_User();
	ArrayList<Organization_Collage> organization = new ArrayList<Organization_Collage>();
	Organization_Collage o = new Organization_Collage();
	/*
	 * reading file, saving data and creating nodes with their connection.
	 * if the details are for user then make graph for each organization.
	 * or if details are for any organization then make graph for each user.
	 */
	void readAndSave(File file) throws IOException{
		Scanner sc = new Scanner(file);
		String temp;
		temp = sc.nextLine();
		if(temp.equalsIgnoreCase("personDetails")){
		while(sc.hasNext()){
			System.out.println("&&&&");
			temp = sc.nextLine();
			p.name = temp.split(",")[0];
			System.out.println(p.name);
			p.Id = temp.split(",")[1];
			p.withUsers.name = "withUser";
			temp = temp.split(",")[2];
			tempStringArray = new String[temp.length()];
			tempStringArray = temp.split(";");
			System.out.println(temp);
			for(int i=0;i<tempStringArray.length;i++){
				p.withUsers.connections.add(tempStringArray[i]);
				System.out.println(tempStringArray[i]);
			}		
			person.add(p);
		}
	}
		
		if(temp.equalsIgnoreCase("organizationDetails")){
			while(sc.hasNext()){
				System.out.println("&&&&");
				temp = sc.nextLine();
				o.name = temp.split(",")[0];
				System.out.println(o.name);
				o.Id = temp.split(",")[1];
				o.withOrganizations.name = "withOrganizations";
				temp = temp.split(",")[2];
				tempStringArray = new String[temp.length()];
				tempStringArray = temp.split(";");
				System.out.println(temp);
				for(int i=0;i<tempStringArray.length;i++){
					o.withOrganizations.connections.add(tempStringArray[i]);
					System.out.println(tempStringArray[i]);
				}		
				organization.add(o);
			}
			
		}
}
	//displaying graph for organizations with other organizations.
	void displayGraph(){
		String temp ="";
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<String> connections = new ArrayList<String>();
		Connection c = new Connection();
		Node node = new Node();
		for(int j=0;j<organization.size();j++){
			node.name = organization.get(j).name;
			for(int a=0;a<organization.get(j).withOrganizations.connections.size();a++){
				temp = temp + organization.get(j).withOrganizations.connections.get(a);
			}
			connections.add(temp);		
		}		
		Graph.displayGraph(nodes, connections);
	}
	/* for printing summaries for each person or organization
	* calling method defined in person and organization classes.
	* person[number].printSummary();
	*/
	void findEntities(){
		for (int a=0;a<organization.size();a++){
			if (organization.get(a).name.equals("")){					//add name in these double quotes.
				System.out.println("ID" + organization.get(a).Id + " and Name: " +  organization.get(a).name);
			}		//end of if conditions
		}		//end of for loop	
	}			//end of findEntites method.
	
	//if we wish to save data ...
	void saveDataToRecords(Person_User p) throws IOException{
		String temp ="";
		ArrayList<String> details = new ArrayList<String>();
		details.add(p.name);
		details.add(p.Id);
		for (int c=0;c<p.withUsers.connections.size();c++){
			temp  = temp + p.withUsers.connections.get(c);
		}
		details.add(temp);
		for (int c=0;c<p.withOrganizations.connections.size();c++){
			temp  = temp + p.withOrganizations.connections.get(c);
		}
		details.add(temp);
		//sending data to save in txt file
		Record.saveData(details, "User1");
	}
}