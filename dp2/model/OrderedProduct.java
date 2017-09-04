package model;
//Class to store details of selected product
public class OrderedProduct {
	private int productID;
	private int productQuantity;
	private double totalCost;
	/*
	 * getters and setter for data members of the class 
	 */
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	//Parameterized constructor
	public OrderedProduct(int productID, int productQuantity, 				double totalCost) {
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.totalCost = totalCost;
	}
}
