package DS8.TreeSort;
import java.util.List;
public class MyBinarySearchTree {
	MyNode<Student> root;
	public MyBinarySearchTree() {
		root = null;
	}
	public MyNode<Student> getRoot() {
		return root;
	}

	/**
	 * This method will insert new student object in the BST
	 * @param data
	 */
	public void insertNode(Student data) {

		MyNode<Student> newNode = new MyNode<Student>(data);
		if (root == null) {
			root = newNode;
			return;
		}

		MyNode<Student> temp = root;
		MyNode<Student> pointer = null;
		while (true) {
			pointer = temp;
			if (data.getRollNo() > temp.getData().getRollNo()) {
				temp = temp.getRight();
				if (temp == null) {
					pointer.setRight(newNode);
					return;
				}
			} else {
				temp = temp.getLeft();
				if (temp == null) {
					pointer.setLeft(newNode);
					return;
				}
			}
		}

	}
	/*
	 * Printing InOrder of BST (Tree Sort)
	 */
	public List<Integer> inOrder(MyNode<Student> node, List<Integer> list) {
		if (node != null) {

			inOrder(node.getLeft(), list);
			list.add(node.getData().getRollNo());
			System.out.println(node.getData().getRollNo() + " :: "
					+ node.getData().getName());
			inOrder(node.getRight(), list);
		}
		return list;
	}

	/**
	 * It calculates total nodes
	 * 
	 * @param parent
	 * @return Returns total number of nodes
	 */
	public int size(MyNode<Student> parent) {
		if (parent == null)
			return (0);
		else {
			return (size(parent.left) + 1 + size(parent.right));
		}
	}
}