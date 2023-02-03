package de.zeroco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zerco.service.RegistrationService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		int genertedId =RegistrationService.delete(email);
		if (genertedId>0) {
			request.setAttribute("message", "Data deleted successfully");
			request.getRequestDispatcher("Delete.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Data not found");
			request.getRequestDispatcher("Delete.jsp").forward(request, response);
			
		}

	}
}
