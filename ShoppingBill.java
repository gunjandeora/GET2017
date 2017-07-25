package OOPs_Session3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//main class 
public class ShoppingBill {
	ProductsList productList ;
	OrderPromotion orderPromotion;
	FinalBilling finalBilling;
	public ShoppingBill(String productListPath, String productPromotionPath, String orderPromotionPath) throws IOException {
		productList = new ProductsList(productListPath);
		finalBilling = new FinalBilling(orderPromotionPath, productPromotionPath);
	}
	
}
//display products from file
class ProductsList{
	File file;
	public ProductsList(String productListPath) throws FileNotFoundException {
		file = new File(productListPath);
		displayProducts();
	}
	//retrieving product list from file and displaying it for user.
	private void displayProducts() throws FileNotFoundException{
		String temp;
		try {
			Scanner sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Please enter correct path for ProductList.csv file");
			e.printStackTrace();
		}
		Scanner sc = new Scanner(file);
		while(sc.hasNext()){
			temp = sc.nextLine();
			System.out.println(temp);
		}
	}
}

//calculating product promotions
class ProductPromotion{
	File productPromotionFile;
	
	//first display product promotions to user.
	void displayProductPromotions(String productPromotionPath) throws IOException{
		String temp;
		System.out.println("IN PROductPRomotion");
		productPromotionFile = new File(productPromotionPath);
		Scanner sc = new Scanner(productPromotionFile);
		while(sc.hasNext()){
			temp = sc.nextLine();
			System.out.println(temp);
			//retrieve data from file and save it.
		}
	}
	//calculate total product promotions from order object.
	void ProductPromotions(){
		
	}
	
}
//after calculating product promotions , calculating order promotions
class OrderPromotion extends ProductPromotion{
	File orderPromotionFile;
	//first display order promotions to user.
	void displayOrderPromotions(String orderPromotionPath) throws IOException{
		String temp;
		System.out.println("IN orderPRomotion");
		orderPromotionFile = new File(orderPromotionPath);
		Scanner sc = new Scanner(orderPromotionFile);
		while(sc.hasNext()){
			temp = sc.nextLine();
			System.out.println(temp);
			//retrieve data from file and save it.
		}
	}
}
//generating final bill. 
class FinalBilling extends OrderPromotion{
	String done = "notDone";
	int productCode =0;
	int productQuantity =0;
	int numberOfProducts;
	Scanner sc = new Scanner(System.in);
	Orders order;
	public FinalBilling(String orderPromotionPath , String productPromotionPath) throws IOException {
		//super(orderPromotionPath, productPromotionPath);
		System.out.println("IN finalBilling");
		ProductPromotion product = new ProductPromotion();
		product.displayProductPromotions(productPromotionPath);
		OrderPromotion orderPromotion = new OrderPromotion();
		orderPromotion.displayOrderPromotions(orderPromotionPath);
		//retrieving orders from user
		System.out.println("Please enter 'done' when you want to end shopping");
		while(done.equalsIgnoreCase("notDone")){
			System.out.println("Please enter your product code");
			productCode = sc.nextInt();
			order.productCode.add(productCode);
			System.out.println("Please enter quantity of " + productCode);
			productQuantity = sc.nextInt();
			order.productCode.add(productQuantity);
		}
	}
}
// to save orders
class Orders{
	ArrayList<Integer> productCode = new ArrayList<Integer>();
	ArrayList<Integer> productQuantity = new ArrayList<Integer>();
}

