package PF_Session3;
public class A1_1_1 {
	public int rem(int a,int b)
	{
	    if (b==0){				///when divisor is zero
	    	System.out.println("Divisor cannot be zero.");
	    	return -1;
	    }
	    if(b<0){								//when divisor is negative.
	    	return rem(a,(-1)*b);
	    }
	    if(a<0){								//when dividend is negative.
	    	return rem((-1)*a,b);
	    }
		int x=a;
	    if(x>=b)
	    {
	        x=x-b;
	        x = rem(x,b);
	    }
	    return x;
	}
}
