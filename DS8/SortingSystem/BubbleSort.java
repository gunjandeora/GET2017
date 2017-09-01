package DS8.SortingSystem;
/*
 * this class sort array using bubble sort
 */
public class BubbleSort {
	int[] inputArray;
	public int[] bubbleSort(int array[]){
		if(array==null){
			System.out.println("please enter correct array");
			return inputArray;
		}
		inputArray = array;
		int size = array.length;
		for(int row = 0 ; row < size ; row++){
			for(int col = 0 ; col < size - row-1 ; col++){
				if(array[col] > array[col+1]){
					swap(col , col+1);  	//swapping of array element
				}
			}
		}
		return inputArray;
	}
	//swapping logic
	public void swap(int index ,int nextIndex  ){
		int temp = inputArray[index];
		inputArray[index] = inputArray[nextIndex];
		inputArray[nextIndex] = temp;
	}
}
