package Facade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import Facade.*;
import model.OrderedProduct;
import model.Product;
import model.UserCart;
import view.Display;
import view.Input;
public class Controller {
	Display displayOutput=Display.getInstance();
	Input getInput= new Input();
	CartOperation cartOperation ;
//	HashMap<Integer,Product> productDetailsList;
//	HashMap<Product, OrderedProduct> selectedProducts;
	//function to check if cart is empty or not.
	
	public Controller() throws IOException{
		cartOperation= new CartOperation();
		startShopping();
	}
	public boolean isCartNull(){
		if( cartOperation.isCartNull()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void startShopping() throws IOException{
		displayOutput.displayMainMenu();
		selectResponse(getInput.getChoice());
		
	}
	//method to perform action according to the choice given by the user.
	public void selectResponse(String choice) throws IOException{
		//condition to check if choice is valid or not.
		if(isValidChoice(choice)){
			//switch case to execute the selected choice.
			switch(Integer.parseInt(choice)){
			//to display product details
			case 1:	displayOutput.displayProducts(cartOperation.getProductDetails());
					break;
			// to add product to cart.
			case 2:	String ID=getInput.getProductID();
					while(!isNumber(ID)){
						ID=getInput.getProductID();
					}
					String productQuantity = getInput.getProductQuantity();
					while(!isNumber(productQuantity)){
							productQuantity=getInput.getProductQuantity();
					}
					cartOperation.addProductToCart(Integer.parseInt(ID),Integer.parseInt(productQuantity));
					break;
			//to delete product from cart.		
			case 3:	String productID=getInput.getProductID();
					while(!isNumber(productID)){
						productID=getInput.getProductID();
					}					
					cartOperation.deleteProductFromCart(Integer.parseInt(productID));
					break;
			//to update product quantity in cart.		
			case 4:	String Id=getInput.getProductID();
					while (!isNumber(Id)) {
						Id = getInput.getProductID();
					}
					String productQuantityy = getInput.getProductQuantity();
					while (!isNumber(productQuantityy)) {
						productQuantity = getInput.getProductQuantity();
					}
					cartOperation.updateProductCart(Integer.parseInt(Id),
							Integer.parseInt(productQuantityy));
					break;
			//to display user cart.
			case 5:	if(isCartNull()){
			        	return;
			        }
					displayOutput.displayUserCart(cartOperation.displayCart());	 
					break;
			//to generate bill.		
			case 6:	ArrayList<String> bill=cartOperation.generateBill();
					displayOutput.generateBill(bill);
					break;
			//to exit program.		
			case 7:	System.exit(0);
					break;
			}
		}
	}
	// to check the choice is a number or not.
	public boolean isNumber(String choice){
		try{
			int parsedChoice=Integer.parseInt(choice);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}	
	//method to check the choice given is valid or not.
	public boolean isValidChoice(String choice){
		if(isNumber(choice)){
			if(Integer.parseInt(choice)<0||Integer.parseInt(choice)>7){
				System.out.println("Please enter a valid choice");
				return false;
			}
			return true;
		}
		return false;
	}
}
