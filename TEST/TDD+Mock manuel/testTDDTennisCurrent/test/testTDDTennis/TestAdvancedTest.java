package testTDDTennis;

import static org.junit.Assert.assertEquals;

import org.imie.testTDDTennis.Jeux;
import org.imie.testTDDTennis.Serialiser;
import org.junit.Before;
import org.junit.Test;

public class TestAdvancedTest {


	private Jeux jeux;
	
	
	@Before
	public void setUp() throws Exception {
		jeux=new Jeux();

		
	}
	

	@Test
	public void gagneJ1() {
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		assertEquals("victoire J1", jeux.getScore()); 
	}
	
	@Test
	public void gagneJ2ApresEgalite() {
		initToEgalite();
		jeux.marquerJoueur2();
		jeux.marquerJoueur1();
		jeux.marquerJoueur2();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();
		assertEquals("victoire J2", jeux.getScore()); 
	}
	
	
	private void initToEgalite() {
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
	}

}
