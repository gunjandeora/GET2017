package PF_Session1;

import java.util.Scanner;
// class used only for calling
public class A2 {
	public static void main(String[] args) {
		int len;
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		System.out.println("Enter size of input array");
		int[] input = new int[len];
		//int input[] = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		Duplicate dp = new Duplicate();
		System.out.println("Enter elements of input array");
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}

		dp.removeDuplicate(input); //calling function
	}
}
// class for removing duplicates
class Duplicate {
	int[] finalArray = new int[8];								// array used to put unique values
	int inner, outer, len = 14, flag = 1, k = 0;
	/* Method for removing Duplicate*/
	public int[] removeDuplicate(int[] input) {
		finalArray[0] = input[0];
		for (inner = 0; inner< len; inner++) {
			flag = 1;
			for (outer= 0; outer< inner; outer++) {
				if (input[inner] == input[outer]) {
					flag = 0;
				}
			}
			if (flag == 1) {
				finalArray[k] = input[inner];
				k++;
			}
		}
		return finalArray;
	}
}
