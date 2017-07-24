package PF_Session3;
import java.util.Scanner;
import java.util.Arrays;
//main class
public class A2 {
	public static void main (String args[]){
	    LinearSearch ls = new LinearSearch(1);
        BinarySearch1 bs1 = new BinarySearch1(1);
	} 
}
/*class for linear search*/
class LinearSearch{
	int len , key , k;
	Scanner sc = new Scanner(System.in);
	int[] input;
	public LinearSearch() {
		// TODO Auto-generated constructor stub
	}
	//constructor to start linear search
	LinearSearch(int t) {
		int i;
		System.out.print("Enter length of input array");
		len = sc.nextInt();
		input = new int[len];
		System.out.print("Enter elements of input array");
		for(i=0;i<len;i++){
			input[i] = sc.nextInt();			//taking input 
		} 
		System.out.print("Enter number you wish to search");
		key = sc.nextInt();
		k = search(input , 0 , key);
                System.out.println("Number found on index " + (k+1));
	}
	/*function used for searching number in array*/
	public int search(int[] input, int pos, int key) {
		if(pos >= input.length) {
			System.out.println("Number not found");
			return -1;						//if number not found
		}
		if(input[pos]==key){
		return pos;								//number found
		}
		return search(input , ++pos , key);				//calling function recursively
	}
}
// class used for binary search.
class BinarySearch1 {
	int len , key;
	Scanner sc = new Scanner(System.in);
	int[] input;
	public BinarySearch1() {
	}
	//constructor to start binary search
	public BinarySearch1(int w) {
		int i, k;
		System.out.print("Enter length of input array");
		len = sc.nextInt();
		input = new int[len];
		System.out.print("Enter elements of input array");
		for(i=0;i<len;i++){
			input[i] = sc.nextInt();			//taking input elements
		} 
		System.out.print("Enter number you wish to search");
		key = sc.nextInt();
		
		if(isSorted(input)) {
			k = search(input , 0 , len, key);
                        if(k== -1){
                            System.out.println("Number does not exist in input array");
                        }
                        System.out.println("Position :" + k);
		}
		else {
			Arrays.sort(input);				//if array not sorted then sort array.
                        System.out.println("Sorting Input Array");
                        for(int a=0;a<input.length;a++){
                            System.out.println(input[a]);
                        }
                        k = search(input , 0 , len , key);
                        if(k== -1){
                            System.out.println("Number does not exist in input array");
                        }
                        System.out.println("Position :" + (k+1));
		}		
	}
	// check if array is sorted or not.
	public Boolean isSorted(int[] input){
            for (int i=0;i<input.length-1;i++){
			if(input[i+1]<input[i]){
				return false;
			}
		}
		return true;
	}
        //Method for recursive binary search 
        public int search(int[] input , int start , int end , int key){
            int mid = (start + end)/2;
            if(input[mid] == key){					//number found
                return mid;
            }
            if(input[mid]>key){						
                return search(input, start, mid-1, key);		//recursive calling with new end value.
            }
            if(input[mid]<key){
                return search(input, mid+1, end, key);			//recursive calling with new start value.
            }
           return -1; 				//if number not found then return -1.
        }
}
