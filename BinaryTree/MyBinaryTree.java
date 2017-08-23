package DS3.BinaryTree;
import DS3.Node;
public class MyBinaryTree {
	Node root;
	String prefix = "";
	String postfix = "";
	public MyBinaryTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insertNode(Integer data) {
		root = insertNode(root, data);
	}
	/**
	 * this will take parameter and insert it into tree
	*/
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
		return parent;
	}
	/**
	 * this will traverse tree in root left right manner
	 */
	public String preOrder(Node node) {	 
		if (node != null) {
			prefix += node.getData() + "  ";
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
		return prefix;
	}
	/**
	 * this will traverse tree in left right and root manner
	 */
	public String postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			postfix += node.getData() + "  ";
		}
		return postfix;
	}
}

