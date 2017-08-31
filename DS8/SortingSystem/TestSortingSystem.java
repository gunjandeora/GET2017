package DS8.SortingSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSortingSystem {

	@Test
	public void bubbleTest() {
		int array[] = new int[]{1,111,543,7};
		int expected[] = new int[]{1,7,111,543};
		
		BubbleSort obBubble = new BubbleSort();
		int actual[] = obBubble.bubbleSort(array);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void countingTest() {
		int array[] = new int[]{1,111,543,7};
		int expected[] = new int[]{1,7,111,543};
		
		CountingSort cSort = new CountingSort();
		int actual[] = cSort.countingSort(array, 543);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void quickTest() {
		int array[] = new int[]{1,111,543,7};
		int expected[] = new int[]{1,7,111,543};
		
		QuickSort qSort = new QuickSort();
		int actual[] = qSort.quickSortResult(array, 0, array.length - 1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void radixTest() {
		int array[] = new int[]{1,111,543,7};
		int expected[] = new int[]{1,7,111,543};
		
		RadixSort rSort = new RadixSort();
		int actual[] = rSort.radixSort(array, 3);
		assertArrayEquals(expected, actual);
	}

}