package DS1;
import java.util.ArrayList;
import java.util.Scanner;
public class A2 {
    public static void main(String[] args) {
       AddArrayList addList = new AddArrayList();
    } 
}
class AddArrayList {
    void mergeList(ArrayList<Integer> first, ArrayList<Integer> second) {
        int secondSize = second.size() - 1;
        for (int i = 0; i <= secondSize; i++) {
            first.add(second.get(i));
        }
    }
    public AddArrayList() {
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
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
        AddArrayList merger = new AddArrayList();
        merger.mergeList(first, second);
        display(first);  
    }
    void display(ArrayList<Integer> list){
        for(Integer i: list){
            System.out.print(i);
        }
    }
}

