package testTDDTennis;

import org.imie.testTDDTennis.ISerialiser;
import org.imie.testTDDTennis.Jeux;

public class MockedSerialiser2 implements ISerialiser {

	@Override
	public void persist(Jeux jeux) {
		// TODO Auto-generated method stub

	}

	@Override
	public Jeux read() {
		Jeux jeux = new Jeux();
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur2();
		return jeux;
	}

}
