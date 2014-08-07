package fr.imie.test;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@SessionScoped
@Named("joueur")
public class Joueur implements Serializable{
	
	static private final long serialVersionUID = 6L;

	
	private int score;
	
	public Joueur(){
		this.score = 0;
		
	}
	
	
	public int getScore(){
		return this.score;
	}
	public void setScore(int score){
		this.score = score;
	}

	public int scored(){
		this.score+=1;
		
		return this.score;
		
	}
	
}
