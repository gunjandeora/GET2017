package DS5.Concordance;
public class MyNode<T>{  
	T data;
	MyNode<T> next;
    public MyNode(){
        next = null;
        data = null;
    }    
    public MyNode(T data,MyNode<T> next){
        this.data = data;
        this.next = next;
    }    
    public void setLink(MyNode<T> next){
        this.next = next;
    }    
    public void setData(T data){
        this.data = data;
    }    
    public MyNode<T> getLink(){
        return this.next;
    }   
    public T getData(){
        return this.data;
    }
}