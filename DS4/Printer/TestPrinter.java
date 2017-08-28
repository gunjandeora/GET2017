package DS4.Printer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrinter {
	MyHeap heap = new MyHeap(2);				//testing for heap of capacity 3
	String jobName = "A";
	int jobPriority = 2;
	Job j1 = new Job("A", 1);
	Job j2 = new Job("B", 3);
	@Test
	public void testAddingJob() {
		assertEquals(true, heap.insert("A", 1));
		assertEquals(true, heap.insert("B", 2));
		System.out.println(heap.capacity);
		assertEquals(false, heap.insert("C", 3));
	}
	
	@Test
	public void testRemoveJob(){
		 heap.insert(j1.getName(), j1.getPriority());
		 heap.insert(j2.getName(), j2.getPriority());
		 Job j3 = heap.remove();
		 assertEquals(3, j3.getPriority());		
	}

}
