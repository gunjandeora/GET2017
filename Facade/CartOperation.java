package Facade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import DAO.ProductDetailsInMemory;
import model.*;
//Facade class to perform business logics and to validate input from the user
public class CartOperation {
	ProductDetailsInMemory productDetailsInMemoryObject = new ProductDetailsInMemory();
	HashMap<Integer,Product> productDetails;
	static UserCart userCart = new UserCart();
	public CartOperation() throws IOException{
		productDetails = productDetailsInMemoryObject.readProductDetails();
	}
	/*
	 * getter for productDetails list
	 */
	public HashMap<Integer,Product> getProductDetails() {
		return productDetails;
	}
	/*
	 * getter and setter for selected products list
	 */
	public static HashMap<Integer,OrderedProduct> getSelectedProducts() {
		return userCart.getSelectedProducts();
	}
	public static void setSelectedProducts(HashMap<Integer, OrderedProduct> selectedProducts) {
		userCart.setSelectedProducts(selectedProducts);
	}
	/* method to check if product is present in product list 
	 */
	public boolean isProductInProductDetails(int productID){
		if(productDetailsInMemoryObject.getProductList().containsKey(productID)){
			return true;
		}
		return false;
	}
	/* method to check if product is present in cart or not 
	 */
	public boolean isProductInCart(int productID){
		if(userCart.getSelectedProducts().containsKey(productID)){
			return true;
		}
		return false;
	}
	// method to check if cart is empty or not 
	public boolean isCartNull(){
		if( userCart.getSelectedProducts().isEmpty()){
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
			if(isProductInCart(productID)){
				int quantity = userCart.getSelectedProducts().get(productID).getProductQuantity();
				quantity+=productQuantity;
				updateProductCart(productID, quantity);												
			}
			else{
				totalProductCost=(productDetails.get(productID).getProductPrice())*productQuantity;
				userCart.selectedProducts.put(productID, new OrderedProduct(productID, productQuantity, totalProductCost));	//updating cart	
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
					if(isProductInCart(productID)){	
					//deleting the product from hashmap having selected products.
						userCart.selectedProducts.remove(productID);
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
		public HashMap<Integer, OrderedProduct>  displayCart(){
			//condition to check if cart is empty
			if(isCartNull()){
				System.out.println("Cart is empty");
			}
			return userCart.getSelectedProducts();
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
					if(isProductInCart(productID)){
						double totalProductCost;
						//updating the value of quantity of product.
						int quantity = userCart.selectedProducts.get(productID).getProductQuantity();
						totalProductCost = (quantity + productQuantity)* productDetails.get(productID).getProductPrice();
						userCart.selectedProducts.put(productID, new OrderedProduct(productID, quantity + productQuantity, totalProductCost)  );  //updating quantity of product		
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
		for(Map.Entry<Integer,OrderedProduct> mapSet :userCart.getSelectedProducts().entrySet()){
			finalCost+=mapSet.getValue().getTotalCost();
			bill.add(mapSet.getKey()+"\t\t"+productDetails.get(mapSet).getProductType()	+"\t"+productDetails.get(mapSet).getProductName() +"\t\t"+mapSet.getValue().getProductQuantity());
		}
		bill.add("********************************************************");

		bill.add("                 Individual Product Cost                ");
		for(Map.Entry<Integer,OrderedProduct> mapSet :userCart.getSelectedProducts().entrySet()){
			bill.add(mapSet.getKey() +"\t"+productDetails.get(mapSet).getProductName() +" =\t"+mapSet.getValue().getTotalCost());
		}
		bill.add("********************************************************");
		bill.add("                       Total Cost                       ");
		bill.add("********************************************************");
		bill.add("Total Price : "+finalCost);
			return bill;
	}
}
