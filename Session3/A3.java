package PF_Session3;
import java.util.Scanner;
public class A3{
	//Main Function
	public static void main(String args[]){
		System.out.println("Enter the length of array to be sorted.");
		int n = 1;
		Scanner sc = new Scanner(System.in);
		try{
			n = sc.nextInt();		
		}catch(Exception e){
			System.out.println("Incorrect Input Type");
		}
		int[] input = new int[n];
		int start = 0, end = n-1;
		System.out.println("Enter the elements:");
		for(int i=0;i<n;i++){
			input[i] = sc.nextInt();
		}
		QuickSort q = new QuickSort();				
		q.quickSort(input, start, end);					//calling quicksort function
		System.out.print("[");
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");				//printing sorted array.
		}
		System.out.print("]");
	}
}
class QuickSort{
	//Method to sort a given array: InputArray
	void quickSort(int[] inputArray, int start, int end){
		if(start<end){
			int pivot = partition(inputArray, start, end);		//finding pivot
			quickSort(inputArray, start, pivot-1);
			quickSort(inputArray, pivot+1, end);
		}
	}
	// Method to find and return new pivot element
	int partition(int[] inputArray, int start, int end){
		int pivot = inputArray[end];
		int i = start-1, temp;
		for(int j=i+1;j<=end-1;j++){
			if(inputArray[j]<=pivot){				//swapping values
				i++;
				temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
			}
		}
		temp = inputArray[i+1];
		inputArray[i+1] = inputArray[end];
		inputArray[end] = temp;
		return(i+1);
	}
}


