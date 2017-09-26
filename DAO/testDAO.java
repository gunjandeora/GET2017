package DAO;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
public class ProductDetailsInMemoryTest {
	ProductDetailsInMemory pd = new ProductDetailsInMemory();
	String path = "D://Training 2017/DesignPattern1/src/ProductDetails.txt";
	@Test
	public void readProductDetails_NoInput_ListOfProduct() throws IOException {
		assertEquals(1001, pd.readProductDetails().get(0).getProductID());
	}
}
