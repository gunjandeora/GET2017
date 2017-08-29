package DAO;
import static org.junit.Assert.*;
import org.junit.Test;
public class testDAO {
	ProductDetailsDao pd = ProductDetailsDao.getInstance();
	String path = "D://Training 2017/DesignPattern1/src/ProductDetails.txt";
	@Test
	public void test() {
		pd.setFilePath(path);
		pd.readProductDetails();
	}
}
