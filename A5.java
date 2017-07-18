/**
 * 
 * PF-Session1	
	Assignment5
 * 
 */

package PF_Session1;

import java.util.Scanner;

//Main Class
public class A5 {
	public static void main(String[] args){
		//input array		
		int len ;
		//int[] arr = {1,2,3,4,5};
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		System.out.println("Enter size of input array");
		int[] input = new int[len];							//Initializing with user defined length
		
		System.out.println("Enter elements of input array");
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		int result = SortArray.CheckSortedArray(input);	
		//System.out.println(String.valueOf(result));
		
		switch(result) {
		case 1:System.out.println( String.valueOf(result)  + "String is Ascending");
			break;
		case 2:System.out.println(String.valueOf(result) + "String is Descending");
			break;
		case 0:System.out.println(String.valueOf(result) + "String is Anot sorted");
			break;
		}
		}
	}

class SortArray{
	//method definition for Sorting Type
	public static int CheckSortedArray(int[] input){
		
		if (isAscending(input)){
			return 1;
		}
		else if(isDescending(input)){
			return 2;
		}
		else{
			return 0;
		}
	}
	static boolean isAscending(int[] arr){
		for (int i=0;i<arr.length-1;i++){
			if(arr[i+1]<arr[i]){
				return false;
			}
		}
		return true;
	}
	static boolean isDescending(int[] arr){
		for (int i=0;i<arr.length-1;i++){
			if(arr[i+1]>arr[i]){
				return false;
			}
		}
		return true;
	}
	
}