package DS2.Queue;
public class MyQueue {
    int front;
    int rear;
    Object[] array;
    MyQueue(){
        front=-1;
        rear=-1;
        array= new Object[10];
    }
    void enqueue(Object obj){
        if(front==-1 && rear == -1){
                front++;
        }
        array[++rear] = obj;
    }
	
    Object dequeue(){
        if(rear==-1){
            throw new NullPointerException("Underflow Exception");
        }
        else{
        Object temp = array[front];
        if(front == rear){
            front--;
            rear--;
            return temp;
        }
        for(int index = front ; index < rear ; index++){
            array[index] = array[index+1];
        }
        rear--;
        return temp;
        }
    }
    int size(){
            return rear+1;
    }	
    void makeEmpty(){
        rear=-1;
        front=-1;
    }
    Object getFront(){
        if(front==-1){
                throw new NullPointerException("Underflow Exception");
        }
        return array[front];
    }
	
    public String toString(){
        String myArray= "";
        for(int index = front ; index <= rear; index++){
                myArray+= array[index]+" ";
        }

        return myArray;
    }
}
