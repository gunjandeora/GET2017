package DS5.QueueImplementation;
import static org.junit.Assert.*;
import org.junit.Test;
public class MyQueueTest {
	MyQueue myQueue = new MyQueue();	
	@Test
	public void enqueue_Integer_Boolean() {
		assertEquals(true, myQueue.enqueue(2));
		assertEquals(true, myQueue.enqueue(5));
	}
	@Test
	public void dequeue_null_Integer(){
		myQueue.enqueue(22);
		myQueue.enqueue(25);
		myQueue.enqueue(35);
		myQueue.enqueue(45);
		assertEquals(22, myQueue.dequeue());
		assertEquals(25, myQueue.dequeue());
		assertEquals(35, myQueue.dequeue());
	}
	@Test
	public void getFront_null_Integer() {
		myQueue.enqueue(35);
		myQueue.enqueue(45);
		myQueue.enqueue(55);
		myQueue.enqueue(65);
		myQueue.enqueue(75);
		assertEquals(35, myQueue.getFront());
	}
	@Test 
	public void getSize_null_Integer(){
		myQueue.enqueue(55);
		myQueue.enqueue(65);
		assertEquals(2, myQueue.size);
	}
	@Test
	public void clear_null_null(){
		myQueue.enqueue(55);
		myQueue.enqueue(65);
		myQueue.clear();
		assertEquals(0, myQueue.size);
	}
}
