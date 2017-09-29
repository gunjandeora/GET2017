package Model;
// Description of product, its code type, price and name.
public class ProductDetails {
	private int productID;
	private Double productPrice;
	private String productName;
	//constructor to set class data members
	public ProductDetails(int productCode,String productName, Double productPrice) {
		this.productID = productCode;
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
	public String getProductName() {
		return productName;
	}	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}	
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
}
