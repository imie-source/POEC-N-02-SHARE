package fr.imie.test;

public interface ISerialiser {

	public abstract void persist(Jeu jeux, String chemin);

	public abstract Jeu read(String chemin);

}