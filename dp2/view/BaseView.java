package view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import controller.Controller;
import model.OrderedProduct;
import model.Product;
// singleton class to view all details.
public class BaseView {
	Scanner inputScanner=new Scanner(System.in);
    Controller controller=Controller.getInstance();
    Input userInput=Input.getInstance();
    Display displayOutput=Display.getInstance();
	private BaseView(){
		Menu.createMenu();
		while(true){
			displayOutput.displayMenu(Menu.getMenu());
		    String choice=userInput.getChoice();
		    controller.selectResponse(choice);
		}
	}
	private static BaseView baseView;
	public static BaseView getInstance(){
		if (baseView == null){
			baseView = new BaseView();
			return baseView;
		}
		else { 
			return baseView;
		}
	}
}
