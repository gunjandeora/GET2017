package view;
import java.util.Scanner;
public class Input {
	private static Input inputInstance;
	Scanner inputScanner = new Scanner(System.in);
	private Input() {}
	// getting instance of singleton class Input
	public static Input getInstance() {
		if(inputInstance== null){
			inputInstance = new Input();
			return inputInstance;
		}
		else{
			return inputInstance;			
		}
	}
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
