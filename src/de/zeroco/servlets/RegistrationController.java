package de.zeroco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zerco.dao.RegistrationDao;
import de.zerco.service.RegistrationService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String phno = request.getParameter("phone");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String pwd = request.getParameter("pwd");
		if (RegistrationDao.checkPhoneEmail(phno, email)) {
			request.setAttribute("message", "Sorry phone number or email already exist !");
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		} else {
			int id = RegistrationService.getInsertedId(name, email, phno, dob, pwd);
			request.setAttribute("message", id + " User created successfully");
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
	}
}
