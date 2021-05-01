package LoginServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Domain.User;
import Service.UserServiceIMPL;
import ServiceInterface.UserService;
import dto.UserLogin;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	UserService userservice = UserServiceIMPL.getUserServise();
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userservice.UsergetEmail(email);
		HttpSession session = request.getSession(true);

		session.setAttribute("userId", user.getId());

		if (user != null && user.getPassword().equals(password)) {
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
