package DS5.QueueImplementation;
import java.util.Scanner;
/**
 * This class performs queue operations according to user's choice
 */
public class MyQueueMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyQueue myQueue = new MyQueue();
		int choice=0;
		char ch = 'Y';
		try {
			do {
				System.out.println("\nQueue Operations");
				System.out.println("1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Make Empty");
				System.out.println("4. Get Front");
				System.out.println("5. Get Queue size");
				System.out.println("6. Display Queue");
				try{
					choice = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println("Enter a valid value");
					continue;
				}
				switch (choice) {
				case 1:
					System.out.println("Enter element to queue=");
					myQueue.enqueue(scan.nextInt());
					break;
				case 2:
					System.out.println("Dequeue = " + myQueue.dequeue());
					break;
				case 3:
					myQueue.clear();
					System.out.println("Queue is Empty");
					break;
				case 4:
					System.out.println("Front Element is=" + myQueue.getFront());
					break;
				case 5:
					System.out.println("Queue Size = " + myQueue.size());
					break;
				case 6:
					System.out.println(myQueue);
					break;
				default:
					System.out.println("Wrong Entry \n ");
					break;
				}
				/* display queue */
				System.out.println("\nDo you want to continue (Type y or n) \n");
				ch = scan.next().charAt(0);
			} while (ch == 'Y' || ch == 'y');
		} catch (Exception e) {
			e.getMessage();
			main(args);
		}
		scan.close();
	}
}
