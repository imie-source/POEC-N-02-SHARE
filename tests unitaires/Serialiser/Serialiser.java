package org.imie.testTDDTennis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialiser {
	public void persist(Jeux jeux)  {
		ObjectOutputStream oos = null;
		FileOutputStream fichier;
		try {
			fichier = new FileOutputStream("jeux.ser");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(jeux);
			oos.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public Jeux read()  {
		ObjectInputStream ois = null;
		FileInputStream fichier;
		Jeux retour;
		try {
			fichier = new FileInputStream("jeux.ser");
			ois = new ObjectInputStream(fichier);
			retour = (Jeux) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return retour;
	}
}
