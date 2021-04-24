package Application;

import Domain.Product;
import Service.ProductServiceImpl;
import ServiceInterface.ProductService;

public class lol {

	
	public static void main(String[] args) {
		ProductService productService =ProductServiceImpl.getProductServiceImpl();
		productService.create(new Product("w", "w", 22.2));
		
		
		
	}
	
	
	
	
	
}
