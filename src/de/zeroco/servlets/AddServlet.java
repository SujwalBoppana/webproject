package de.zeroco.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int one = Integer.parseInt(req.getParameter("numone"));
		int two = Integer.parseInt(req.getParameter("numtwo"));
		int sum = one + two;
		PrintWriter writer = res.getWriter();
		writer.println("sum of two numbers is " + sum);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
