package BacketServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain.Backet;
import Service.BacketServiceIMPL;
import ServiceInterface.BacketService;

@WebServlet(urlPatterns = "/BacketController")
public class BacketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public BacketService backetService= BacketServiceIMPL.getBacketServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
	
		Backet bucket = new Backet(userId,Integer.parseInt(productId) , new Date());
		backetService.create(bucket);
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
