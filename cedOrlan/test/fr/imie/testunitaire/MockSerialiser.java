package fr.imie.testunitaire;

import fr.imie.test.ISerialiser;
import fr.imie.test.Jeu;
import fr.imie.test.Joueur;

public class MockSerialiser implements ISerialiser{

	@Override
	public void persist(Jeu jeux, String chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jeu read(String chemin) {
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		return jeu;
	}

}
