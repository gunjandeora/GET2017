package view;
import java.util.Scanner;
import controller.Controller;
// Class to get input values from user.
public class Input {
	private static Input getInput;
	private Input() {
	}
	// function to get instance of singleton class
	public static Input getInstance() {
		if (getInput == null) {
			getInput = new Input();
		}
		else {
			return getInput;
		}
	}
	Scanner inputScanner = new Scanner(System.in);
	// to get choice of user for menu items shown to user
	public String getChoice() {
		System.out.println("Enter your choice");
		String choice = inputScanner.next();
		return choice;
	}
	// to get product id from user
	public String getProductID() {
		System.out.println("Enter Product ID: ");
		String productID = inputScanner.next();
		return productID;
	}
	// to get product quantity
	public String getProductQuantity() {
		System.out.println("Enter Product Quantity: ");
		String productQuantity = inputScanner.next();
		return productQuantity;
	}
}
