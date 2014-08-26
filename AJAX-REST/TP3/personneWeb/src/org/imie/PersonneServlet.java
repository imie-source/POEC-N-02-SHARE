package org.imie;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ime.PersonneServiceLocal;

/**
 * Servlet implementation class PersonneServlet
 */
@WebServlet("/PersonneServlet")
public class PersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonneServiceLocal personneService;

	/**
	 * Default constructor.
	 */
	public PersonneServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("personnes",
				personneService.findAllPersonne());
		request.getRequestDispatcher("WEB-INF/personne.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
