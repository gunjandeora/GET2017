package OOPs_Session1;
import java.util.*;
//Buttons, Layout, Display, Command/Operation
interface Display{
	//print operator operands and result
	void printExpression(String Expression);	
}
public class A1 {
			//calling calculator class
	Calculator calculator = new Calculator();
}
// calling main Calculator class.
class Calculator {
	/* starting with layout of screen and then with layout of buttons
	 * then setting values of buttons for different numbers and operators.  
	 */
	// each calculator has its own layout so let it be private
	private Layout layout = new Layout();
	//calling createLayout method.
	// using object setting display values of screen and then using button object array
	//and setting display values of each button.	
	/* setting values for each button 
	 * specifying their functions for operators or operands
	 * using setButtonType method. 
	 */
	//SOP(enter number of buttons);
	Button button[] = new Button[20];				//number of buttons can be taken from the user and intialized later.
	//assigning type for button .
	/*//button[0].setButtonType("+");	*/
	
	/* Evaluating any value, calling operation class 
	 * and displaying final values in queues.
	 */
	static Queue<String> resultQueue = new LinkedList<String>();
	// add values to this queue and perform operations using operation class.
	Operation operation1 = new Operation(resultQueue);
	/*//operation1.getResult();				//retrieving result for operation by retrieving values 
	 * 											queue using getButtonType and calculating result.
	 *  operation1.printExpression			method will be printing all values present in queue
	 *  operation1.emptyQueue				remove all values present in queue.		 */
}
//class for specifications for each button. 
class Button{
	int buttonSizeLength;
	int buttonSizeWidth;
	int buttonPositionX;
	int buttonPositionY;
	String buttonType;
	boolean ispressed;
	// initialize button types.
	public void setButtonType(String str){
		buttonType = str;						
		// method to set the type of whether its a operator or operand.
	}
	public String getButtonType(){
		//method to get type of button pressed
		/*switch cases will be used to represent different button types, with number cases 
		for numbers and Alphabets for different operators.
		*/
		return "";			//return string for type of button used in expression.
	}
}
//Performs operations
class Operation implements Display {
	float operandOne;
	float operandTwo;
	String operator;
	//initializing values of operand1 and operand2
	
	Operation(Queue<String> resultQueue){
		// get buttonType
		// add the appropriate buttonType into queue
		// check if the type is of operand type or operator type.
			//check if operator is before operand just push the operator
			// if operand is before operator perform the result and add it to the queue.
		// calling getResult from this constructor only using appropriate parameters.
		//and at last calling emptyQueue.
	}
	//called each time from constructor for each operation.
	String getResult(float operandOne, float operandTwo , String operator){
		String value ="";
		//check what is in queue . if its a operand before then retrieves operand and operator 
		//from queue and insert result.
		// return result of queue.
		//check button type to be "="
		return value;
	}
	void emptyQueue(){
		// empty the queue (reset the queue)
	}
	@Override
	public void printExpression(String Expression) {
		// printing values in queue.		
	}	
	//printing final Expression.
}
// layout of screen and buttons
class Layout{
	int screenSizeLength,  screenSizeWidth;
	int posScreenX, posScreenY;
	void createLayout(){
		/*initialize screen with it's appropriate variables.
		 */
		}
}
