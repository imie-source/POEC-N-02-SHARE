package org.ime;

import java.util.List;

import javax.ejb.Local;

import personneEntity.Personne;

@Local
public interface PersonneServiceLocal {
	
	
	public List<Personne> findAllPersonne();

	Personne insertPersonne(Personne personne);

	public void deletePersonne(Integer id);

}
