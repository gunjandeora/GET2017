package OOPs_Session2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
public class Assignment {
	public static void main (){
		Survey survey = new Survey();
	}
}
//Starting from here
class Survey {
	int num;
	File file;
	String path;
	Student[] studentResponse ;
	Questions ques;
	int numberOfStudents;
	void Survey(String path , int n ) throws IOException{
		file = new File(path);
		ques = new Questions(file);
		numberOfStudents = n;
		studentResponse = new Student[numberOfStudents];
	Scanner sc = new Scanner(System.in);
	String response ;
	for(int outer=0;outer<numberOfStudents;outer++){
		for(int inner=0;inner<ques.numberOfQuestions;inner++){			//survey for each student
			System.out.println(ques.questions[inner]);				//displaying each question in single line as given in assignment
			System.out.println("DO NOT SePERATE ANSWERS WITH ANY SPECIAL CHARACTERS!! ");
			System.out.println("JSUT WRITE YOUR ANSWER IN CONTINUOUS STRING EXAMPLE- AC");
			response = sc.nextLine();
			studentResponse[outer].response[inner] = response;			//storing responses
		}
	}	
	}
}
// Represents each user and stores their response
class Student{
	int ID ;
	String name;
	String response[];
	
}
//Generate report using User class
class Report{
	String[] question;
	String response;
	Map<String, String> multipleQuestionResponse = new HashMap<String, String>();
	ArrayList<Integer> list=new ArrayList<Integer>();
	int numberOfStudents, aCount, bCount, cCount, dCount, eCount ,singleSelectQues=1, multipleSelectQuestion=1;
	// constructor to initialize number of students and calling report1 and report2 methods.
	public Report(int n) {
		numberOfStudents = n;
		report1();
		report2();
	}
	
	Student student[] = new Student[numberOfStudents];
	Questions ques = new Questions();
	public void report1(){
		//single select question report.
		for (int quesnum=0;quesnum<singleSelectQues;quesnum++){
			// calculating response for quesNum[i]
			for(int i=0;i<numberOfStudents;i++){
				response = student[i].response[quesnum] ;
				switch(response){
				case "A" : aCount++;
					break;
				case "B":  bCount++;
					break;
				case "C" : cCount++;
					break;
				case "D" : dCount++;
					break;
				case "E" : eCount++;
				break;
					//default not needed as response won't be out of options;
				}			
			}	
		
				String questionPart = ques.questions[quesnum].split(".")[1];		// removing string "Q1"
				String[] overallQuestion = questionPart.split(",");			//splitting questions by "," and saving in string array
				String type = overallQuestion[1].trim();					//checking if its single type or multiple
				String availableOptions = "";
				if(overallQuestion.length>2){								//conditions for single or multiple select question
					availableOptions = overallQuestion[2].trim(); 		//get options for each question.
				
				}
				//printing only single select question with options and percentage
				if (type=="Single Select" ){
					singleSelectQues ++;					//increasing singleSelectQues for "for loop"
					System.out.print(overallQuestion);
					System.out.print(availableOptions);
					for(int num=1;num<=5;num++){				//5 is fixed as number of options for each question will be fixed
						System.out.println(num + "-" + (aCount/numberOfStudents*100));
					}
					
				}
		}					//ending loop with variable quesNum, that is from here it will shift to next question.
			
	}				//report1 ended
	
	public void report2(){
		String responseString, responseA="", responseB="", responseC="";
		char[] response;
		int multipleSelectQues=1;
		//multiple select question report, as multiple questions are after single select questions
		for (int quesnum=0+singleSelectQues;quesnum<multipleSelectQues;quesnum++){
			responseA=""; responseB=""; responseC="";	//initiating response strings again for each next question
			// calculating response for quesNum[i]
			for(int i=0;i<numberOfStudents;i++){
				responseString = student[i].response[quesnum] ;			//retrieving response for each question 
				response = new char[responseString.length()];
				/*
				 * retrieving responseString in char array and then checking values for each
				 * response and adding in HashMap.
				 */
				for(int r=0;r<responseString.length();r++){				//retrieving each response that is each alphabet
					switch(response[r]){								
					case 'A' : responseA = responseA+i;
						break;
					case 'B':  responseB = responseB+i;
						break;
					case 'C' : responseC = responseC+i;
					break;
						//default not needed as response won't be out of options;
					}	
				}	
			}	
		
			multipleQuestionResponse.put("A",responseA);
			multipleQuestionResponse.put("B",responseB);
			multipleQuestionResponse.put("C",responseC);
				String questionPart = ques.questions[quesnum].split(".")[1];		// removing string "Q1"
				String[] overallQuestion = questionPart.split(",");			//splitting questions by "," and saving in string array
				String type = overallQuestion[1].trim();					//checking if its single type or multiple
				String availableOptions = "";
				if(overallQuestion.length>2){								//conditions for single or multiple select question
					availableOptions = overallQuestion[2].trim(); 		//get options for each question.
				
				}
				//printing only single select question with options and percentage
				if (type=="Multiple Select" ){
					multipleSelectQues ++;					//increasing singleSelectQues for "for loop"
					System.out.print(overallQuestion);
					System.out.print(availableOptions);
				}
		}					//ending loop with variable quesNum, that is from here it will shift to next question.
			
	}
}
//Retrieve questions from file
class Questions{
	int numberOfQuestions;
	String[] questions;
	public Questions(){
		
	}
	// retrieving questions from the file and saving in array.
	public Questions(File file){
		this.numberOfQuestions = 0;
		String temp;
		Scanner sc = null ;
		try {
			sc = new Scanner(file);				//initializing the sc variable
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND, PLEASE CREATE A FILE FIRST!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){					
			/*as according to patter given each question is stored in a single line only.*/
			temp = sc.nextLine();
			this.numberOfQuestions++;				// increasing size of numberOfQuestions by 1
			questions[numberOfQuestions] = temp;	//putting value of temp string in question array.	
		}
	}
	
	public void sortQuestions(){
		Arrays.sort(questions);
	}
	
}


