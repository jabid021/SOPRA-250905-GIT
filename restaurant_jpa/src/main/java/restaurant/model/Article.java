package restaurant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //OBLIGATOIRE, permet de creer une table 
@Table(name="article")//Attention, sur mac et Linux, par defaut JPA va creer une table avec exactement le même nom que notre classe(Classe Article donne une table "Article")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Article {

	
	@Id //OBLIGATOIRE pour preciser quelle colonne sert d'id coté bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBLIGATOIRE* 
	@Column(name="article_id")
	protected Integer id;
	
	@Column(name="label",nullable = false)
	protected String nom;
	
	//En bdd, on peut limiter le nombre de decimales avec le type "DECIMAL(x,y)"   x => nombre total de digits , y=> nombre de digits apres la virgule
	@Column(name="price",columnDefinition = "DECIMAL(5,2)")
	protected double prix;
	
	
	@OneToMany(mappedBy="article")
	protected List<Achat> ventes;
	
	//JPA aura besoin d'un constructeur vide pour fonctionner
	public Article() {}

	public Article(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
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

	public List<Achat> getVentes() {
		return ventes;
	}

	public void setVentes(List<Achat> ventes) {
		this.ventes = ventes;
	}
	
}
