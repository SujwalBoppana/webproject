package de.zeroco.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zerco.service.RegistrationService;

/**
 * Servlet implementation class GetAll
 */
@WebServlet("/GetAll")
public class GetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<Map<String, Object>> listOfDetails = RegistrationService.getAll();
		request.setAttribute("message", "Records");
		request.setAttribute("details", listOfDetails);
		request.getRequestDispatcher("GetAll.jsp").forward(request, response);
	}
}
