package view;
import java.util.Scanner;
public class Input {
	Scanner inputScanner = new Scanner(System.in);
	// to get choice of user for menu items shown to user
	public String getChoice() {
		String choice = "";
		System.out.println("Enter your choice");
		try{
			choice = inputScanner.next();
		}
		catch(Exception e){
			System.out.println("Invalid choice");
			return "";
		}
		return choice;
	}
	// to get product id from user
	public String getProductID() {
		String productID = "";
		System.out.println("Enter Product ID: ");
		try{
			productID = inputScanner.next();
		}
		catch(Exception e){
			System.out.println("Invalid choice");
			return "";
		}
		return productID;
	}
	// to get product quantity
	public String getProductQuantity() {
		String productQuantity = "";
		System.out.println("Enter Product Quantity: ");
		try{
			productQuantity = inputScanner.next();
		}
		catch(Exception e){
			System.out.println("Invalid choice");
			return "";
		}
		return productQuantity;
	}
}
