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
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		List<Map<String, Object>> listOfDetails = RegistrationService.getData(email);
		if (listOfDetails.size()!=0) {
			request.setAttribute("message", "Records found");
			request.setAttribute("details", listOfDetails);
			request.getRequestDispatcher("GetData.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "No records found");
			request.getRequestDispatcher("GetData.jsp").forward(request, response);

		}
		
	}
}
