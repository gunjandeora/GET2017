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
		// checking output of CheckSortedArray.
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
// method checking if array is sorted
class SortArray{
	//method definition for Sorting Type
	public static int CheckSortedArray(int[] input){
		if (isAscending(input)){
			return 1;						//return 1 if array is ascending.
		}
		else if(isDescending(input)){
			return 2;						//return 2 if array is descending.
		}
		else{
			return 0;						//return 0 is array is not sorted.
		}
	}
	//method checking if array is in ascending order
	static boolean isAscending(int[] arr){
		for (int i=0;i<arr.length-1;i++){
			if(arr[i+1]<arr[i]){
				return false;
			}
		}
		return true;
	}
	//method checking if array is in descending order
	static boolean isDescending(int[] arr){
		for (int i=0;i<arr.length-1;i++){
			if(arr[i+1]>arr[i]){
				return false;
			}
		}
		return true;
	}
}