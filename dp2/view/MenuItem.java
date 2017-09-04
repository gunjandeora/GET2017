package view;
//Class to store details of menu option
class MenuItem {
	private String menuName;
	private int menuOption;	
	//default constructor
	public MenuItem() {
	}
	//parameterized constructor
	public MenuItem(int option, String menuitem) {
		this.menuName  = menuitem;
		this.menuOption= option; 
	}
	public String getMenuItemName(){
		return this.menuName;
	}
	public int getMenuItemOption(){
		return this.menuOption;
	}
}
