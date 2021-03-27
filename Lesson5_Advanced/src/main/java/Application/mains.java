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


productService.create(new Product("lmpa delux", "Delux company", 40.6));

userService.create(new User("Ілля","Івасик","ilchik262@gmail.com","User"));



}}
