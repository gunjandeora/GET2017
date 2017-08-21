package view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import model.OrderedProduct;
import model.Product;
//Class to print  values to console .
public class Display {
	private static Display displayOutput;
	//Default Constructor.
	private Display(){
	}
	//getting instance of singleton class 
	public static Display getInstance(){
		if (displayOutput == null){
			displayOutput = new Display();
			return displayOutput;
		}
		else {
		return displayOutput;
		}
	}
	//method to display menu
	public void displayMenu(ArrayList<MenuItem> menu){
		System.out.println("choose from options: ");
		for(MenuItem menuItem:menu){
			System.out.println(menuItem.getMenuItemOption()+" "+menuItem.getMenuItemName());
		}
	}
	//method to display products
	public void displayProducts(HashMap<Integer,Product> productDetailsList){
		for(Map.Entry<Integer,Product> mapSet :productDetailsList.entrySet()){
			System.out.println( mapSet.getValue().getProductID()+"\t\t"+						   mapSet.getValue().getProductType()+"\t\t"+	mapSet.getValue().getProductName()+"\t\t" + mapSet.getValue().getProductPrice());
		}
	}
	//function to display UserCart.
	public void displayUserCart(HashMap<Product,OrderedProduct> selectedProducts){
		for(Map.Entry<Product,OrderedProduct> mapSet :selectedProducts.entrySet()){
			System.out.println(mapSet.getKey().getProductID()+"\t\t"
								+mapSet.getKey().getProductType()+"\t\t"
								+mapSet.getKey().getProductName()+"\t\t"
								+mapSet.getValue().getProductQuantity()+"\t\t"
								+mapSet.getValue().getTotalCost());
		}
	}
	//functio to generete bill.
	public void generateBill(ArrayList<String>bill){
		for(int i=0;i<bill.size();i++){
			System.out.println(bill.get(i));
		}
	}
	//function to display message.
	public void messageHandler(String message){
		System.out.println(message);
	}
}
