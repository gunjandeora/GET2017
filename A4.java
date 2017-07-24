package PF_Session1;
class A4 {
	public static void main(String args[]) {
		int arrivalTime[] = new int[] { 1, 5, 9, 25 }, 
				jobSize[] = new int[] { 12,7, 2, 5 };
		FCFSClass fc = new FCFSClass();
		fc.JobSchedulingFunction(arrivalTime, jobSize);
	}
}
//class used to find first come first serve scheduling
  class FCFSClass {
	int i, j;
	//Function used to find job scheduling
	public int[][] JobSchedulingFunction(int[] arrivalTime, int[] jobSize) {
		int  a, b, c, d;
		int[][] finalArray = new int[4][4];
		for (i = 0; i < arrivalTime.length; i++) {
			//Initializing the schedule
			if (i == 0) {								//initializing values of columns.
				finalArray[i][0] = arrivalTime[i];
				finalArray[i][2] = 1;
				finalArray[i][1] = finalArray[i][2] - finalArray[i][0];
				finalArray[i][3] = jobSize[i];
			}
			else {
				finalArray[i][0] = arrivalTime[i];							//arrival time
				finalArray[i][2] = finalArray[i - 1][3] + 1;				// job will start at...
				finalArray[i][1] = finalArray[i][2] - finalArray[i][0];		//waiting time
				finalArray[i][3] = jobSize[i] + finalArray[i - 1][3];		//job finished at
				if (finalArray[i][1] < 0) {							//If job comes after finishing last job
					finalArray[i][1] = 0;
					finalArray[i][3] = jobSize[i] + arrivalTime[i] - 1;
					finalArray[i][2] = arrivalTime[i];
				}
			}
		}
		for (i = 0; i < arrivalTime.length; i++) {		//outer loop
			for (j = 0; j < arrivalTime.length; j++) {		//inner loop
				System.out.print(finalArray[i][j] + "  ");		//printing resultant table
			}
			System.out.println();
		}
		return finalArray;
	}
}
