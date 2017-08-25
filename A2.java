package DS1;
import java.util.ArrayList;
import java.util.Scanner;
public class A2 {
    public static void main(String[] args) {
       AddArrayList addList = new AddArrayList();
    } 
}
class AddArrayList {
    // merging list second in first
    void mergeList(MyArrayList first, MyArrayList second) {
        int secondSize = second.size() - 1;
        for (int i = 0; i <= secondSize; i++) {
            first.add(second.get(i));
        }
    }
    // constructor calling other methods
    public AddArrayList() {
        MyArrayList first = new MyArrayList();
        MyArrayList second = new MyArrayList();
        System.out.println("How many element you want to display in first Array list");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter value:");
            first.add(sc.nextInt());
        }
        display(first);
        System.out.println("How many element you want to display in Second Array list");
        sc = new Scanner(System.in);
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
                System.out.println("Enter value:");
                second.add(sc.nextInt());
        }
        mergeList(first, second);
        display(first);  
    }
    void display(ArrayList list){
        for(Integer i: list){
            System.out.print(i);
        }
    }
}

