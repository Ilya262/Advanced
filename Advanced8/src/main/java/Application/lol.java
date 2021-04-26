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
		ProductService productService =ProductServiceImpl.getProductServiceImpl();
		productService.create(new Product("w", "w", 22.2));
		
		BacketService backetService =BacketServiceIMPL.getBacketServiceImpl();
		backetService.create(new Backet(1, 1, new Date()));
		
	}
	
	
	
	
	
}
