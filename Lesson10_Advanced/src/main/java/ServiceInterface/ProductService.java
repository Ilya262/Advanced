package ServiceInterface;

import java.util.Map;

import Schared.AbsractCRUD;
import domain.Product;

public interface ProductService extends AbsractCRUD<Product>{

	Map<Integer, Product> readAllMap();

}