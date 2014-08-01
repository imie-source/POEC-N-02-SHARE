package fr.imie.testunitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.imie.tennis.Jeu;

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

}
