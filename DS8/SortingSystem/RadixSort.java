package DS8.SortingSystem;
/*
 * radixsort user radix to sort array element using modulus operation and also
 * arrange in sorted order
 */
public class RadixSort {
/*
 * it sort the given array using radix
 */
	public int[] radixSort(int array[], int digitCount) {
		int tempArr[] = array;
		MyQueue queue[] = new MyQueue[10];
		for (int index = 0; index < 10; index++) {
			queue[index] = new MyQueue();
		}
		for (int rowIndex = 0; rowIndex < digitCount; rowIndex++) {
			for (int index = 0; index < array.length; index++) {
				queue[(tempArr[index] / power(10, rowIndex)) % 10].enqueue(tempArr[index]);  //logic to compute position via modulus operation using array Element & enqueue it
			}
			int count = 0;
			for (int index = 0; index < 10; index++) {
				while (queue[index].size() != 0) {
					tempArr[count++] = queue[index].dequeue(); //dequeue and store it into tempArray
				}
			}
		}
		return tempArr;
	}
	//method to compute power
	public int power(int number1, int number2) {
		int power = 1;
		for (int c = 0; c < number2; c++)
			power *= number1;
		return power;
	}
}
