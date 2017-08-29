package Facade;
import java.util.HashMap;

import DAO.ProductDetailsDao;
import DAO.ProductsConstants;
import Facade.ProductFacade;
import Model.ProductDetails;
import View.GetInput;
//Facade class to perform business logics and to validate input from the user
public class ProductFacade {
	String filePath;
	private static ProductFacade productFacadeObject;
	private HashMap<Integer,ProductDetails> productDetailsList=new HashMap<Integer,ProductDetails>();
	ProductDetailsDao productDetailsDaoObject = ProductDetailsDao.getInstance();
	//private constructor
	private ProductFacade(){
	}	
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static ProductFacade getInstance(){
		if(productFacadeObject==null){
			productFacadeObject=new ProductFacade();
		}
		return productFacadeObject;
	}
	
	public void startProject(){
		ProductDetailsDao productDetailsDaoObject = ProductDetailsDao.getInstance();				// Initializing DAO object
		retrieveValues();
		GetInput input = new GetInput();
		String tempProductId = input.getProductIDFromUser();
		input.updateFile(tempProductId);														//updating information for any ID
		input.addProduct(); 																	//adding value for any product in the list	
		
	}
	
	// getter and setter of Hash map of productDetailsList containing key as productID
	public HashMap<Integer, ProductDetails> getProductDetailsList() {
		return productDetailsList;
	}
	public void setProductDetailsList(HashMap<Integer, ProductDetails> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
       //method to retrieve values from the files using dao class
	public void retrieveValues(){
	productDetailsDaoObject.setFilePath(ProductsConstants.PRODUCT_DETAILS_FILE_PATH);		//Initializing file to retrieve data
	productDetailsList=productDetailsDaoObject.readProductDetails();						//saving data in List
	}
   /*
    * method to update the products in files and in hashmaps
    */
	public void updateDetails(ProductDetails productDetailsObject){
		int productCode=productDetailsObject.getProductCode();
		productDetailsList.put(productCode, productDetailsObject);
		productDetailsDaoObject.writeToFile(productDetailsList);						//updating text file
	}
	//displaying final list on the console
	public void displayDetails(){
		System.out.println(getProductDetailsList());
	}
}
