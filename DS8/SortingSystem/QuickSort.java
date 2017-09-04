package DS8.SortingSystem;
class QuickSort {
	/*
	 * sort array & return resulting sorted array arr-->array to be sorted
	 * first-->starting index last-->end index
	 */
	public int[] startQuickSort(int arr[]){
		if(arr==null){
			System.out.println("invalid input");
			return null;
		}
		return quickSortResult(arr, 0, arr.length-1);
	}
	public int[] quickSortResult(int arr[], int first, int last) {
		if (arr.length == 0) {
			return null;
		} else {
			if (first < last) {
				int partitionIndex = partitionArray(arr, first, last); // partitioning of array
				// Recursive sorting approch
				quickSortResult(arr, first, partitionIndex - 1);
				quickSortResult(arr, partitionIndex + 1, last);
			}
			return arr;
		}
	}
	/*
	 * partition array & return index arr-->array to be sorted first-->starting
	 * index last-->end index
	 */
	public int partitionArray(int arr[], int first, int last) {
		int pivot = arr[last]; // pivot element
		int index = first - 1;
		for (int row = first; row <= last - 1; row++) {
			if (arr[row] <= pivot) { // swapping of element
				index++;
				int temp = arr[index];
				arr[index] = arr[row];
				arr[row] = temp;
			}
		}
		// swapping of pivot element
		int temp = arr[index + 1];
		arr[index + 1] = arr[last];
		arr[last] = temp;
		return index + 1;
	}
}
