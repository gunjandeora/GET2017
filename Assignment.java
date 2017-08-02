package OOPs_Session2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
	Scanner sc = new Scanner(System.in);
	String response ;
	//constructor calling
	void Survey(String path , int studentCount ) throws IOException{
		file = new File(path);
		ques = new Questions(file);
		numberOfStudents = studentCount;
		studentResponse = new Student[numberOfStudents];
	for(int outer=0;outer<numberOfStudents;outer++){
		for(int inner=0;inner<ques.numberOfQuestions;inner++){			//survey for each student
			System.out.println(ques.questions[inner]);				//displaying each question in single line as given in assignment
			System.out.println("DO NOT SEPERATE ANSWERS WITH ANY SPECIAL CHARACTERS EXCEPT ','  !! ");
			System.out.println("JUST WRITE YOUR ANSWER IN CONTINUOUS STRING ");
			response = sc.nextLine();
			studentResponse[outer].response[inner] = response;			//storing responses
		}
	}		//ending outer loop	
	// calling report class and passing ques object of class Questions and array of objects of class Student.
	Report report = new Report(ques, studentResponse);
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
	Student student[];
	Questions ques;
	int numberOfStudents, singleSelectQues=1, multipleSelectQuestion=1;
	int countChoices[] = new int[5];			/// as we know number of options available will be 5.
	// constructor to initialize number of students and calling report1 and report2 methods.
	public Report(Questions ques, Student students[]) throws IOException {
		this.student = students;
		this.ques = ques;
		numberOfStudents = students.length;
		report1();
		report2();
	}
		public void report1(){
		//single select question report.
		for (int quesnum=0;quesnum<ques.numberOfQuestions;quesnum++){
			//checking type of question.
			String questionPart = ques.questions[quesnum].split(".")[1];		// removing string "Q1"
			String[] overallQuestion = questionPart.split(",");			//splitting questions by "," and saving in string array
			String type = overallQuestion[1].trim();					//checking if its single type or multiple
			String availableOptions = "";
			if(overallQuestion.length>2  && type=="Single Select"  ){	//conditions for single select question
				availableOptions = overallQuestion[2].trim(); 		//get options for each question.
					System.out.print(overallQuestion);
					System.out.print(availableOptions);
				//calculating response from each student for quesNum[i].
					for(int i=0;i<numberOfStudents;i++){
						response = student[i].response[quesnum] ;
						switch(response){
						case "A" : countChoices[0]++;
							break;
						case "B":  countChoices[1]++;
							break;
						case "C" : countChoices[2]++;
							break;
						case "D" : countChoices[3]++;
							break;
						case "E" : countChoices[4]++;
						break;
							//default not needed as response won't be out of options;
						}			
					}
					//printing single select question with options and percentage
					for(int num=0;num<5;num++){				//5 is fixed as number of options for each question will be fixed
						System.out.println((num+1) + "-" + (countChoices[num]/numberOfStudents*100));
					}
			}
		}			//ending loop with variable quesNum, that is from here it will shift to next question.
			
	}				//report1 ended
	
	public void report2() throws IOException{
		String responseString="" , finalResponse="";
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			//retrieving response from each student.
		for(int i=0;i<numberOfStudents;i++){
			for(int inner=0;inner<student[i].response.length;inner++){
				responseString = responseString + student[i].response[inner] + " ,";		//retrieving response for each question 
			}
			//generating final response string.	
			finalResponse = "Participant "+i+ ", " + responseString;
			//inserting data in file.
				bw.write(finalResponse);
				bw.newLine();
			}	
		bw.close();
		}
}		//report2 ended.
//Retrieve questions from file
class Questions{
	int numberOfQuestions;
	String[] questions;
	// retrieving questions from the file and saving in array.
	public Questions(File file){
		this.numberOfQuestions = 0;
		String temp ="";
		Scanner sc = new Scanner(System.in) ;
		try {
			sc = new Scanner(file);				//initializing the sc variable
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND, PLEASE CREATE A FILE FIRST!!!");
			e.printStackTrace();
		}
		while(sc.hasNext()){					
			/*as according to patter given each question is stored in a single line only.*/
			temp = sc.nextLine();
			this.numberOfQuestions++;				// increasing size of numberOfQuestions by 1
			questions[numberOfQuestions] = temp;	//putting value of temp string in question array.	
		}
	}
	//PartB of Assignment.
	public void sortQuestions(){
		Arrays.sort(questions);
		System.out.println();
	}
}		//ending class Questions.


