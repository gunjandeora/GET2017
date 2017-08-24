package DS3.MirrorTree;
import java.util.Scanner;
import DS3.Node;
import DS3.MirrorTree.*;
public class MirrorTreeMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operation[] = new String[] { "First Tree", "Second Tree","Check Mirror" };
		MyBinaryTree bTree1 = new MyBinaryTree();
		MyBinaryTree bTree2 = new MyBinaryTree();	
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node1.setLeft(node3);
		node1.setRight(node2);
		node2.setLeft(node5);
		node2.setRight(node4);
		node3.setLeft(node6);
		Node node11 = new Node(1);
		Node node12 = new Node(2);
		Node node13 = new Node(3);
		Node node14 = new Node(4);
		Node node15 = new Node(5);
		Node node16 = new Node(6);
		node11.setLeft(node12);
		node11.setRight(node13);
		node12.setLeft(node14);
		node12.setRight(node15);
		node13.setRight(node16);
		MyBinaryTree bt = new MyBinaryTree();
		if (bt.checkMirror(node1, node11)) {
			System.out.println("Both Binary Tree Are Mirror Image");

		} else {
			System.out.println("Not Mirror Image");
		}
		bTree1.printLeafNodes(node1);
		System.out.println();
		bTree2.printLeafNodes(node11);
	}

}
