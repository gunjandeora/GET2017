package DS3.BinaryTree;
import static org.junit.Assert.*;

import org.junit.Test;
public class TestBinaryTree {
	@Test
	public void test() {
		MyBinaryTree bTree = new MyBinaryTree();
		bTree.insertNode(1);
		bTree.insertNode(9);
		bTree.insertNode(2);
		bTree.insertNode(8);
		bTree.insertNode(4);
		bTree.insertNode(6);
		String expectPre = "1  2  4  6  8  9";
		String expectPos = "6  4  8  2  9  1";
		assertEquals(expectPre, bTree.preOrder(bTree.getRoot()).trim());
		assertEquals(expectPos, bTree.postOrder(bTree.getRoot()).trim());
	}
}
