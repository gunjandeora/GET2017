package DS1;
public class A6 {
	public static void main (String[] args){
		Integer[] intArray = new Integer[]{12,23,44,5,1,8,7,9,0,6};
		Integer a1,a2 =0 ,a3 =0 ,i;
	    a1 = intArray[0]; 
	    for (i = 1; i < intArray.length ; i ++){
	        if (intArray[i] > a1){
	            a3  = a2;
	            a2 = a1;
	            a1  = intArray[i];
	        }
	        else if (intArray[i] > a2){
	            a3 = a2;
	            a2 = intArray[i];
	        }
	        else if (intArray[i] > a3){
	        	a3 = intArray[i];
	        }     
	    }
	    System.out.println("The third Largest element is " + a3);
	}
}