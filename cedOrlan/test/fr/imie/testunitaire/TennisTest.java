package fr.imie.testunitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.imie.test.Jeu;

public class TennisTest {

	@Test
	public void testInitialisationNouveauJeu() {
		new Jeu();
	}
	
	@Test
	public void testAfficherScoreDebutDePartie() {
		Jeu jeu = new Jeu();
		assertEquals("0-0", jeu.score());
	}
	@Test
	
	// j'ai rectifier aussi car scored prend un jeu en param ^^
	
	public void testJoueurMarquePoint(){
		Jeu jeu = new Jeu();
		Joueur joueur = new Joueur();
		joueur.scored();
		assertEquals("15-0", joueur.scored(jeu));

		
	}

}
