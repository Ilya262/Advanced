package filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import Schared.FilterService;
import domain.Role;

@WebFilter("/product.jsp")
public class ProductFilter implements Filter {

	public FilterService filterService = FilterService.getFilterUser();
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		filterService.doFilterValidation(request, response, chain, Arrays.asList(Role.USER));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}