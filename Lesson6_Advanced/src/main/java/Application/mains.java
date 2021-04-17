package Application;



import Service.ProductServiceImpl;
import Service.UserServiceIMPL;
import ServiceInterface.ProductService;
import ServiceInterface.UserService;
import domain.Product;
import domain.User;

public class mains {

	public static void main(String[] args) {
		
		
		

ProductService productService= new ProductServiceImpl();
UserService userService= new UserServiceIMPL();




userService.create(new User("1","1","1","1","12fffff"));



}}
