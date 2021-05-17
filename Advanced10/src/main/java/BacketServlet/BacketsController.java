package BacketServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domain.Backet;
import Domain.Product;
import Service.BacketServiceIMPL;
import Service.ProductServiceImpl;
import ServiceInterface.BacketService;
import ServiceInterface.ProductService;
import dto.BacketDTO;

/**
 * Servlet implementation class BacketsController
 */
@WebServlet("/BacketsController")
public class BacketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 BacketService backetService =BacketServiceIMPL.getBacketServiceImpl();
  ProductService productService= ProductServiceImpl.getProductServiceImpl();
   
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Backet> backet=backetService.read_all();
		    Map<Integer,Product>Idproduct=productService.readMap();
		    List<BacketDTO>listOfBucketsDto=map(backet,Idproduct);
		    
		    String json = new Gson().toJson(listOfBucketsDto);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		
		
		public List<BacketDTO> map(List<Backet> buckets, Map<Integer, Product> idToProduct){

			return	buckets.stream().map(bucket->{
				BacketDTO bucketDto = new BacketDTO();
				bucketDto.bucketId = bucket.getId();
				bucketDto.purshesDate = bucket.getPurches_date();
			   
				Product product = idToProduct.get(bucket.getProduct_id());
			    bucketDto.name = product.getName();
			    bucketDto.Description = product.getDescription();
			    bucketDto.Price = product.getPrice();
				
				return bucketDto;
			}).collect(Collectors.toList());
			
		} 
}
