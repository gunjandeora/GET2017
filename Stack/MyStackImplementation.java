package ds2.Stack;
import ds2.Stack.InfixToPostfix;
import ds2.Stack.MyStack;
import java.util.Scanner;
public class MyStackImplementation {
    public static void main(String[] args) {		
        Scanner sc = new Scanner(System.in);   
        MyStack stack = new MyStack();  
    char ch; 
    try{
        do{
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");    
            System.out.println("6. Convert Infix to Postfix");
            System.out.println("7. Display Stack");
            int choice = sc.nextInt();
            switch (choice) {
            case 1 :
                System.out.println("Enter integer element to push");
                stack.push(sc.next().charAt(0)); 
                break;                         
            case 2 : 
                System.out.println("Popped Element = "+ stack.pop());   
                break;                         
            case 3 : 
                System.out.println("Peek Element = "+ stack.peek());
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ stack.isEmpty());
                break;                
            case 5 : 
                System.out.println("Size = "+ stack.size()); 
                break;                
            case 6 : 
                System.out.println("Enter infix operation=");
                System.out.println("Postfix string is= "+new InfixToPostfix().getPostfix(sc.next()));
                break;  
            case 7:
                System.out.println("Stack is=");
                stack.display();
                break;
            default: 
                System.out.println("Wrong Entry \n ");
                break;
            }  
            stack.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);       
        } while (ch == 'Y'|| ch == 'y');          
    }
    catch(Exception e){
            e.getMessage();
            main(args);
    }
    }
}