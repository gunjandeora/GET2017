package Facade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DAO.ProductDetailsInMemory;
import model.*;
//Facade class to perform business logics and to validate input from the user
public class CartOperation {
	private static CartOperation cartOperationsObject;
	private static HashMap<Product, OrderedProduct> selectedProducts;
	ProductDetailsInMemory productDetailsInMemory = new ProductDetailsInMemory();
	HashMap<Integer, Product> productDetails;
	UserCart userCart = new UserCart();
	// private constructor called in getInstance method, Initialize the userCart
	private CartOperation() throws IOException {
		userCart = new UserCart();
		selectedProducts = userCart.getSelectedProducts();
		productDetails = productDetailsInMemory.readProductDetails();
	}
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static CartOperation getInstance() throws IOException{
		if(cartOperationsObject==null){
			cartOperationsObject=new CartOperation();
			return cartOperationsObject;
		}
		return cartOperationsObject;
	}
	/*
	 * getter and setter for productDetails list
	 */
	public HashMap<Integer, Product> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(HashMap<Integer, Product> productDetails) {
		this.productDetails = productDetails;
	}
	/*
	 * getter and setter for selected products list
	 */
	public static HashMap<Product, OrderedProduct> getSelectedProducts() {
		return selectedProducts;
	}
	public static void setSelectedProducts(HashMap<Product, OrderedProduct> selectedProducts) {
		CartOperation.selectedProducts = selectedProducts;
	}
	/* method to display product list which return hash map od product details
	 */
	public HashMap<Integer,Product> displayProductList(){
		return productDetailsInMemory.getProductList();
	}
	/* method to check if product is present in product list 
	 */
	public boolean isProductInProductDetails(int productID){
		if(productDetailsInMemory.getProductList().containsKey(productID)){
			return true;
		}
		return false;
	}
	/* method to check if product is present in cart or not 
	 */
	public boolean isProductInCart(Product productDetails){
		if(userCart.getSelectedProducts().containsKey(productDetails)){
			return true;
		}
		return false;
	}
	// method to check if cart is empty or not 
	public boolean isCartNull(){
		if( selectedProducts.size()==0){
			return true;
		}
		else{
			return false;
		}
	}
	/* method to add product to cart along with the quantity requested by the user.
	 */
	public void addProductToCart(int productID,int productQuantity ){
		double totalProductCost;
		//condition to check if requested product is present in productList or not.
		if(isProductInProductDetails(productID)){
			//condition to check if requested product is present in cart or not.
			if(isProductInCart(productDetails.get(productID))){
				int quantity=selectedProducts.get(productDetails.get(productID)).getProductQuantity();
				quantity+=productQuantity;
//				selectedProducts.get(productDetails.get(productID)).setProductQuantity(quantity);		//updating new total quantity of product.
//				totalProductCost=(productDetails.get(productID).getProductPrice())*quantity;				
//				selectedProducts.get(productDetails.get(productID)).setTotalCost(totalProductCost);		//updating new total costs of product.
				updateProductCart(productID, quantity);												
			}
			else{
				totalProductCost=(productDetails.get(productID).getProductPrice())*productQuantity;
				selectedProducts.put(productDetails.get(productID), new OrderedProduct(productID, productQuantity, totalProductCost));
				userCart.setSelectedProducts(selectedProducts);			//updating cart
			}
			System.out.println("Product "+ productID+ " has been successfully added to your cart");
		}
		else{
			System.out.println("Product does not exist!!!");
		}
	}
	
	// method to delete product from cart.
		public boolean deleteProductFromCart(int productID){
			//condition to check if cart is empty
			if(isCartNull()){
				System.out.println("Cart is empty!!");
				return false;
			}
			else{
				//condition to check if requested product is present in productList or not.
				if(isProductInProductDetails(productID)){
					//condition to check if requested product is present in cart or not.
					if(isProductInCart(productDetails.get(productID))){	
					//deleting the product from hashmap having selected products.
						selectedProducts.remove(productDetails.get(productID));
						System.out.println("product Removed Successfully");
						return true;
					}
					else{
						System.out.println("Product is not present in cart");
						return false;
					}
				}
				else{
					System.out.println("Product does not exist");
					return false;
				}
			}		
		}
		/*
		 * method to display cart to user.This will return a hash map to Facade class.
		 */
		public HashMap<Product, OrderedProduct>  displayCart(){
			//condition to check if cart is empty
			if(isCartNull()){
				System.out.println("Cart is empty");
			}
			return selectedProducts;
		}
		
		/*
		 * method to update the value already present in cart. 
		 */
		public boolean updateProductCart(int productID,int productQuantity){
			//condition to check if cart is empty
			if(isCartNull()){
				System.out.println("Cart is empty");
				return false;
			}
			else{
				//condition to check if requested product is present in productList or not.
				if(isProductInProductDetails(productID)){
					//condition to check if requested product is present in cart or not.
					if(isProductInCart(productDetails.get(productID))){
						double totalProductCost;
						//updating the value of quantity of product.
						selectedProducts.get(productDetails.get(productID)).setProductQuantity(productQuantity);		//updating quantity of product				
						totalProductCost=(productDetails.get(productID).getProductPrice())*productQuantity;				
						selectedProducts.get(productDetails.get(productID)).setTotalCost(totalProductCost);		//updating new total costs of product.
						System.out.println(productID+ " updated Successfully with new Quantity" + productQuantity + " with total cost as " + totalProductCost);
						return true;
					}
					else{
						System.out.println("Product not present in cart");
						return false;
					}
				}
				else{
				System.out.println("Product does not exist");
					return false;
				}
			}
		}
		
		/* method to generate the bill and return a list to the controller.
		 */
	public ArrayList<String> generateBill(){
		//arraylist to store the bill.
		ArrayList<String> bill=new ArrayList<String>();
		bill.add("********************************************************");
		bill.add("                        YOUR BILL                       ");
		bill.add("********************************************************");
		bill.add("Product Code    Product Type    Product Name    Quantity");
		double finalCost=0;
		for(Map.Entry<Product,OrderedProduct> mapSet :userCart.getSelectedProducts().entrySet()){
			finalCost+=mapSet.getValue().getTotalCost();
			bill.add(mapSet.getKey().getProductID()+"\t\t"+mapSet.getKey().getProductType()
					+"\t"+mapSet.getKey().getProductName()+"\t\t"+mapSet.getValue().getProductQuantity());
		}
		bill.add("********************************************************");

		bill.add("                 Individual Product Cost                ");
		for(Map.Entry<Product,OrderedProduct> mapSet :userCart.getSelectedProducts().entrySet()){
			bill.add(mapSet.getKey().getProductID()+"\t"+mapSet.getKey().getProductName()+" =\t"+mapSet.getValue().getTotalCost());
		}
		bill.add("********************************************************");
		bill.add("                       Total Cost                       ");
		bill.add("********************************************************");
		bill.add("Total Price : "+finalCost);
			return bill;
	}
}
