package PF_Session4;
import java.util.*;
public class A2{
	ArrayList<String> listOfStrings = new ArrayList<String>();	
	static int startIndex = 0 ;
	int count=0;
	public  void permute(char[] inputString){
		int left = startIndex;
		if(left==inputString.length-1){
			if(!(listOfStrings.contains(String.valueOf(inputString))) ){		//checking for duplicate strings.
				listOfStrings.add(String.valueOf(inputString));
				System.out.println(String.valueOf(inputString));
				count++;
			}
		}else{
			for(int i=left;i<inputString.length;i++){
				swap(inputString, left, i);
				startIndex++;							//shifting to next value.
				permute(inputString);						//recursive calling.
				swap(inputString, left, i);					//swapping characters
				startIndex = left;						//backtracking.
			}
		}
	}
	//swapping values
	private void swap(char[] inputString, int pos1, int pos2){
		char temp = inputString[pos1];
		inputString[pos1] = inputString[pos2];
		inputString[pos2] = temp;
	}
}

