package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {
	
	@Id //OBLIGATOIRE pour preciser quelle colonne sert d'id coté bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBLIGATOIRE* 
	@Column(name="id")
	private Integer id;
	
	@Column(name="marque",nullable=false ,columnDefinition = "VARCHAR(50)")
	private String libelle;
	
	
	public Matiere() {
		
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}

	
}
