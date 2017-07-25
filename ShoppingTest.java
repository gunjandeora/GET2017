package OOPs_Session3;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
public class ShoppingTest {
	String productListPath = "C://Users/User28/Downloads/ProductList.csv" ,
			productPromotionPath = "C://Users/User28/Downloads/ProductPromotion.csv"	,
			orderPromotionPath = "C://Users/User28/Downloads/OrderPromotion.csv" ;
	ProductPromotion product = new ProductPromotion();;
	ShoppingBill spbl;
	OrderPromotion order = new OrderPromotion(); ;
	FinalBilling finalBilling;
	//ProductPromotion product = new ProductPromotion();
	
	@Test
	public void testProductList() throws IOException {
		spbl= new ShoppingBill(productListPath, productPromotionPath, orderPromotionPath);
	}
	@Test
	public void testProductPromotion() throws IOException{
		//will test final product promotion.
		//will be compared to specific amount for production promotion.
		product.displayProductPromotions(productPromotionPath);			//will be removed later.
		//assertEquals(expected, product.calculateProductPromotion(););  
	}
	@Test
	public void testOrderPromotion() throws IOException{
		//will test final order promotion.
		//will be compared to specific amount for order promotion.
		order.displayOrderPromotions(orderPromotionPath);
		//assertEquals(expected, order.calculateOrderPromotion());  
	}
	
	@Test
	public void testFinalBilling(){
		//will compare final amount for user.
		//assertEquals(expected, finalBilling.calculateFinalBill());
	}

}
