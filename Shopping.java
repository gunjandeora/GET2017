package OOPs_Session3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface DisplayData{
	void readAndDisplayFile(File file) throws IOException;
}
// abstract class for both type of promotions
class Promotion {
	String name = new String();
	int value;
	ArrayList<Integer> items = new ArrayList<Integer>();
}
//to save orders
class CustomerOrders{
	Map<Integer,Integer> customerOrderMap=new HashMap<Integer,Integer>();
	ArrayList<Integer> orderCode = new ArrayList<Integer>();
}


//display products from file
class ProductsList implements DisplayData  {
	int productCode =0, productPrize=0;
	String code, prize;
	ArrayList<String> productList = new ArrayList<String>();			//saves string for final printing of bill.
	Map<Integer,Integer> productListMap=new HashMap<Integer,Integer>();  		//map is for storing integer values of id and prize
	@Override
	public void readAndDisplayFile(File file) throws IOException {
		Scanner sc = new Scanner(file);
		String temp;
		// displaying data.
		System.out.println("in productlist");
		
		temp = sc.nextLine();
		//System.out.println(temp);				//displays header.
		while(sc.hasNext()){
			temp = sc.nextLine();
			//System.out.println(temp);
			//saving data 
			productList.add(temp);
			// converting in integer values.
			code = temp.split(",")[0];
			prize = temp.split(",")[2];
			//System.out.println(code + "##############");
			productCode = Integer.parseInt(code);					//saving in map.
			productPrize = Integer.parseInt(prize);
			//System.out.println((productCode-5) + "##############");
			productListMap.put(productCode, productPrize);
		}				//end of while loop.
		
		//System.out.println(productListMap.get(1001) + "!!!!!!!!!!!!!!!!!");
	}				//end of method readAndDisplay
	
	
	
	
	
}				//end of ProductList class
class ProductPromotion implements DisplayData {
	ArrayList<String> listOfProductPromotions = new ArrayList<String>();			//each row is stored as it is.
	int numberOfProductPromotions=0;	
	Promotion[] productPromotions;
	@Override
	public void readAndDisplayFile(File file) throws IOException {
		Scanner sc = new Scanner(file);
		String temp;
		// displaying data.
		System.out.println("in product promotion");
		temp = sc.nextLine();				//displays header.
		while(sc.hasNext()){
			temp = sc.nextLine();
			System.out.println(temp);
			listOfProductPromotions.add(temp);				//saving retrieved data.
			numberOfProductPromotions ++;			//counting number of product promotions.
			//saving data 
		}				//end of while loop.	
		System.out.println(numberOfProductPromotions);
	}
	// set NumberOfPromotions.
	void setNumberOfPromotions(int num){
		numberOfProductPromotions = num;
	}
	//to save product promotions as instance of class Promotions 
	void saveProductPromotions(){
		productPromotions = new Promotion[numberOfProductPromotions];
		String tempString="";
		String[] tempStringArray;
		int tempInt =0;
		for(int i=0;i<numberOfProductPromotions;i++){
			tempString = listOfProductPromotions.get(i);
//			System.out.println(tempString);
			productPromotions[i] = new Promotion(); 
			productPromotions[i].name = tempString.split(",")[0];
			productPromotions[i].value = Integer.parseInt(tempString.split(",")[1]); 
			tempString = tempString.split(",")[2];
			tempStringArray = new String[tempString.length()];
			for(int k=0;k<tempString.length();k++){
				productPromotions[i].items.add(Integer.parseInt(tempStringArray[k]));
			}
		}
	}
}
class OrderPromotion implements DisplayData{
	ArrayList<String> listOfOrderPromotions = new ArrayList<String>();			//each row is stored as it is.
	int numberOfOrderPromotions=0;	
	Promotion[] orderPromotions;
	@Override
	public void readAndDisplayFile(File file) throws IOException {
		Scanner sc = new Scanner(file);
		String temp;
		// displaying data.
		System.out.println("in order promotion");
		temp = sc.nextLine();				//displays header.
		while(sc.hasNext()){
			temp = sc.nextLine();
			System.out.println(temp);
			listOfOrderPromotions.add(temp);				//saving retrieved data.
			numberOfOrderPromotions ++;			//counting number of product promotions.
			//saving data 	
			}	//end of while loop.	
	}
	// set number of order promotions for saving promotions as instance of Promotion class
	void setNumberOfPromotions(int num){
		numberOfOrderPromotions = num;
	}
	//to save product promotions as instance of class Promotions 
	void saveOrderPromotions(){
		orderPromotions = new Promotion[numberOfOrderPromotions];
		String tempString="";
		String[] tempStringArray;
		int tempInt =0;
		for(int i=0;i<numberOfOrderPromotions;i++){
			tempString = listOfOrderPromotions.get(i);
//			System.out.println(tempString);
			orderPromotions[i] = new Promotion(); 
			orderPromotions[i].name = tempString.split(",")[0];
			orderPromotions[i].value = Integer.parseInt(tempString.split(",")[1]); 
			tempString = tempString.split(",")[2];
			tempStringArray = new String[tempString.length()];
			for(int k=0;k<tempString.length();k++){
				orderPromotions[i].items.add(Integer.parseInt(tempStringArray[k]));
			}
		}
	}			//end of saveOrderPromotions method
	}		//end of class OrderPromotion.
//main class 
public class Shopping {
	ProductsList pl = new ProductsList() ;
	ProductPromotion pp = new ProductPromotion();
	OrderPromotion op = new OrderPromotion();
	String path;
	File file;
	int nummberOfProducts , code , quantity;
	float productDiscount , orderDiscount , subTotal;
	CustomerOrders customerOrder;
	Scanner sc = new Scanner(System.in);
	Promotion promotionObject;
	// String array - productionListPath, productPromotionPath,orderPromotionPath
	public Shopping(String[] paths) throws IOException{
		//calling each readAndDisplay methods
		file = new File(paths[0]);
		pl.readAndDisplayFile(file);
		file = new File(paths[1]);
		pp.readAndDisplayFile(file);
		pp.setNumberOfPromotions(pp.numberOfProductPromotions);
		System.out.println(pp.numberOfProductPromotions + "rrrrrrrrr");
		//System.out.println("save promotions");
		pp.saveProductPromotions();
		file = new File(paths[2]);
		op.readAndDisplayFile(file);
		op.setNumberOfPromotions(op.numberOfOrderPromotions);
		op.saveOrderPromotions();
		//taking input from user.
		System.out.println("Please enter number of product you wish to buy.");
		while(true){
		try{
			nummberOfProducts = sc.nextInt();
			break;
		}
		catch(Exception e){
			System.out.println("Please enter an Integer value");
		}
	}				//end of while loop
		System.out.println("Please enter number of product code and quantity you wish to buy.");
		for(int input=0;input<nummberOfProducts;input++){
			code = sc.nextInt();
			// checking if item is in the product list or not.
			while(true){
				if(pl.productListMap.containsKey(code)){
					break;
				}
				else{
					System.out.println("ITEM NOT FOUND!!!");
					continue;
				}
			}		//end of while loop.
			// if entered quantity is >0
			while(true){
				System.out.println("Quantity- ");
				quantity = sc.nextInt();
				if(quantity>=0){
					break;
				}
				else{
					System.out.println("PLEASE ENTER CORRECT QUANTITY");
					continue;
				}
			}		//end of while loop.
			//saving the order from user.
			customerOrder.orderCode.add(code);
			customerOrder.customerOrderMap.put(code, quantity);
			
		}		// end of input loop.
		finalBilling();
	}				//end of Shopping constructor.
	
	void finalBilling(){
		String temp;
		System.out.println("PURCHASED PRODUCTS");
		for(int input=0;input<nummberOfProducts;input++){
			temp = customerOrder.orderCode.get(input).toString();
			System.out.println("Product:"  + customerOrder.orderCode.get(input) + "-" + getProductName(temp));
			System.out.println("Cost :" + pl.productListMap.get(customerOrder.orderCode.get(input)) +  "(" + customerOrder.customerOrderMap.get(customerOrder.orderCode.get(input))+ " x " + pl.productListMap.get(customerOrder.orderCode.get(input)));
			subTotal = subTotal + ((customerOrder.customerOrderMap.get(customerOrder.orderCode.get(input)))*(pl.productListMap.get(customerOrder.orderCode.get(input))));
		
		}				//end of for loop.
		
		System.out.println("APPLIED PROMOTIONS/DISCOUNTS :");
		//applying product promotions
		productDiscount = getProductPromotions();
		orderDiscount = getOrderPromotion(subTotal - productDiscount);
		//printing values.
		System.out.println("SubTotal: " + subTotal);
		System.out.println("Product Level Discounts :" + productDiscount);
		System.out.println("Order Level Discounts :" + orderDiscount);
		System.out.println("Total Discounts :" + orderDiscount + productDiscount);
		System.out.println("Total: " + (subTotal - (orderDiscount+productDiscount)));
	}
	
	String getProductName(String temp){
		String productList="";
		String code ="";
		for(int k=0;k<nummberOfProducts;k++){
			code = pl.productList.get(k).toString().split(",")[0];
			if(code.equalsIgnoreCase(temp)){
				return pl.productList.get(k).toString().split(",")[1];
			}
			else {
				continue;
			}
		}
		return code;
	}
	// applying product promotions on orders.
	float getProductPromotions(){
		float tempAmount=0 , finalDiscountAmount=0;
		int tempCode;
		String tempString;
		for (int pro=0;pro<pp.numberOfProductPromotions;pro++){
			
			System.out.print("Promotion : " + pp.productPromotions[pro].value + " off on " );
			// listing products for that promotion.
			for(int pitem=0;pitem<pp.productPromotions[pro].items.size();pitem++){
				tempCode = pp.productPromotions[pro].items.get(pitem);
				tempString = tempCode + "";
				System.out.print(getProductName(tempString) + "[Code:" + tempCode + "],");
				// if list contains any order from customer.
				if(customerOrder.customerOrderMap.containsKey(tempCode)){
					// for percentage discount
					if(pp.productPromotions[pro].name.equalsIgnoreCase("ProductFixedPercentPromotion")){
						float prize;
						//prize = prize of product* quantity
						prize = pl.productListMap.get(tempCode) * customerOrder.customerOrderMap.get(tempCode);
						tempAmount = (float) (tempAmount + (0.15)*prize);
					}
					else {
						//tamount = tamount + value*quantity
						tempAmount = tempAmount + pp.productPromotions[pro].value * customerOrder.customerOrderMap.get(tempCode);
					}
				}			//end of if-else condition.
			}			//end of for loop for each promotion product list.
			System.out.println("Discount : " + tempAmount);
			System.out.println();
			
			finalDiscountAmount = finalDiscountAmount + tempAmount;
		}		//end of outer for loop.
		return  finalDiscountAmount;
	}
	float getOrderPromotion(float amount){
		if(amount>=1000 && amount<1500){
			orderDiscount = 100;
			return orderDiscount;
		}
		if (amount>=1500 && amount<2000){
			orderDiscount = (float) ((0.1)*amount);
			return orderDiscount;
		}
		if (amount>=2000) {
			orderDiscount = 200;
			return orderDiscount;
		}
		return 0;
	}
	
}
