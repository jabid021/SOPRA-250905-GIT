package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //OBLIGATOIRE, permet de creer une table 
@Table(name="drink")//Attention, sur mac et Linux, par defaut JPA va creer une table avec exactement le même nom que notre classe(Classe Boisson donne une table "Boisson")
public class Boisson {

	@Id //OBLIGATOIRE pour preciser quelle colonne sert d'id coté bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBLIGATOIRE* 
	private Integer id;
	
	@Column(name="label",nullable = false)
	private String nom;
	
	//En bdd, on peut limiter le nombre de decimales avec le type "DECIMAL(x,y)"   x => nombre total de digits , y=> nombre de digits apres la virgule
	@Column(name="price",columnDefinition = "DECIMAL(4,2)")
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
