package OOPs_Session4;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
interface DisplayMenu {
	 void displayMenuItem();			//this can be user every time to display menu list of menu items.
}
class Action implements DisplayMenu{
	Boolean isActionable(){
		Boolean flag = false;
		/*
		 * flag will be telling if a MenuITem is ActionableMenuItem or not by flag value.
		 * If it is an ActionableMenuItem then, Id and parentID will be sent to instance of class ActionableMenuItem 
		 */
		return flag;
	}
	@Override
	public void displayMenuItem() {
	}
}
public class Menu implements DisplayMenu {
	String ID, parentID, name;
	ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
	@Override
	public void displayMenuItem() {
	}
	
}
class MenuItem extends Menu{
	void addMenuItem(){
		/*
		 * method used to add any element in a particular menu.
		 */
	}
	void removeMenuItem(){
		/*
		 * This method can be used to remove any element from the hierarchy if ID and parentID is known.
		 * then by tracing the list the MenuItem can be removed.
		 */
	}
	void editMenuItem(){
		/*
		 * all the properties of any MenuItem that can be modified , that is it's name or if it's not any 
		 * ActionableMenuItem then it's further MenuItems list can be modified by calling above two methods. 
		 */
	}
}
class ActionableItem extends MenuItem{
	void performActiom(){
		/*
		 * this method will be used to perform final action for any menuItem by calling other methods. 
		 * this will be end terminal for any menu list hierarchy. 
		 */
	}
}

