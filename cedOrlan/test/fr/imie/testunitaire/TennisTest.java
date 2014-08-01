package fr.imie.testunitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.imie.test.Jeu;
import fr.imie.test.Joueur;

public class TennisTest {

	@Test
	public void testInitialisationNouveauJeu() {
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		new Jeu(joueur1, joueur2);
	}
	
	@Test
	public void testAfficherScoreDebutDePartie() {
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		assertEquals("0-0", jeu.score());
	}
	
	@Test
	public void testJoueurMarquePoint(){
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		assertEquals("15-0", jeu.score());		
	}
	
	@Test
	public void testMemeJoueurMarquePoint(){
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur2.scored();
		assertEquals("15-15", jeu.score());		
	}
	@Test
	public void testMemeJoueurMarquePoint2(){
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		assertEquals("15-30", jeu.score());		
	}
	@Test
	public void testMemeJoueurMarquePoint3(){
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		assertEquals("30-30", jeu.score());		
	}
	@Test
	public void testMemeJoueurMarquePoint4(){
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		assertEquals("Egalité", jeu.score());		
	}
	

}
