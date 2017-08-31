package DS8.SortingSystem;

/**
 * counting sort uses counter to sort the array
 */
public class CountingSort {

	/**
	 * it initialize counter from zero value and increment it according to
	 * respective position and element
	 */
	public int[] countingSort(int array[], int size) {

		int tempArray[] = new int[array.length];
		int counter[] = new int[size + 1]; // counter array
		for (int row = 0; row < counter.length; row++) {
			counter[row] = 0; // put count = 0 in all index
		}

		for (int index = 0; index < array.length; index++) {
			++counter[array[index]]; // increase counter relative position
		}

		int count = 0;
		for (int index = 0; index < counter.length; index++) {
			while (counter[index] != 0) {
				tempArray[count++] = index;
				counter[index]--;
			}
		}
		return tempArray;
	}

}