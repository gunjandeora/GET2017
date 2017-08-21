package designpattern1;
public class DesignPattern1 {
    public static void main(String[] args) {
        Menu menu=Menu.createMenu();
	while(true){
	Menu.displayAndPerformAction(menu);
	}	
    }
}
