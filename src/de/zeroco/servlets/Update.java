package de.zeroco.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zerco.dao.RegistrationDao;
import de.zerco.dao.Utility;
import de.zerco.service.RegistrationService;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Map<String, Object> detailsMap = new LinkedHashMap<String, Object>();
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			Object value = request.getParameter(key);
			if (Utility.hasData(value))
				detailsMap.put(key, value);
		}
		String email = request.getParameter("verifyemail");
	if (RegistrationDao.checkPhoneEmail(null, email)) {
		RegistrationService.getUpdatedId(detailsMap);
			request.setAttribute("message", "Data updated successfully");
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "user id not exist");
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
	}
	

}
