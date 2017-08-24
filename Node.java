package DS3;
public class Node {
	private Node left;
	private Node right;
	private Integer data;
	public Node(Integer data) {
		this.data = data;
		left = null;
		right = null;
	}
	public Integer getData() {
		return data;
	}
	public void setLeft(Node node) {
		this.left = node;
	}
	public void setRight(Node node) {
		this.right = node;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
}