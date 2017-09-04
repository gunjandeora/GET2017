package controller;
import java.util.ArrayList;
import java.util.HashMap;
import view.BaseView;
import view.Display;
import view.Input;
import model.OrderedProduct;
import model.Product;
import facade.CartOperation;
/*class to select response on the basis of user choice and also to perform validations */
public class Controller {
	private static Controller controller;
	Display displayOutput=Display.getInstance();
	Input getInput= Input.getInstance();
	HashMap<Integer,Product> productDetailsList;
	HashMap<Product, OrderedProduct> selectedProducts;
	private Controller(){	}
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static Controller getInstance(){
		if (controller == null){
			controller = new Controller();
			return controller;
		}
		else {
			return controller;
		}
	}
	//function to check if cart is empty or not.
	public boolean isCartNull(){
		if( selectedProducts.size()==0){
			return true;
		}
		else{
			return false;
		}
	}	
	//method to preform action according to the choice given by the user.
	public void selectResponse(String choice){
		//condition to check if choice is valid or not.
		if(isValidChoice(choice)){
			CartOperation cartOperationsFacade=CartOperation.getInstance();
			//switch case to execute the selected choice.
			switch(Integer.parseInt(choice)){
			//to display product details
			case 1:	productDetailsList = cartOperationsFacade.displayProductList();
			displayOutput.displayProducts(productDetailsList);
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
					cartOperationsFacade.addProductToCart(Integer.parseInt(ID),Integer.parseInt(productQuantity));
					break;
			//to delete product from cart.		
			case 3:	String productID=getInput.getProductID();
					while(!isNumber(productID)){
						productID=getInput.getProductID();
					}					cartOperationsFacade.deleteProductFromCart(Integer.parseInt(productID));
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
					cartOperationsFacade.updateProductCart(Integer.parseInt(Id),
							Integer.parseInt(productQuantityy));
					break;
			//to display user cart.
			case 5:	 selectedProducts=cartOperationsFacade.displayCart();
					if(isCartNull()){
			        	return;
			        }
					displayOutput.displayUserCart(selectedProducts);
					break;
			//to generate bill.		
			case 6:	ArrayList<String> bill=cartOperationsFacade.getBill();
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
				displayOutput.messageHandler("Enter correct choice");
				return false;
			}
			return true;
		}
		return false;
	}
	/* method to handle messages and call display output function to display message.
	 */
	public void messageHandler(String message){
		displayOutput.messageHandler(message);
	}
}

