package Schared;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.Role;

public class FilterService {

	public static FilterService filterService;

	public static FilterService getFilterUser() {

		if (filterService == null) {
			filterService = new FilterService();

		}
		return filterService;

	}

	public void doFilterValidation(ServletRequest request,ServletResponse response,FilterChain chain,
		
		List<Role> userRole) 
		
		throws IOException,SecurityException, ServletException{
			
		

			try {
				HttpSession session = ((HttpServletRequest) request).getSession();
				Role role = Role.valueOf((String) session.getAttribute("role"));

				if (role != null && userRole.contains(role)) {
					chain.doFilter(request, response);
				} else {
					((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
			}

		}
}
