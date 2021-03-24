package Service;

import java.util.List;

import DAO.ProductDaoImpl;
import DAOInterface.ProductDao;
import ServiceInterface.ProductService;
import domain.Product;

public class ProductServiceImpl implements ProductService {

	
	ProductDao productdao;
	
	public ProductServiceImpl() {
		
		productdao =  new ProductDaoImpl();
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
	

}