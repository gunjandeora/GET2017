package designpattern1;
// class containing the string variable to display the option.
public class MenuItem extends Controller{
	private String displayName;
	public Integer choice;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public MenuItem (Integer choice, String name) {
		this.choice = choice;
		this.displayName = name;
	}
}


