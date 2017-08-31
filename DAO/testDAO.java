package DAO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class testDAO {
	ProductDetailsInMemory pd = new ProductDetailsInMemory();
	String path = "D://Training 2017/DesignPattern1/src/ProductDetails.txt";
	@Test
	public void test() throws IOException {
		pd.readProductDetails();
	}

}
