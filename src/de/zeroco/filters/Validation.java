package de.zeroco.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import de.zerco.service.RegistrationService;

/**
 * Servlet Filter implementation class Validation
 */
@WebFilter("/Validation")
public class Validation implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		if (RegistrationService.checkUser(user, pwd)) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("message", " login failed ! check your user id and password");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
