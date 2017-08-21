package designpattern1.Model;
 // Description of product, its code type, price and name.
public class ProductDetails {
	private int productID;
	private String productType;
	private double productPrice;
	private String productName;
	//constructor to set class data members
	public ProductDetails(int productCode, String productType,String productName, double productPrice) {
		this.productID = productCode;
		this.productType = productType;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	//getter and setter for all data members
	public int getProductCode() {
		return productID;
	}	
	public void setProductCode(int productCode) {
		this.productID = productCode;
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
}
