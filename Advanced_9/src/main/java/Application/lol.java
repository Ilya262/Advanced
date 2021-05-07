package Application;

import java.util.Date;

import Domain.Backet;
import Domain.Product;
import Service.BacketServiceIMPL;
import Service.ProductServiceImpl;
import ServiceInterface.BacketService;
import ServiceInterface.ProductService;

public class lol {

	
	public static void main(String[] args) {
	
		
		BacketService backetService =BacketServiceIMPL.getBacketServiceImpl();
		backetService.create(new Backet(1, 1, new Date()));
		
		
	}
	
	
	
	
	
}
