package DS8.SortingSystem;

/**
 * this class sort array using bubble
 *sort
 */
public class BubbleSort {

	public int[] bubbleSort(int array[]){
		int size = array.length;
		for(int row = 0 ; row < size ; row++){
			for(int col = 0 ; col < size - row-1 ; col++){
				if(array[col] > array[col+1]){
					swap(array , col , col+1);  	//swapping of array element
				}
			}
		}
		
		
		return array;
	}
	
	//swapping logic
	public void swap(int array[] , int index ,int nextIndex  ){
		int temp = array[index];
		array[index] = array[nextIndex];
		array[nextIndex] = temp;
	}
}