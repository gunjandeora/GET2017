package DS3.MirrorTree;
import DS3.Node;
public class MyBinaryTree{
	Node root;
	public MyBinaryTree() {
		root = null;
	}
	public Node getRoot() {
		return root;
	}
	//method insert value in tree
	public void insertNode(Integer data) {
		root = insertNode(root, data);
	}
	//method to generate mirror image
	public Node mirrorImage(Node node) {
		if (node == null) {
			return node;
		} else {
			Node temp = node.getRight();
			node.setRight(node.getLeft());
			node.setLeft(temp);
			mirrorImage(node.getRight());
			mirrorImage(node.getLeft());
		}
		return node;
	}
	public Node insertNode(Node parent, Integer data) {
		if (parent == null) {
			parent = new Node(data);
		} else {
			if (parent.getRight() == null) {
				parent.setRight(insertNode(parent.getRight(), data));
			} else {
				parent.setLeft(insertNode(parent.getLeft(), data));
			}
		}
		System.out.println(" " + parent.getData());
		return parent;
	}
	//it checks that both given tree are mirror image or not
	public boolean checkMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 != null) {
			return (node1.getData() == node2.getData()
					&& checkMirror(node1.getLeft(), node2.getRight()) 
					&& checkMirror(node1.getRight(), node2.getLeft()));
		}
		return false;
	}
	/**
	 * this print the leaf node of tree
	*/
	public void printLeafNodes(Node node) {
		if (node == null)
			return;
		if (node.getLeft() == null && node.getRight()== null) {
			System.out.printf("%d ", node.getData());
		}
		printLeafNodes(node.getLeft());
		printLeafNodes(node.getRight());
	}
}
