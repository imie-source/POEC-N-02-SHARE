package org.imie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.imie.model.Personne;

/**
 * Servlet implementation class NewPersonneControleur
 */
@WebServlet("/NewPersonneControleur")
public class NewPersonneControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPersonneControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/newPersonne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissParam = request.getParameter("dateNaiss");
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dateNaiss;
		try {
			dateNaiss = spf.parse(dateNaissParam);
		} catch (ParseException e) {
			throw new RuntimeException("date mal formatée");
		}
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setDateNaiss(dateNaiss);
		HttpSession session = request.getSession();
		List<Personne> personnes = (List<Personne>) session.getAttribute("personneList");
		Integer maxId = 0;
		//recherche de l'ID max existant
		for (Personne personneSearchMaxId : personnes) {
			if (personneSearchMaxId.getId()>maxId){
				maxId= personneSearchMaxId.getId();
			}
		}
		//incrémentation de l'ID pour new record
		maxId++;
		personne.setId(maxId);
		
		personnes.add(personne);
		session.setAttribute("personneList", personnes);
		response.sendRedirect("./PersonneControleur");
		
	}

}
