package View;
import java.util.Scanner;

import Facade.ProductFacade;
import Model.ProductDetails;
public class GetInput {
	public static ProductFacade productFacadeObject = ProductFacade.getInstance();
	Scanner inputScanner=new Scanner(System.in);
	public static void setFacadeObject(ProductFacade obj){
		productFacadeObject = obj;
	}
	// method to get productID from user.
		public static String getProductIDFromUser(){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the product ID");
			String productID=sc.next();
			return productID;
		}
		// method to update the file in memory based on the productID.
		public static void updateFile(String productID){
			Scanner scan = new Scanner(System.in);	
			System.out.println("Enter product name");
			String productName=scan.nextLine();			
			//to check enter value is not null or empty
			while(!isNotNull(productName)){
				System.out.println("Enter valid product name");
				productName=scan.next();
			}			
	        System.out.println("Enter product price");
			Double productPrice=scan.nextDouble(); 
			while(productPrice<=0){
				System.out.println("Enter valid product price");
				productPrice = scan.nextDouble();
			}
			ProductDetails productDetailsObject=new ProductDetails(Integer.parseInt(productID), productName, productPrice);		//details updated
			productFacadeObject.updateDetails(productDetailsObject);			
		}
		// method to update existing product in the product list
		public static void updateValues(){
			System.out.println("Enter Product ID For Details Updation");
			String productID=getProductIDFromUser();
			if(!isValidId(productID)){
				System.out.println("No Product id exist for updation ");
				return;
			}
			updateFile(productID);
		}	
		// method to add new product in the product list
		public static void addProduct(){
			String productID=getProductIDFromUser();
			while(!isValidEntity(productID)){
				System.out.println("Enter id in correct form");
				productID=getProductIDFromUser();
			}
			if(isValidId(productID)){
				System.out.println("Product Already in list");
				return;
			}
			else{
				updateFile(productID);
			}
		}
		
		//method to check that the productID is in list or not
		public static boolean isValidId(String productID){
			return productFacadeObject.getProductDetailsList().containsKey(Integer.parseInt(productID));
		}
		 //method to check enter entity is not empty or null
		public static boolean isNotNull(String entity){
			if(entity==null||entity==""){
				return false;
			}
			return true;
		}
		public static boolean isValidEntity(String entity){
			try{
				double parsedEntity=Double.parseDouble(entity);
			}catch(NumberFormatException e){
				return false;
			}
			return true;
		}
		
}
