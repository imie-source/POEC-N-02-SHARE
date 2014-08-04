package fr.imie.test;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

	private List<Joueur> joueurs = new ArrayList();
	
	
	
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
	



}
