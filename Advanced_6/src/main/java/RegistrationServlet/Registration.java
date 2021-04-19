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
		
		
		String name=request.getParameter("Name");
		String lastname=request.getParameter("LastName");
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		
		
		if(!name.isEmpty()&&!lastname.isEmpty()&&!email.isEmpty()&&!password.isEmpty()) {
			
			userService.create(new User(name, lastname,  email, Role.USER.toString(), password));
		}
		
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);;
	}

}
