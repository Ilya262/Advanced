package RegistrationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserServiceIMPL;
import ServiceInterface.UserService;
import domain.User;

/**
 * Servlet implementation class registration
 */
@WebServlet(urlPatterns = "/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private 	UserService userService=UserServiceIMPL.getUserServise();
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!name.isEmpty()&&!lastname.isEmpty()&&!email.isEmpty()&&! password.isEmpty()) {
			userService.create(new User(name, lastname, email, password));
		}
		request.getRequestDispatcher("login.jsp");
	}

}
