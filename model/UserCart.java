package model;
//Class containing hash map having details of ordered product	
import java.util.HashMap;
public class UserCart {
	private HashMap<Product,OrderedProduct> selectedProducts=new HashMap<Product,OrderedProduct>();
	/*
	 * getters and setter for data members of the class. 
	 */
	public HashMap<Product, OrderedProduct> getSelectedProducts() {
		return selectedProducts;
	}
	public void setSelectedProducts(
			HashMap<Product, OrderedProduct> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}
}
