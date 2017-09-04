package DS8.SortingSystem;
import java.util.Scanner;
public class SortingSystemMain {
	public static void main(String[] args) {
		Scanner scan;
		int arr[] = null, result[] = null;
		int size = 0;
		char ch;
		try {
			do {
				scan = new Scanner(System.in);
				System.out.println("\nOperations");
				System.out.println("1. Enter Elements Of Array");
				System.out.println("2. Comparison Sorting");
				System.out.println("3. Linear Sorting");
				System.out.println("5. Exit");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Size Of Array");
					size = Integer.parseInt(scan.next());
					if (size <= 0) {
						System.out.println("Invalid Size");
						break;
					}
					arr = new int[size];
					for (int index = 0; index < size; index++) {
						arr[index] = Integer.parseInt(scan.next());
					}
					break;
				case 2:
					if (size <= 10) {
						BubbleSort obBubble = new BubbleSort();
						result = obBubble.bubbleSort(arr);
						printSortedArray(result);
					} else {
						QuickSort obQuick = new QuickSort();
						result = obQuick.startQuickSort(arr);
						printSortedArray(result);
					}
					break;
				case 3:
					int digitCount = getDigitCount(maximumNumber(arr));
					if (digitCount <= 2) {
						CountingSort cSort = new CountingSort();
						result = cSort.countingSort(arr, maximumNumber(arr));
						printSortedArray(result);
					} else {
						RadixSort rSort = new RadixSort();
						result = rSort.radixSort(arr, digitCount);
						printSortedArray(result);
					}
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Entry \n ");
					break;
				}
				System.out.println("\nDo you want to continue (Type y or n) \n");
				ch = scan.next().charAt(0);
			} while (ch == 'Y' || ch == 'y');
		} catch (Exception e) {
			e.getMessage();
			main(args);
		}
	}
	public static void printSortedArray(int result[]) {
		for (int index = 0; index < result.length; index++) {
			System.out.println(result[index]);
		}
	}
	// find largest element in array
	public static int maximumNumber(int array[]) {
		int temp = array[0];
		for (int index = 0; index < array.length; index++) {
			if (temp < array[index]) {
				temp = array[index];
			}
		}
		return temp;
	}
	// count digit of maximum element in array
	public static int getDigitCount(int max) {
		int count = 1;
		while (max / 10 != 0) {
			count++;
			max = max / 10;
		}
		return count;
	}

}
