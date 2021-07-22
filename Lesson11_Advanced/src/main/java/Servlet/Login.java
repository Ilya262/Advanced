package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Service.UserIMPL;
import ServiceInterface.UserService;
import domain.User;
import dto.UserLogin;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userservice = UserIMPL.getUserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userservice.getUserEmail(email);
		HttpSession session = request.getSession(true);

	

		if (user != null && user.getPassword().equals(password)) {
			session.setAttribute("userid", user.getId());
			session.setAttribute("role", user.getRole().toString());
			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = ("cabinet.jsp");
			userLogin.userEmail = user.getEmail();
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}
