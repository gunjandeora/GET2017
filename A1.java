package PF_Session4;
//class for Tower of Hanoi Problem
class TowerOfHanoi {
	int disk =1;
	public TowerOfHanoi(int finalValue) {
		disk = disk + finalValue;						//initializing number of disks+1.
	}
	public TowerOfHanoi() { 	}			//constructor for test cases.
	String s="";
    void tower (char source, char destination, char temp, int numberOfDisk){
    if(numberOfDisk!=1){
    	 tower(source, temp, destination,numberOfDisk-1);			//recursive calling of TOH method
    	 s = "Move disc " + (disk-numberOfDisk)+ " from " + source + " to " + destination ;
         System.out.println(s);
         tower(temp,destination,source,numberOfDisk-1);				//recursive calling of TOH method
    }
    else{
    	s = "Move disc "+ (disk- numberOfDisk) + " from " + source + " to " + destination;
       System.out.println(s);
    }
}
}
