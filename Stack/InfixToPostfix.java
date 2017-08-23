package ds2.Stack;

public class InfixToPostfix {
    MyStack stack;
    String input;
    String output;
    InfixToPostfix(){
        stack = new MyStack();
        input = "";
        output = "";
    }
    public String getPostfix(String input){
        this.input = input;
        char ch;
        for(int index = 0; index < input.length(); index++){
            ch = input.charAt(index);
            switch(ch){
            case '+' :
            case '-' :	stackOperation(ch , 1); 	break;
            case '*' :
            case '/' :	stackOperation(ch , 2); 	break;
            case '(' :	stackOperation(ch , 1); 	break;
            case ')' :	stackOperation(ch , 1);     break;
            default  :
                if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                        output+=ch;
                }else{
                        System.out.println("Please Enter Valid String");
                        MyStackImplementation.main(new String[]{});
                }
                break ;
            }

        }

        while(stack.size()!=0){
            System.out.println("yy");
            char ch1 = stack.pop();
            output += ch1;
        }
        return output;
    }
	
    public void stackOperation(char operator , int prec1){
        if( operator == ')'){
            char ch;
            do{
                if(stack.size()==0){
                    System.out.println("wrong");
                    return;
                }
                ch = stack.pop();
                if(ch == '('){
                    return;
                }
                output += ch;
            }while( ch != '(');
            return;
        }

        if(stack.size()==0){
            stack.push(operator);
            stack.display();
            return;
        }
        while(stack.size()!=0){
            char popOp=stack.pop();
            int prec2=0;
            if( operator == '('){
                stack.push(popOp);
                stack.push(operator);
                return;
            }
            if(popOp == '+' || popOp == '-'){
                prec2= 1;
            }
            else if(popOp == '*' || popOp == '/'){
                prec2= 2;
            }
            if(prec1 <= prec2){
                output += popOp;
            }
            else{
                stack.push(popOp);
                break;
            }
        }
    stack.push(operator);
    }
}