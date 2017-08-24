package DS2.Queue;
public class MyArrayList{
    static final int SIZE= 5;
    Object array[];
    int index;
    int size;
    public MyArrayList(){
        array= new Object[SIZE];
        index= 0;
        size= 5;
    }
	/* called if size has enteded the maximum limit, so increase max limit */
    public void extendArraySize(){
        Object newArray[]= new Object[array.length+SIZE];
        for(int arrIndex= 0; arrIndex < size; arrIndex++){
                newArray[arrIndex]= array[arrIndex];
        }
        array= newArray;
        size= newArray.length;
    }
    public int size(){
        return index;
    }
	// adding elements in array list
    public void add(Object obj){
        if(index >= size){
                extendArraySize();
        }
        array[index++]= obj;
    }
	// add element at a particular location in array MyArrayList
    public void add(Object obj, int position){
        if(position < 0 || position > this.size()){
            System.out.println("InValid Position");
            return;
        }
        if(index >= size-1){
            extendArraySize();
        }
        if(position == index){
            array[index]= obj;
            index++;
        }else{
            for(int arrIndex= index; arrIndex > position; arrIndex--){
                array[arrIndex]= array[arrIndex-1];
            }
            array[position]= obj;
            index++;
        }
    }
	// adding all members of list in array MyArrayList
    public void addAll(MyArrayList list){
        for(int arrIndex = 0; arrIndex < list.size(); arrIndex++){
            this.add(list.get(arrIndex));
        }
    }
    public Object get(int position){
        if(position < 0 || position >= this.size()){
            System.out.println("InValid Position");
            return null;
        }
        for(int arrIndex= 0; arrIndex < this.size(); arrIndex++){
            if(arrIndex == position){
                return array[arrIndex];
            }
        }
        System.out.println("Not Found");
        return null;
    }
	// get index for particular data value
    public int getIndex(Object obj){
        int arrIndex = 0;
        for( ;arrIndex < this.size(); arrIndex++){
            if(array[arrIndex] == obj){
                    return arrIndex;
            }
        }
        System.out.println("Not Found");
        return -1;
    }
	// searching index for data value after a particular position
    public int getIndexFrom(Object obj, int position){
        if(position < 0 || position >= this.size()){
            System.out.println("InValid Position");
            return -1;
        }
        int arrIndex = position;
        for( ;arrIndex < this.size(); arrIndex++){
            if(array[arrIndex] == obj){
                return arrIndex;
            }
        }
        System.out.println("Not Found");
        return -1;
    }
// delete element from location
    public void removeAt(int position){
        if(position < 0 || position >= this.size()){
            System.out.println("InValid Position");
            return;
        }
        if(this.size() == 0){
            System.out.println("You Cannot Perform Delete Operation In Empty List");
            return;
        }else{
            for(int arrIndex= position; arrIndex < this.size()-1; arrIndex++){
                    array[arrIndex]= array[arrIndex+1];
            }
            index--;
        }
    }
	// removing by data value
    public void remove(Object obj){
        if(this.size() == 0){
            System.out.println("You Cannot Perform Delete Operation In Empty List");
            return;
        }else{
            for(int row= 0; row < this.size(); row++){
                if(array[row] == obj){
                    for(int arrIndex= row; arrIndex < this.size()-1; arrIndex++){
                        array[arrIndex]= array[arrIndex+1];
                    }
                    index--;
                    return;
                }	
            }
            System.out.println("Element Is Not Available");
        }
    }
	// clear the whole array MyArrayList
    public void clear(){
            index= 0;
    }
	
    public MyArrayList reverse(){
        if(this.size() == 0){
            System.out.println("Empty List");
            return null;
        }else{
            MyArrayList reverseArray = new MyArrayList();
            for(int arrIndex= this.size()-1; arrIndex >= 0; arrIndex--){
                    reverseArray.add(this.array[arrIndex]);
            }
            return reverseArray;
        }
    }
	// sends array MyArrayList
    Object[] getObjectArray(){
            return this.array;
    }
	
    public MyArrayList sort(){
        if(this.size() == 0){
            System.out.println("Empty List");
            return null;
        }else{
            Object temp;
            for (int row= 0; row < this.size()-1; row++){
            for (int col= row+1; col < this.size(); col++){
                if ((Integer)this.array[row] > (Integer)this.array[col]){
                    temp =  this.array[row];
                    this.array[row] = this.array[col];
                    this.array[col] = temp;
                }
            }
            }
                return this;
        }
    }
    public String toString(){
        if(this.size() == -1){
            return "{}";
        }
        String string= "";
        for(int index= 0; index < this.size(); index++){
            string+= array[index]+",";
        }
        return string;
    }
}