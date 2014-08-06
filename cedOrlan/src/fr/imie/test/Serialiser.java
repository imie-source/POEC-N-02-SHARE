package fr.imie.test;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialiser implements ISerialiser {
	/* (non-Javadoc)
	 * @see fr.imie.test.ISerialiser#persist(fr.imie.test.Jeu, java.lang.String)
	 */
	@Override
	public void persist(Jeu jeux, String chemin) {
		ObjectOutputStream oos = null;
		FileOutputStream fichier;
		try {
			fichier = new FileOutputStream(chemin);
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(jeux);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	/* (non-Javadoc)
	 * @see fr.imie.test.ISerialiser#read(java.lang.String)
	 */
	@Override
	public Jeu read(String chemin) {
		ObjectInputStream ois = null;
		FileInputStream fichier;
		Jeu retour;
		try {
			fichier = new FileInputStream(chemin);
			ois = new ObjectInputStream(fichier);
			retour = (Jeu) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return retour;
	}
}

