package DS3.BinaryTree;
import java.util.Scanner;
public class MyBinaryTreeMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operation[] = new String[] { "Insert", "PreOrder", "PostOrder" };
		MyBinaryTree bTree = new MyBinaryTree();
		char ch = 0;
		do {
			int counter = 0;
			System.out.println("Operation -------");
			for (String opt : operation) {
				System.out.println(++counter + "." + opt);
			}
			System.out.println(++counter + ".Back");
			System.out.println("Enter Choice--");
			int choice = getChoice(counter);
			switch (choice) {
			case 1:
				System.out.println("Enter item");
				bTree.insertNode(sc.nextInt());
				break;
			case 2:
				System.out.println(" PreOrder");
				System.out.println(bTree.preOrder(bTree.getRoot()));
			case 3:
				System.out.println("PostOrder");
				System.out.println(bTree.postOrder(bTree.getRoot())); 
				break;
			case 4:
				System.exit(0);
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
	//it get choice from user and return it
	static int getChoice(int range) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		try {
			do {
				choice = Integer.parseInt(scan.next());
			} while (choice <= 0 || choice > range);
		} catch (Exception e) {
			System.out.println("Invalid choice");
			getChoice(range);
		}
		return choice;
	}
}
