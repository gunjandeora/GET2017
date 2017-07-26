package OOPs_Session3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	//ArrayList<Integer> orderCode = new ArrayList<Integer>();
}
//display products from file
class ProductsList implements DisplayData  {
	Double productPrize;
	String code, prize;
	ArrayList<String> productList = new ArrayList<String>();			//saves string for final printing of bill.
	Map<String,Double> productListMap=new HashMap<String,Double>();  		//map is for storing integer values of id and prize
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
			//saving data 
			productList.add(temp);
			// converting in integer values.
			code = temp.split(",")[0];
			prize = temp.split(",")[2];	
			productPrize = Double.parseDouble(prize);			//saving in map.
			productListMap.put(code, productPrize);
		}				//end of while loop.
	}				//end of method readAndDisplay
}				//end of ProductList class
class ProductPromotion implements DisplayData {
	ArrayList<String> listOfProductPromotions = new ArrayList<String>();			//each row is stored as it is.
	String[] tempStringArray;
	ArrayList<Promotion> productPromotions = new ArrayList<Promotion>();
	Promotion p = new Promotion();
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
			p.name = temp.split(",")[0];						//to save product promotions as instance of class Promotions 
			p.value = Integer.parseInt(temp.split(",")[1]); 
			temp = temp.split(",")[2];
			tempStringArray = new String[temp.length()];
			for(int k=0;k<temp.length();k++){
				p.items.add(Integer.parseInt(tempStringArray[k]));				// adding code
			}
			productPromotions.add(p);
		}				//end of while loop.	
	}
	
	float calculateProductDiscount(String name, float amount){
		float discount=0;
		if(name.equalsIgnoreCase("ProductFixedPercentPromotion")){
			discount = (float) (discount + (0.15)*amount);
		}	
		return discount;
	}
}
class OrderPromotion implements DisplayData{
	ArrayList<String> listOfOrderPromotions = new ArrayList<String>();			//each row is stored as it is.
	ArrayList<Promotion> orderPromotions = new ArrayList<Promotion>();
	Promotion p = new Promotion();
	String[] tempStringArray;
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
			//to save order promotions as instance of class Promotions 
			p.name = temp.split(",")[0];
			p.value = Integer.parseInt(temp.split(",")[1]);
			temp = temp.split(",")[2];
			tempStringArray = new String[temp.length()];
			for(int k=0;k<temp.length();k++){
				p.items.add(Integer.parseInt(tempStringArray[k]));
			}			
			}	//end of while loop.	
	}	
	
	float calculateOrderDiscount(float amount){
		float orderDiscount=0;
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
		//System.out.println("save promotions");
		file = new File(paths[2]);
		op.readAndDisplayFile(file);
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
			//customerOrder.orderCode.add(code);
			customerOrder.customerOrderMap.put(code, quantity);
			
		}		// end of input loop.
		finalBilling();
	}				//end of Shopping constructor.
	
	void finalBilling(){
		String temp;
		int key;
		System.out.println("PURCHASED PRODUCTS");
		for(int input=0;input<nummberOfProducts;input++){
			temp = (customerOrder.customerOrderMap).getKey();
			System.out.println("Product:"  + customerOrder.customerOrderMap).getKey() + "-" + getProductName(temp));
			System.out.println("Cost :" + pl.productListMap.get(customerOrder.customerOrderMap).getKey()) +  "(" + customerOrder.customerOrderMap.get(customerOrder.customerOrderMap).getKey())+ " x " + pl.productListMap.get(customerOrder.customerOrderMap).getKey()));
			subTotal = (float) (subTotal + ((customerOrder.customerOrderMap.get(customerOrder.customerOrderMap).getKey()))*(pl.productListMap.get(customerOrder.customerOrderMap).getKey())));
		}				//end of for loop.
		
		System.out.println("APPLIED PROMOTIONS/DISCOUNTS :");
		//applying product promotions
		productDiscount = getProductPromotions();
		orderDiscount = op.calculateOrderDiscount(subTotal - productDiscount);
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
			code = pl.productList.get(k).split(",")[0];
			if(code.equalsIgnoreCase(temp)){
				return pl.productList.get(k).split(",")[1];
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
		for (int pro=0;pro<pp.productPromotions.size();pro++){
			System.out.print("Promotion : " + pp.productPromotions.get(pro).value+ " off on " );
			// listing products for that promotion.
			for(int pitem=0;pitem<pp.productPromotions.get(pro).items.size();pitem++){
				tempCode = pp.productPromotions.get(pro).items.get(pitem);
				tempString = tempCode + "";
				System.out.print(getProductName(tempString) + "[Code:" + tempCode + "],");
				// if list contains any order from customer.
				if(customerOrder.customerOrderMap.containsKey(tempCode)){
					// for percentage discount
					if(pp.productPromotions.get(pro).name.equalsIgnoreCase("ProductFixedPercentPromotion")){
						float prize;
						//prize = prize of product* quantity
						prize = (float) (pl.productListMap.get(tempCode) * customerOrder.customerOrderMap.get(tempCode));
						tempAmount = tempAmount + pp.calculateProductDiscount("ProductFixedPercentPromotion",prize);
					}
					else {
						//tamount = tamount + value*quantity
						tempAmount = pp.calculateProductDiscount("", pp.productPromotions.get(pro).value * customerOrder.customerOrderMap.get(tempCode));
						tempAmount = tempAmount +pp.productPromotions.get(pro).value * customerOrder.customerOrderMap.get(tempCode);
					}
				}			//end of if-else condition.
			}			//end of for loop for each promotion product list.
			System.out.println("Discount : " + tempAmount);
			System.out.println();
			finalDiscountAmount = finalDiscountAmount + tempAmount;
		}		//end of outer for loop.
		return  finalDiscountAmount;
	}
}
