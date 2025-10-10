package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lastname",nullable = false,columnDefinition = "VARCHAR(15)")
	private String nom;
	
	@Column(name="firstname",nullable = false,length = 15)
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genre",nullable = false,columnDefinition = "enum('homme', 'femme', 'nb')")
	private Genre civilite;
	
	
	public Client() {}
	
	public Client(String nom, String prenom, Genre civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Genre getCivilite() {
		return civilite;
	}


	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}
	

	
}
