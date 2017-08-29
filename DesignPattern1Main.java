import DAO.ProductDetailsDao;
import Facade.ProductFacade;


public class DesignPattern1Main {
	public static void main (String[] args){
		ProductFacade facade= ProductFacade.getInstance();
		facade.startProject();
	}
}
