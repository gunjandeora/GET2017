package PF_Session1;
import java.util.Arrays;
import java.util.Scanner;
//Main Class
public class A3 { 
	//main method
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int len;
		System.out.println("Enter size of input array");
		len = sc.nextInt();
		int[] arr = new int[len];
		//int[] arr = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		for (int i=0;i<arr.length;i++){
			System.out.println("Enter the element");
			arr[i] = sc.nextInt();
		}
		int results[] = LongestSequence.longestSequence(arr); //results will hold the longest sequence
		for(int i=0;i<results.length;i++){
		System.out.print(String.valueOf(results[i])+" ");
		}
		}
}
//class used for finding longest sequence
class LongestSequence{
	//method to return LongestSequence from the input
	 public static int[] longestSequence(int input[])
	 {
		 /*index_start --> start index for longest 	sequence
			index_end --> end index for longest sequence
			length --> length of the longest sequence.*/
		 int start = 0, next = 1, length = 0;
		 int index_start=start, index_end=next;
		 while(next<input.length){
			 if(input[next]<=input[next-1]){
				 start = next;
				 next = next+1;
			 }
			else{
			if (next-start+1>length){
					 index_start = start;
					 index_end = next;
					length = next-start+1;
			}	
			 next++;
			 }
		 }
		 return Arrays.copyOfRange(input, index_start,index_end+1); // to get a part of array input. 
	 }
}