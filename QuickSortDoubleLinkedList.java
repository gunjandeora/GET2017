package DS1;
public class QuickSortDoubleLinkedList {
    /* A recursive implementation of quicksort for linked list */
    void quickSort(Node<Integer> last,Node<Integer> start)
    {
        if(start!=null && last!=start && last!=start.next){
            Node<Integer> temp = partition(last,start);
            quickSort(last,temp.getPrevious());
            quickSort(temp.next,start);
        }
    }
    
    Node<Integer> partition(Node<Integer> last, Node<Integer> start)
    {
       // set pivot as start element
        int x = start.data;
        // similar to i = last-1 for array implementation
        Node<Integer> i = last.getPrevious();
        // Similar to "for (int j = last; j <= start- 1; j++)"
        for(Node<Integer> j=last; j!=start; j=j.next)
        {
            if(j.data <= x)
            {
                // Similar to i++ for array
                i = (i==null) ? last : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i==null) ? last : i.next;  // Similar to i++
        int temp = i.data;
        i.data = start.data;
        start.data = temp;
        return i;
    }   
     // The main function to sort a linked list. It mainly calls _quickSort()
}
