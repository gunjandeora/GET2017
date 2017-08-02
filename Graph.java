package OOPs_Session5;
import java.util.ArrayList;
public class Graph {
	/*
	 * Taking array of nodes and connections for displaying graph for any social network of any type of entity.
	 * console output for graph displayed will be..  
	 * Node1 - set of Connections...
	 * Node2 - set of connections
	 */
	static void displayGraph(ArrayList<Node> nodes, ArrayList<String> connections){
		for(int k=0;k<nodes.size();k++){
			System.out.print("Node:" + nodes.get(k));
			System.out.print("  with connections " + connections.get(k));
			System.out.println();

		}
	 	}
}
