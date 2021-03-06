package DS4.Printer;
/*
 * This class contains heap operations
 */
public class MyHeap {
	int heapSize;
	int capacity;
	Job job[];
	MyHeap(int cap) {
		heapSize = 0;
		capacity = cap + 1;
		job = new Job[capacity];
	}
	int parent(int position) {
		return position / 2;
	}
	int left(int position) {
		return 2 * position;
	}
	int right(int position) {
		return (2 * position + 1);
	}
	void swap(int parentIndex, int childIndex) {
		Job temp = job[parentIndex];
		job[parentIndex] = job[childIndex];
		job[childIndex] = temp;
	}
	/*
	 * This method will insert job in the heap according to its priority
	 */
	boolean insert(String name, int priority) {
		if (heapSize > capacity) {
			System.out.println("Heap OverFlow");
			return false;
		}
		Job newJob = new Job(name, priority);
		if (heapSize == 0) {
			job[++heapSize] = newJob;
			System.out.println("cap " + capacity + " size: " + heapSize);
			return true;
		}
		else if (++heapSize != capacity) {
//			System.out.println("Heap OverFlow *******");
//			return false;
			System.out.println("3cap"+ heapSize);
			job[heapSize] = newJob;
			System.out.println("2cap " + capacity + " size: " + heapSize);
			int pos = heapSize;
			while (pos != 1	&& job[parent(pos)].getPriority() < job[pos].getPriority()) {
				swap(parent(pos), pos);
				pos = parent(pos);
			}
			return true;
		}
		else {		
			System.out.println("Heap OverFlow");
			return false;
		}
	}
	/*
	 * Switching root node with last node and then removing it 
	 * and performing heapify again
	 */
	public Job remove() {
		if (heapSize == 0) {
			System.out.println("Empty Heap");
			return null;
		}
		if (heapSize == 1) {
			Job temp = job[heapSize];
			heapSize--;
			return temp;
		}
		Job lastNode = job[heapSize];
		Job firstNode = job[1];
		job[1] = lastNode;
		heapSize--;
		int index = 1;
		while (index <= heapSize / 2) {
			heapify(index);
			index++;
		}
		return firstNode;
	}
	/* 
	 * heapify the heap 
	 */
	void heapify(int index) {
		int left = left(index);
		int right = right(index);
		int larger = index;
		if (left <= heapSize && job[index].getPriority() < job[left].getPriority()) {
			larger = left;
		}
		if (right <= heapSize && job[larger].getPriority() < job[right].getPriority()) {
			larger = right;
		}
		swap(index, larger);
	}
	public String toString() {
		String result = "";
		for (int index = 1; index <= heapSize; index++) {
			result += job[index].getPriority();
		}
		return result;
	}
}
