package RegistrationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Role;
import Domain.User;
import Service.UserServiceIMPL;
import ServiceInterface.UserService;

@WebServlet (urlPatterns = "/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserService userService =UserServiceIMPL.getUserServise();
 
    public Registration() {
        super();
    
    }

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("name");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		if(!name.isEmpty()&&!lastname.isEmpty()&&!email.isEmpty()&&!password.isEmpty()) {
			
			userService.create(new User(name, lastname,  email, Role.USER.toString(), password));
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
