package model;
//Class containing hash map having details of ordered product	
import java.util.HashMap;
public class UserCart {
	public HashMap<Integer,OrderedProduct> selectedProducts=new HashMap<Integer,OrderedProduct>();
	/*
	 * getters and setter for data members of the class. 
	 */
	public HashMap<Integer, OrderedProduct> getSelectedProducts() {
		return selectedProducts;
	}
	public void setSelectedProducts(
			HashMap<Integer, OrderedProduct> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}
}
