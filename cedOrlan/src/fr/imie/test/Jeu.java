package fr.imie.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
@SessionScoped
public class Jeu implements Serializable{
	
	static private final long serialVersionUID = 6L;
	
	@Inject @Named("serialiser")
	private transient ISerialiser serialiser;
	private Joueur joueur1;
	private Joueur joueur2;
	private List<Joueur> joueurs = new ArrayList();

	public Jeu() {
		super();
		joueur1 = new Joueur();
		joueur2 = new Joueur();
		this.joueurs.add(this.joueur1);
		this.joueurs.add(this.joueur2);
	}


	public ISerialiser getSerialiser() {
		return this.serialiser;
	}


	public void setSerialiser(ISerialiser serialiser) {
		this.serialiser = serialiser;
	}



	
	
	
	
	public Jeu(Joueur joueur1, Joueur joueur2){
		this.joueurs.add(joueur1);
		this.joueurs.add(joueur2);
		
	}
	
	
	public String score() {
		String score;
		
		int scoreJoueur1 = joueurs.get(0).getScore();
		int scoreJoueur2 = joueurs.get(1).getScore();
		
		if(scoreJoueur1 == 1){
			scoreJoueur1 = 15;
		}
		if(scoreJoueur1 == 2){
			scoreJoueur1 = 30;
		}
		if(scoreJoueur1 == 3){
			scoreJoueur1 = 40;
		}		
		
		if(scoreJoueur2 == 1){
			scoreJoueur2 = 15;
		}
		if(scoreJoueur2 == 2){
			scoreJoueur2 = 30;
		}
		if(scoreJoueur2 == 3){
			scoreJoueur2 = 40;
		}
		
		score = scoreJoueur1+"-"+scoreJoueur2;
		System.out.println(scoreJoueur1+"-"+scoreJoueur2);
		if(scoreJoueur1 == 40 && scoreJoueur2 == 40){
			score="Egalité";
		}
		
		return score;
	}
	
	public void save(){
		serialiser.persist(this, "jeux.serial");
		/*
		ObjectOutputStream oos = null;
		FileOutputStream fichier;
		try {
			fichier = new FileOutputStream("jeux.serial");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(jeu);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		*/
	}
	
	public Jeu load(){
		return serialiser.read("jeux.serial");
		
		/*
		ObjectInputStream ois = null;
		FileInputStream fichier;
		Jeu retour;
		try {
			fichier = new FileInputStream("jeux.serial");
			ois = new ObjectInputStream(fichier);
			retour = (Jeu) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return retour;
		*/
	}
	


	public void reset(Jeu jeu){


		jeu.joueurs.get(0).setScore(0);
		jeu.joueurs.get(1).setScore(0);

	}
}



