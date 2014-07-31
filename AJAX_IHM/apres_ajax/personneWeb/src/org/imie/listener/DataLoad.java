package org.imie.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.imie.model.Personne;

/**
 * Application Lifecycle Listener implementation class DataLoad
 *
 */
@WebListener
public class DataLoad implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public DataLoad() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        Personne personne1 = new Personne();
        personne1.setId(1);
        personne1.setNom("test");
        personne1.setPrenom("test");
        personne1.setDateNaiss(new Date());
        
        Personne personne2 = new Personne();
        personne2.setId(2);
        personne2.setNom("test");
        personne2.setPrenom("test");
        personne2.setDateNaiss(new Date());
        
        List<Personne> personnes = new ArrayList<Personne>();
        
        personnes.add(personne1);
        personnes.add(personne2);
        
        arg0.getSession().setAttribute("personneList", personnes);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
