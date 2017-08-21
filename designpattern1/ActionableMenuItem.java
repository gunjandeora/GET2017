package designpattern1;
import java.awt.Desktop.Action;
// to trigger action depending on user's choice
public class ActionableMenuItem extends MenuItem{	
	Action action;
	// perform action depending on the choice.
	public void triggerAction(int choice){
		this.action.performAction(choice);
	}    
	public ActionableMenuItem(Action action) {
		this.action = action;
	}
}

