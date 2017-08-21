package designpattern1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import designpattern1.Controller;
// class containing the list of menu items and sub menus present in a menu. 
public class Menu extends MenuItem{
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	//method to create menu
		public  static Menu createMenu(){
			Menu mainMenu=new Menu();
			MenuItem mi=new ActionableMenuItem(new Controller());
			List<MenuItem> subMenu=mainMenu.getSubMenu();
			mi.setDisplayName("1.Display Product Details List");
			subMenu.add(mi);
			mi=new ActionableMenuItem(new Controller());
			mi.setDisplayName("2.To add Products in List");
			subMenu.add(mi);
			mi=new ActionableMenuItem(new Controller());
			mi.setDisplayName("3.To update Products in list");
			subMenu.add(mi);
			mi=new ActionableMenuItem(new Controller());
			mi.setDisplayName("4.Exit");
			subMenu.add(mi);			
			return mainMenu;
	}
		//display menu
	public static void display(Menu menu){			
			Iterator<MenuItem> itr=menu.getSubMenu().iterator();			
			while(itr.hasNext()){
				System.out.println(itr.next().getDisplayName());
			}		
		}
	//to get user's choice
	public static int getInput(){
		try{
		Scanner scan= new Scanner(System.in);
		String choice=scan.next();
	    int validChoice=Integer.parseInt(choice);
		return validChoice;
	}catch(Exception e){
		return -1;
	}		
	}
	//function to get the selected menu item.
	public MenuItem getSelection(int choice){
		if(choice>subMenu.size()||choice<=0){
			System.out.println("\nWrong choice ");
			System.out.println("\nEnter Again");
			return null;
		}
		return subMenu.get(choice-1);
	}	
	//to display menu and call trigger function
	public static void displayAndPerformAction(Menu menu){		
		display(menu);		
		int choice=getInput();
		MenuItem menuItem= menu.getSelection(choice);
		if(menuItem==null){
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem){
			((ActionableMenuItem)menuItem).triggerAction(choice);
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
	}
}

