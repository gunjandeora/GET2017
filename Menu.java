package OOPs_Session4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
interface DisplayMenu {
	 void displayMenuItem();			//this can be user every time to display menu list of menu items.
}
class Action implements DisplayMenu{
	/* flag will be telling if a MenuITem is ActionableMenuItem or not by flag value.
	 * If it is an ActionableMenuItem then, Id and parentID will be sent to instance of class ActionableMenuItem 
	 */
	Boolean isActionable(){
		Boolean flag = false;
		return flag;
	}
	@Override
	public void displayMenuItem() {
	}
}
public class Menu implements DisplayMenu {
	String ID, name;
	ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
	@Override
	public void displayMenuItem() {
	}
}
class MenuItem extends Menu{
	String parentID;
}
class ActionableItem extends MenuItem{
	/*this method will be used to perform final action for any menuItem by calling other methods. 
	 * this will be end terminal for any menu list hierarchy. 
	 */
	void performActiom(){
	}
}

