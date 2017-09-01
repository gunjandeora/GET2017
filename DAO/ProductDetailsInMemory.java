package DAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Product;
/*Class to read values from file and initialize the hash map with the values. */
public class ProductDetailsInMemory {
	String fileName;
	Scanner scan;
	File file;
	private HashMap<Integer,Product> productDetailsList=new HashMap<Integer,Product>();
	//getter method to get hashMap value containing key as productID and ProductDetails class object.
	public HashMap<Integer, Product> getProductList() {
		return productDetailsList;
	}
		/*method to read product details an split the details on the basis of ',' 
		 * from the file and return hashMap 
		 */
	public  HashMap<Integer,Product> readProductDetails() throws IOException{
		file = new File(ProductConstants.productDetailsFilePath);
		//condition to check if file name is null.
		if(fileName==""){
			throw new FileNotFoundException();
		}
		//reading of file.
		else{
			try {
				String productDetails;
				scan = new Scanner(file);
				while(scan.hasNext()){
					productDetails = scan.nextLine();
//					System.out.println(productDetails);
					String[] splitedProductDetails=productDetails.split(",");
					int productID=Integer.parseInt(splitedProductDetails[0]);
					String productType = splitedProductDetails[1];
					String productName = splitedProductDetails[2];
					double productsPrice = Double.parseDouble(splitedProductDetails[3]);
					Product productDetailsObject = new Product(productID,productType,productName,productsPrice);
					productDetailsList.put(productID,productDetailsObject);
				}
				return productDetailsList;
			}catch(IOException e) {
				e.printStackTrace();
				return productDetailsList;
			}
		}
	}
	//method to write product details after any updation to the file.
	public void writeToFile(HashMap<Integer,Product> productDetailsList){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("ProductDetails.txt")));
			for(Entry<Integer, Product> mapSet :productDetailsList.entrySet()){
				String productDetails= mapSet.getValue().getProductID()+","	+mapSet.getValue().getProductType()+"," + mapSet.getValue().getProductName() + "," + mapSet.getValue().getProductPrice();
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
