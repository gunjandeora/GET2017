package DS7;
import java.util.Scanner;
public class BinarySearchMain {
	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		Scanner scan=new Scanner(System.in);
		int size;
		while(true){
			System.out.print("Enter Size:");
			size=scan.nextInt();
			if(size>0){									//exception handling for array size
				break;
			}
		}
		int array[] = new int[size];
		//taking input array from user
		System.out.print("Enter Array :");
		for(int i=0;i<size;i++){
			array[i]=scan.nextInt();					
		}
		System.out.print("Enter Target :");
		int target =scan.nextInt();
		System.out.println(search.startSearch(array, target));
	}
}
