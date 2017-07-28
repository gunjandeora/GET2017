package OOPs_Session5;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
// base class for person and organization.
abstract class Entity  {
	String name, Id;
	//saving Nodes objects array and Connection array from entities and sending to graph class.
	void printSummary(){
		ArrayList<Node> node = new ArrayList<Node>();
		ArrayList<Connection> connections = new ArrayList<Connection>();
	}
}
// details for connection between two nodes in a graph.
class Connection {
	String name;												//displays type of connection, if it is with same level or any other level.
	ArrayList<String> connections = new ArrayList<String>();			//array list of ID's of node connected to other nodes.
}
// main class;
public class Social_Network {
	ArrayList<Person_User> person = new ArrayList<Person_User>();
	ArrayList<Organization_Collage> organization = new ArrayList<Organization_Collage>();
	/*
	 * reading file, saving data and creating nodes with their connection.
	 * if the details are for user then make graph for each organization.
	 * or if details are for any organization then make graph for each user.
	 */
	void readAndSave(File file){
	}
	// calling methods of graph class to display social network.
	//Graph.displayGraph();
	/* for printing summaries for each person or organization
	* calling method defined in person and organization classes.
	* person[number].printSummary();
	*/
	void findEntities(){
		//tracing both arraylists for same name and printing their name and Id's
	}
}
// saving data for each organization.
class Organization_Collage extends Entity{
	Connection withOrganizations = new Connection();
}
//saving data for each person.
class Person_User extends Entity{
	Connection withUsers = new Connection(), 
	withOrganizations = new Connection();
	double[] phoneNumber;
	//map<id, arraylist of id's of connected nodes>
	HashMap<String,ArrayList<String>> connections=new HashMap<String,ArrayList<String>>(); 
	//displaying summary of employee , that is , its entity , organization , and connections.
}
// Node for graph display.
class Node {
	String name , Id;
}
//maintainning record.
class Record {
	/*
	 * displaying record on console and also saving in text file. 
	 * taking String array for each entity, whether it's organization or Person, receiving data in String array, 
	 * and saving in text file. 
	 */
	void saveData(String[] data){
	}
}
//display social network.
class Graph {
	/*
	 * Taking array of nodes and connections for displaying graph for any social network of any type of entity.
	 * console output for graph displayed will be..  
	 * Node1 - set of Connections...
	 * Node2 - set of connections
	 */
	void displayGraph(ArrayList<Node> nodes, ArrayList<Connection> connections){
	}
}
