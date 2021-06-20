package ServletProduct;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domain.Product;
import Service.ProductServiceImpl;
import ServiceInterface.ProductService;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet("/ProductsController")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ProductService productService =ProductServiceImpl.getProductServiceImpl();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Product> products = productService.read_all();
			String json = new Gson().toJson(products);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}

	}

