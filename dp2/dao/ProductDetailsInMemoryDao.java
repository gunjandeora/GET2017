package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import model.Product;
/*Class to read values from file and initialize the hash map with the values. */
public class ProductDetailsInMemoryDao {
private HashMap<Integer,Product> productDetailsList=new HashMap<Integer,Product>();
	//getter method to get hashMap value containing key as productID and ProductDetails class object.
	public HashMap<Integer, Product> getProductList() {
		return productDetailsList;
	}
/*method to read product details an split the details on the basis of ',' from the file and return hashMap 
*/
	public  HashMap<Integer,Product> readProductDetails(String fileName){
		//condition to check if file name is null.
		if(fileName==""){
			throw new InputMismatchException();
		}
		//reading of file.
		else{
			BufferedReader reader=null;
			try {
				reader = new BufferedReader(new FileReader(new File(fileName)));
				String productDetails;
				while((productDetails = reader.readLine()) != null) {
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
			finally{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}		
//method to write product details after any updation to the file.
	public void writeToFile(HashMap<Integer,Product> productDetailsList){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("ProductDetails.txt")));
			for(Map.Entry<Integer,Product> mapSet :productDetailsList.entrySet()){
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
