package fr.imie.test;

public class Joueur {
	
	private int score;
	
	public Joueur(){
		this.score = 0;
		
	}
	
	
	public int getScore(){
		return this.score;
	}

	public int scored(){
		this.score+=1;
		
		return this.score;
		
	}
	
}
