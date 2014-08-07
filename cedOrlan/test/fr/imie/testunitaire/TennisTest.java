package fr.imie.testunitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.imie.test.ISerialiser;
import fr.imie.test.Jeu;
import fr.imie.test.Joueur;
import fr.imie.test.Serialiser;
import static org.mockito.Mockito.*;

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
/*	
	@Test
	public void testAvantage(){		
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		joueur1.scored();
		assertEquals("Avantage-joueur1", jeu.score());
		
	}
*/
	
	@Test
	
	public void testsauvegarde(){		
		MockSerialiser ms = new MockSerialiser();
		Jeu jeu = ms.read("jeux.serial");
		assertEquals("Egalité", jeu.score());		

		
	}
	
	@Test
	
	public void testsauvegardeWithMock(){	
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		ISerialiser mockSerialise = mock(ISerialiser.class);
		jeu.setSerialiser(mockSerialise);
		jeu.save();
		jeu.reset(jeu);
		Jeu jeu2 = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		when(mockSerialise.read("jeux.serial")).thenReturn(jeu2);
		jeu = jeu.load();
		assertEquals("Egalité", jeu.score());		

		
	}
	@Test
	
	public void testsauvegarde2(){		
		Joueur joueur1 = new Joueur();
		Joueur joueur2 = new Joueur();
		Jeu jeu = new Jeu(joueur1, joueur2);
		joueur1.scored();
		joueur1.scored();
		joueur2.scored();
		joueur2.scored();
		joueur1.scored();
		joueur2.scored();
		jeu.save();
		jeu.reset(jeu);
		jeu = jeu.load();
		assertEquals("Egalité", jeu.score());		

		
	}


}
