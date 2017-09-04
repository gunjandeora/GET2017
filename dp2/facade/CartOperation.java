package facade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import view.BaseView;
import dao.ProductDetailsInMemoryDao;
import model.OrderedProduct;
import model.Product;
import model.UserCart;
//Class having functions to be performed for cart operations.
public class CartOperation {
	private static CartOperation cartOperationsFacadeObject;
	private static HashMap<Product, OrderedProduct> selectedProducts;
	ProductDetailsInMemoryDao productDetailsInMemoryDao = new ProductDetailsInMemoryDao();
	Controller controller = Controller.getInstance();
	HashMap<Integer, Product> productDetails;
	public HashMap<Integer, Product> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(HashMap<Integer, Product> productDetails) {
		this.productDetails = productDetails;
	}
	UserCart userCart;
	private CartOperation() {
		userCart = new UserCart();
		selectedProducts = userCart.getSelectedProducts();
		productDetails = productDetailsInMemoryDao
				.readProductDetails("ProductDetails.txt");

	}
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static CartOperation getInstance(){
		if(cartOperationsFacadeObject==null){
			cartOperationsFacadeObject=new CartOperation();
			return cartOperationsFacadeObject;
		}
		return cartOperationsFacadeObject;
	}
	public static HashMap<Product, OrderedProduct> getSelectedProducts() {
		return selectedProducts;
	}
	public static void setSelectedProducts(
			HashMap<Product, OrderedProduct> selectedProducts) {
		CartOperation.selectedProducts = selectedProducts;
	}
	/* method to display product list which return hash map od product details
	 */
	public HashMap<Integer,Product> displayProductList(){
		return productDetailsInMemoryDao.getProductList();
	}
	/* method to check if product is present in product list 
	 */
	public boolean isProductInProductDetails(int productID){
		if(productDetailsInMemoryDao.getProductList().containsKey(productID)){
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
		
		//condition to check if requested product is present in productList or not.
		if(isProductInProductDetails(productID)){
			//calculating the total cost of each product.
			double totalProductCost=(productDetails.get(productID).getProductPrice())*productQuantity;
			OrderedProduct orderedProductDetails=new OrderedProduct(productID, productQuantity, totalProductCost);
			//condition to check if requested product is present in cart or not.
			if(isProductInCart(productDetails.get(productID))){
				int quantity=selectedProducts.get(productDetails.get(productID)).getProductQuantity();
				quantity+=productQuantity;
				selectedProducts.get(productDetails.get(productID)).setProductQuantity(quantity);
				
			}
			//new product addition to cart.
			else{	
			HashMap<Product,OrderedProduct> selectedProducts=userCart.getSelectedProducts();
			selectedProducts.put(productDetails.get(productID), orderedProductDetails);
			userCart.setSelectedProducts(selectedProducts);
			}
			controller.messageHandler(productID+" Product Added Successfully In Cart");
			
		}
		else{
			System.out.println("Product does not exist");
			
		}
	}
	
	
	// method to delete product from cart.
	public void deleteProductFromCart(int productID){
		//condition to check if cart is empty
		if(isCartNull()){
			controller.messageHandler("Cart is Empty");
		}
		else{
			//condition to check if requested product is present in productList or not.
			if(isProductInProductDetails(productID)){
				//condition to check if requested product is present in cart or not.
				if(isProductInCart(productDetails.get(productID))){	
//deleting the product from hashmap having selected products.
					selectedProducts.remove(productDetails.get(productID));
					controller.messageHandler(productID+" Removed Successfully");
				}
				else{
					controller.messageHandler("Product Not In Cart");
				}
			}
			else{
				controller.messageHandler("Product Does Not Exist");
			}
		}
	}
	
/ * method to display cart to user.This will return a hash map to the controller.	
 */
	public HashMap<Product, OrderedProduct>  displayCart(){
		
		//condition to check if cart is empty
		if(isCartNull()){
			controller.messageHandler("Cart is Empty");
		}
		return selectedProducts;
	}
	// method to update the value already present in cart. 
	public boolean updateProductCart(int productID,int productQuantity){
		//condition to check if cart is empty
		if(isCartNull()){
			controller.messageHandler("Cart is Empty");
			return false;
		}
		else{
			//condition to check if requested product is present in productList or not.
			if(isProductInProductDetails(productID)){
				
				//condition to check if requested product is present in cart or not.
				if(isProductInCart(productDetails.get(productID))){
			//updating the value of quantity of product.
					selectedProducts.get(productDetails.get(productID)).setProductQuantity(productQuantity);
					controller.messageHandler(productID+" Updated Successfully With Quantity "+productQuantity);
					return true;
				}
				else{
					controller.messageHandler("Product Not In Cart");
					return false;
				}
			}
			else{
				controller.messageHandler("Product Does Not Exist");
				return false;
			}
		}
	}
	
	/* method to generate the bill and return a list to the controller.
	 */
	public ArrayList<String> getBill(){
		
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
