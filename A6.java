package PF_Session1;
public class A6 {
	public static void main (String args[]) {
		int a[] = new int[]{2,5,7,9,12} , 
			b[] = new int[] {1,2,4,5,7,11,12} , 
			c[] = new int[25];
		MergeArray sa = new MergeArray();
		sa.mergeArrayFunction(a,b,c);
	}  }
class MergeArray {
	int i =0, j =0, k;
	 int[] mergeArrayFunction (int a[] , int b[] , int c[]) {
		 for (k=0;k!=(a.length + b.length);k++) {
			 if (a[i] == b[j]) {					//when both arrays have same values.
				 c[k] = a[i];						//inserting value from first array.
				 k++; 
				 c[k] = b[j];						//inserting value from first array.
				 if(i<a.length-1 && j<b.length-1 ) {
				 i++;
				 j++;
				 }
				 else {
					 i++;
					 j++;
					 break;
				 }
			 }
			 else if(a[i] < b[j]) {					//comparing values of both arrays.
				 if(i<a.length) {
				 c[k] = a[i];
				 i++;
				 }
			 }
			 else {
				 if(j<b.length) {
					 c[k] = b[j];
					 j++;
					 }
			 }
			 if (i==a.length && j == b.length){			//reaching end points of both arrays.
				 break;
			 }
		 }
		 for (k=0;k<(a.length + b.length);k++){
			 System.out.print(c[k]);					//printing final merged array.
		 }
		 return c;
	 }
}