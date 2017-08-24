package DS3.MirrorTree;
import static org.junit.Assert.*;

import org.junit.Test;

import DS3.Node;
public class TestMirrorTree {
	@Test
	public void test() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.setLeft(n3);
		n1.setRight(n2);
		n2.setLeft(n5);
		n2.setRight(n4);
		n3.setLeft(n6);
		Node n11 = new Node(1);
		Node n12 = new Node(2);
		Node n13 = new Node(3);
		Node n14 = new Node(4);
		Node n15 = new Node(5);
		Node n16 = new Node(6);
		n11.setLeft(n12);
		n11.setRight(n13);
		n12.setLeft(n14);
		n12.setRight(n15);
		n13.setRight(n16);
		MyBinaryTree bt = new MyBinaryTree();
		assertEquals(true,bt.checkMirror(n1, n11));
	}
}
