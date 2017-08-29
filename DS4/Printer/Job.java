package DS4.Printer;
/*
 * class for job, with job name and priority as parameters
 */
public class Job {
	String name ;
	int priority;
	Job(String name , int priority){
		this.name = name;
		this.priority = priority;
	}
	public String getName(){
		return this.name;
	}
	public int getPriority(){
		return this.priority;
	}
}
