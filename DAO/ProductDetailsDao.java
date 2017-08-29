package DAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.ProductDetails;
//Dao class to perform read and write operations on product Details file.
public class ProductDetailsDao {
	private HashMap<Integer,ProductDetails> productDetailsList=new HashMap<Integer,ProductDetails>();
	Scanner scan;
	File file;
	String filePath, fileName;
	static ProductDetailsDao productDetailsDaoInstance;
	private ProductDetailsDao() {
	}
	public static ProductDetailsDao getInstance(){
		if(productDetailsDaoInstance == null ){
			productDetailsDaoInstance = new ProductDetailsDao();
			return productDetailsDaoInstance;
		}
		else {
			return productDetailsDaoInstance;
		}
	}
	//getter method to get hashMap value containing key as //productID and ProductDetails class object.
	public HashMap<Integer, ProductDetails> getProductList() {
		return productDetailsList;
	}
	
	public void setFilePath(String path){
		filePath = path;
	}
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public  HashMap<Integer,ProductDetails> readProductDetails(){
		file = new File(filePath);
		int productID;
		Double productPrice;
		String productName;
		try{
			String productDetails;
			scan = new Scanner(file);
			while(scan.hasNextLine()){
				productDetails = scan.nextLine();
				System.out.println(productDetails);
				String[] splitedProductDetails=productDetails.split(",");
				productID=Integer.parseInt(splitedProductDetails[0]);
				productName=splitedProductDetails[1];
                //productPrice = Integer.parseInt(splitedProductDetails[2]);      
                productPrice = Double.parseDouble(splitedProductDetails[2]);
                ProductDetails productDetailsObject=new ProductDetails(productID,productName,productPrice);
				productDetailsList.put(productID,productDetailsObject);			//saving data in list
				System.out.println("^^^^^");
			}
			return productDetailsList;
		}
		catch( Exception e){
			e.printStackTrace();
			System.out.println("Data cannot be retrieved from file "+ fileName+ " at "+ filePath);
			return productDetailsList;
		}		
	}
	// method to write product details after any update to the file.
		public void writeToFile(HashMap<Integer,ProductDetails> productDetailsList){
			BufferedWriter writer=null;
			try{
				writer= new BufferedWriter(new FileWriter(new File(fileName)));
				for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
					String productDetails= mapSet.getValue().getProductCode()+"," + mapSet.getValue().getProductName() + "," + mapSet.getValue().getProductPrice();
					writer.write(productDetails);
					writer.newLine();
		        }
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
