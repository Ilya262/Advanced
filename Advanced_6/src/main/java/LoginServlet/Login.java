package LoginServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.User;
import Service.UserServiceIMPL;
import ServiceInterface.UserService;
@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	UserService userservice = UserServiceIMPL.getUserServise();
	private static final long serialVersionUID = 1L;
	  public Login() {
	        super();
	    
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		User user = userservice.UsergetEmail(email);
		if (user!=null&user.getPassword().equals(password)) {
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		}			
		
else {
		request.getRequestDispatcher("login.jsp").forward(request, response);}

	
	}
	}
