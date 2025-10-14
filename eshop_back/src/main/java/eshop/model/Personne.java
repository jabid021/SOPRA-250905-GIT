package eshop.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne", columnDefinition = "ENUM('customer','supplier')")
public abstract class Personne {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected String nom;
	protected String prenom;
	
	public Personne() {}
	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;

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


	
	
	
	

}
