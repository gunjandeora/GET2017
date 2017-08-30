package DS5.QueueImplementation;
import static org.junit.Assert.*;
import org.junit.Test;
public class TestMyQueue {
	MyQueue myQueue = new MyQueue();	
	@Test	
	public void testEnqueue() {
		assertEquals(true, myQueue.enqueue(2));
		assertEquals(true, myQueue.enqueue(5));		// returns tre if value is inserted
	}
	@Test	
	public void testDequeue(){
		myQueue.enqueue(22);
		myQueue.enqueue(25);
		myQueue.enqueue(35);
		myQueue.enqueue(45);
		assertEquals(22, myQueue.dequeue());
		assertEquals(25, myQueue.dequeue());		// checks the value retrieved after dequeue with expected value
	}
	@Test
	public void testGetFront() {
		myQueue.enqueue(35);
		myQueue.enqueue(45);
		assertEquals(35, myQueue.getFront());		// checks front of queue with expected value
	}
	@Test 
	public void testGetQueueSize(){
		myQueue.enqueue(55);
		myQueue.enqueue(65);
		assertEquals(2, myQueue.size());	
	}
	@Test
	public void testEmptyQueue(){
		myQueue.enqueue(55);
		myQueue.enqueue(65);
		myQueue.clear();
		assertEquals(0, myQueue.size());			// empty queue and then check size of queue, expected vale is 0
	}
}
