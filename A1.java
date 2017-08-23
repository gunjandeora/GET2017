package DS1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class A1 {
	public static void main(String args[]) {
		ArrayListOperations a1 = new ArrayListOperations();
	}
} 
class ArrayListOperations {
	ArrayList<Integer> ob = new ArrayList<Integer>();
	ArrayListOperations () {
		ob.add(0);
		ob.add(1);
		ob.add(2);
		ob.add(3);
		ob.add(4);
		ob.add(5);
		ob.add(6);
		ob.add(7);
		ob.add(8);
		ob.add(9);
		ob.add(10);
		ob.add(11);
		count = ob.size();
		display();
		boolean b = addAtLocation(20, 355);
			if (b) {
				display();
			} else {
				System.out.println("value cannot be added at position");
			}
			Integer index = retrieveIndex(36);
			if (index == -1) {
				System.out.println("Element doesn't exist");
			} else {
				System.out.println("element exist at" + index);
			}
			index = retrieve(7, 5);
			if (index == -1) {
				System.out.println("element doesn't exist");
			} else {
				System.out.println("element exist at" + index);
			}
			System.out.println("((((((((((((" + count);
			b = removeDataOfLocation(3);
			System.out.println("*********" + count);
			if (b) {
				System.out.println("Element deleted succesfully");
				display();
			} else {
				System.out.println("Element can't be deleted");
			}
			System.out.println("#####");
			b = removeData(0);
			System.out.println("$$$$$");
			if (b) {
				System.out.println("Element deleted succesfully");
				display();
			} else {
				System.out.println("Element can't be deleted");
			}
			b = removeData(5);
			System.out.println("!!!!!!!!");
			if (b) {
				System.out.println("Element deleted succesfully");
				display();
			} else {
				System.out.println("Element can't be deleted");
			}
			reverseList();
			System.out.println("\n\n"+"Reverse List Is");
			display();
			clearList();
			System.out.println("clear list");
			display();
		}
		// Operations using array
		Integer maxSize = 5;
	    Integer dataArray[] = new Integer[ob.size()];
	    Integer count = 0;
		public void add(Integer data) {
			if (count < maxSize) {
				ob.set(count, data);						//dataArray[count] = data;
				count++;
			}
			else {
				Integer i;
				maxSize = (maxSize * 3) / 2 + 1;
				Integer dataArray1[] = new Integer [maxSize];
//				for (i = 0; i < count; i++) {
//					dataArray1[i] = dataArray[i];
//				}
//				dataArray1[i] = data;
				ob.set(count, data);						//dataArray[count] = data;
				count++;
//				dataArray = dataArray1;
			}
		}
		public boolean addAtLocation(Integer position, Integer data) {
			Integer j;
			if (position <= count) {
					for (j = count - 1; j >= position; j--) {
						ob.set(j+1, ob.get(j));
						System.out.println(ob.get(j));
						//dataArray[j + 1] = dataArray[j];
					}
					//dataArray[j + 1] = data;
					count++;
					ob.set(j+1, data);
				return true;
			} else {
				System.out.println("Invalid position");
				return false;
			}
		}
		void display() {
			System.out.println("count :" + count);
			for (Integer i = 0; i < count; i++) {
				System.out.println( ob.get(i));
			}
			System.out.println("*******end of display");
		}
		public Integer retrieveIndex(Integer data) {
			for (Integer i = 0; i < count; i++) {
				if (ob.get(i) == data) {
					return i;
				}
			}
			return -1;
		}
		Integer retrieve(Integer data, Integer location) {
			System.out.println(count);
			for (Integer i = location; i < count; i++) {
				if (ob.get(i) == data) {
					return i;
				}
			}
			return -1;
		}
		boolean removeDataOfLocation(Integer location) {
			if (location < count) {
				System.out.println("Deleted data is" + ob.get(location));
				for (Integer i = location; i < count - 1; i++) {
					//dataArray[i] = dataArray[i + 1];
					ob.set(i, ob.get(i+1));
				}
				count--;
				return true;
			} else {
				System.out.println("Invalid location");
				return false;
			}
		}
		boolean removeData(Integer data) {
			for (Integer i = 0; i < count; i++) {
				if (ob.get(i) == data) {
					for (Integer j = i; j < count - 1; j++) {
						//dataArray[j] = dataArray[j + 1];
						ob.set(j, ob.get(j+1));
					}
					count--;
					return true;
				}
			}
			return false;
		}
		void clearList() {
			count = 0;
			ob.clear();
		}
		void reverseList() {
			Integer i = 0, j = count - 1;
			Integer temp;
			for (; i <= j; i++, j--) {
				temp= ob.get(i);   								//temp = dataArray[i];
				ob.set(i, ob.get(j));							//dataArray[i] = dataArray[j];
				ob.set(j, temp);								//dataArray[j] = temp;
			}
		}
		Integer get(Integer loc) {
			//return dataArray[loc];
			return ob.get(loc);
		}
		void sort() {
			//Arrays.sort(dataArray);
			ob.sort(null);
		}
	}
	
 

	
 
