package view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.OrderedProduct;
import model.Product;
public class Display {
	private static Display displayObject;
	//private constructor
	private Display() {	}
	// get instance of Singleton class
	public static Display getInstance(){
		if(displayObject== null){
			displayObject = new Display();
			return displayObject;
		}
		else{
			return displayObject;	
		}
	}
	//method to display products
	public void displayProducts(HashMap<Integer,Product> productDetailsList){
		for(Map.Entry<Integer,Product> mapSet :productDetailsList.entrySet()){
			System.out.println( mapSet.getValue().getProductID()+"\t\t"+ mapSet.getValue().getProductType()+"\t\t"+	mapSet.getValue().getProductName()+"\t\t" + mapSet.getValue().getProductPrice());
		}
	}
	//function to display UserCart.
	public void displayUserCart(HashMap<Integer,OrderedProduct> selectedProducts){
		for(Map.Entry<Integer,OrderedProduct> mapSet :selectedProducts.entrySet()){
			System.out.println(mapSet.getKey()+"\t\t"
								+mapSet.getValue().getProductQuantity()+"\t\t"
								+mapSet.getValue().getTotalCost());
		}
	}
	//method to generete bill.
	public void generateBill(ArrayList<String>bill){
		for(int i=0;i<bill.size();i++){
			System.out.println(bill.get(i));
		}
	}
	//method to display menu
	public void displayMainMenu(){
		ArrayList<String> mainMenu = new ArrayList<String>();
		mainMenu.add("display product list");
		mainMenu.add("View product list");
		mainMenu.add("Add product to cart");
		mainMenu.add("Delete product from cart");
		mainMenu.add("Update product in cart");
		mainMenu.add( "View your Cart");
		mainMenu.add("Generate Bill");
		mainMenu.add("Exit");
		//displaying mainMenu
		for(int i=0; i<mainMenu.size();i++){
			System.out.println(i+ " " + mainMenu.get(i));
		}
	}
}
