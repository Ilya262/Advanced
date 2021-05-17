package ServiceInterface;

import java.util.Map;

import Domain.Product;
import Schared.AbsractCRUD;

public interface ProductService extends AbsractCRUD<Product>{
public Map<Integer,Product> readMap();
}