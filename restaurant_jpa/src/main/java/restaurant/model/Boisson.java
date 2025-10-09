package restaurant.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //OBLIGATOIRE, permet de creer une table 
public class Boisson {

	@Id //OBLIGATOIRE pour preciser quelle colonne sert d'id coté bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBLIGATOIRE* 
	private Integer id;
	private String nom;
	private double prix;
	private int volume;
	
	//JPA aura besoin d'un constructeur vide pour fonctionner
	public Boisson() {}

	public Boisson(String nom, double prix, int volume) {
		this.nom = nom;
		this.prix = prix;
		this.volume = volume;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prix=" + prix + ", volume=" + volume + "]";
	}
	
	
	
	
	
	
	
}
