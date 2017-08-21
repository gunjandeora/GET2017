package designpattern1;
import Facade.ProductFacade;
import designpattern1.Model.ProductDetails;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// Controller class contains all the methods based on the menu which a program is performing .
public class Controller extends Action  {
    Controller() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	// Facade class object
	static ProductFacade productFacadeObject=ProductFacade.getInstance();
	// method to update the file and in memory based on the productID.
	public static void updateFile(String productID){
		Scanner inputScanner=new Scanner(System.in);
		System.out.println("Enter product type");
		String productType=inputScanner.next();
		
		//to check enter value is not null or empty
		while(!productFacadeObject.isNotNull(productType)){
			System.out.println("Enter valid product type");
			productType=inputScanner.next();
		}
		System.out.println("Enter product name");
		String productName=inputScanner.next();
		
		//to check enter value is not null or empty
		while(!productFacadeObject.isNotNull(productName)){
			System.out.println("Enter valid product name");
			productType=inputScanner.next();
		}
		
                System.out.println("Enter product name");
		Double productPrice=inputScanner.nextDouble();
                
		ProductDetails productDetailsObject=new ProductDetails(Integer.parseInt(productID), productType, productName, productPrice);
		
		System.out.println("Enter the cost to update");
		String cost=inputScanner.next();
		while(!productFacadeObject.isValidEntity(cost)){
			System.out.println("Enter a valid cost");
			cost=inputScanner.next();
		}
		productFacadeObject.updateDetails(productDetailsObject);
		
	}
	// method to get productID from user.
	public static String getProductIDFromUser(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product ID");
		String productID=sc.next();
		return productID;
	}
	// method to update existing product in the product list
	public static void updateValues(){
		System.out.println("Enter Product ID For Details Updation");
		String productID=getProductIDFromUser();
		if(!productFacadeObject.isValidId(productID)){
			System.out.println("No Product id exist for updation ");
			return;
		}
		updateFile(productID);
	}
	// method to add new product in the product list
	public static void addProduct(){
		System.out.println("Enter Product ID To add in Product list");
		String productID=getProductIDFromUser();
		while(!productFacadeObject.isValidEntity(productID)){
			System.out.println("Enter id in correct form");
			productID=getProductIDFromUser();
		}
		if(productFacadeObject.isValidId(productID)){
			System.out.println("Product Already in list");
			return;
		}
		else{
			updateFile(productID);
		}
	}
	/**
	 * method to display all the products and its corresponding details
	 */
	public static void productDetailsDisplay(){
		productFacadeObject.retrieveValues();
		HashMap<Integer,ProductDetails> productDetailsList=productFacadeObject.getProductDetailsList();
		System.out.println("Product ID\tProduct Type\tProduct Name");
		for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
			System.out.println( mapSet.getValue().getProductCode()+"\t\t"+
								   mapSet.getValue().getProductType()+"\t\t"+
								   mapSet.getValue().getProductName());
		}
			System.out.println("\n");
	}
	//switch case to perform suitable action
	@Override
	public void performAction(int choice) {
		
		productFacadeObject.retrieveValues();
		 switch(choice){
		 case 1: Controller.productDetailsDisplay();
		         break;
		 case 2: Controller.addProduct();
		 		 break;
		 case 3: Controller.updateValues();
		         break;
		 case 4: System.exit(0);
		         break;
		 }		
	}
}