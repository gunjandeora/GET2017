//Description of product, its code type and name.
package model;
public class Product {
	private int productID;
	private String productType;
	private String productName;
	private double productPrice;
	/*
	 * getters and setter for data members of the class 
	 */
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	//Parameterized constructor
	public Product(int productID, String productType,
		String productName, double productPrice) {
		this.productID = productID;
		this.productType = productType;
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
