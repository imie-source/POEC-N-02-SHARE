package org.ime;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import personneEntity.Personne;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class PersonneService implements PersonneServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PersonneService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Personne> findAllPersonne() {
		// List<Personne> retour = entityManager.createQuery(
		// "select p from Personne p").getResultList();
		List<Personne> retour=entityManager.createNamedQuery("Personne.findAll").getResultList();
		return retour;
	}
	
	@Override
	public Personne insertPersonne(Personne personne) {
		// List<Personne> retour = entityManager.createQuery(
		// "select p from Personne p").getResultList();
		//List<Personne> retour=entityManager.createNamedQuery("Personne.findAll").getResultList();
		entityManager.persist(personne);
		return personne;
	}

	@Override
	public void deletePersonne(Integer id) {
		Personne personne =entityManager.find(Personne.class, id);
		entityManager.remove(personne);
		
	}

	@Override
	public Personne update(Personne personneToUpdate) {
		Personne personne =entityManager.find(Personne.class, personneToUpdate.getId());
		personne.setPrenom(personneToUpdate.getPrenom());
		personne.setNom(personneToUpdate.getNom());
		personne.setDatenaiss(personneToUpdate.getDatenaiss());
		return personne;
	}

}
