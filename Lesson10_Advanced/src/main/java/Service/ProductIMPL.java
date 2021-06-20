package Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import DAO.ProductDAO;
import Interface.ProductInterface;
import ServiceInterface.ProductService;
import ServiceInterface.UserService;
import domain.Product;

public class ProductIMPL implements ProductService {

	private static ProductService productService;
	private ProductInterface productdao;

	public static ProductService getProductService() {

		if (productService == null) {

			productService = new ProductIMPL();

		}
		return productService;

	}

	private ProductIMPL() {

		productdao = new ProductDAO();
	}

	@Override
	public Product create(Product product) {

		return productdao.create(product);
	}

	@Override
	public Product read_by_id(Integer id) {

		return productdao.read_by_id(id);
	}

	@Override
	public Product update(Product product) {

		return productdao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productdao.delete(id);

	}

	@Override
	public List<Product> read_all() {

		return productdao.read_all();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
		
		return  read_all().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}

}