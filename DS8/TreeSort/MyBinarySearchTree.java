package DS8.TreeSort;
import java.util.List;
import DS2.Queue.MyArrayList;
public class MyBinarySearchTree {
	MyNode<Student> root;
	public MyBinarySearchTree() {
		root = null;
	}
	public MyNode<Student> getRoot() {
		return root;
	}
	/*
	 * This method will insert new student object in the BST
	 */
	public Boolean insertNode(Student student) {
		MyNode<Student> newNode = new MyNode<Student>(student);
		boolean flag = false;
		if (root == null) {
			root = newNode;
			flag = true;
			return flag;
		}
		MyNode<Student> temp = root;
		MyNode<Student> pointer = null;
		while (true) {
			pointer = temp;
			if (student.getRollNo() > temp.getData().getRollNo()) {			//if roll no is greater than root's roll no.
				temp = temp.getRight();
				if (temp == null) {
					pointer.setRight(newNode);
					flag = true;
					return flag;
				}
			} else {
				temp = temp.getLeft();
				if (temp == null) {
					pointer.setLeft(newNode);
					flag = true;
					return flag;
				}
			}
		}
	}
	/*
	 * Printing InOrder of BST (Tree Sort)
	 */
	public MyArrayList inOrder(MyNode<Student> node, MyArrayList myArrayList) {
		if (node != null) {
			inOrder(node.getLeft(), myArrayList);
			myArrayList.add(node.getData().getRollNo());
			System.out.println(node.getData().getRollNo() + " :: "
					+ node.getData().getName());
			inOrder(node.getRight(), myArrayList);
		}
		return myArrayList;
	}
	/*
	 * It calculates total nodes
	 */
	public int size(MyNode<Student> parent) {
		if (parent == null)
			return (0);
		else {
			return (size(parent.left) + 1 + size(parent.right));
		}
	}
}
