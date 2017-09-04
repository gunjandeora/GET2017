package DS8.SortingSystem;
import static org.junit.Assert.*;
import org.junit.Test;
public class SortingSystemTest {	
	// setting input array for testing
	public int[] getInputArray(){
		return new int[]{1,111,543,7};
	}
	//setting expected array for testing
	public int[] getExpectedArray(){
		return new int[]{1,7,111,543};
	}
	//testing bubble sorting
	@Test
	public void bubbleTest() {
		int  array2[] = null, expected2[] = null;	
		BubbleSort obBubble = new BubbleSort();
		int actual[] = obBubble.bubbleSort(getInputArray());
		assertArrayEquals(getExpectedArray(), actual);
		assertArrayEquals(expected2, obBubble.bubbleSort(array2));
	}
	// testing counting sort
	@Test
	public void countingTest() {
		int  array2[] = null, expected2[] = null;	
		CountingSort cSort = new CountingSort();
		int actual[] = cSort.countingSort(getInputArray(), 543);
		assertArrayEquals(getExpectedArray(), actual);
		assertArrayEquals(expected2, array2);
	}
	//testing quick sort
	@Test
	public void quickTest() {
		QuickSort qSort = new QuickSort();
		int  array2[] = null, expected2[] = null;	
		int actual[] = qSort.startQuickSort(getInputArray());
		assertArrayEquals(getExpectedArray(), actual);
		assertArrayEquals(array2, expected2);
	}
	
	@Test
	public void radixTest() {
		RadixSort rSort = new RadixSort();
		int actual[] = rSort.radixSort(getInputArray(), 3);
		int  array2[] = null, expected2[] = null;	
		assertArrayEquals(getExpectedArray(), actual);
		assertArrayEquals(expected2, array2);
	}
}
