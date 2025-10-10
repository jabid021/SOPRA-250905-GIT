package eshop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{

	@Column(name="company",length = 30)
	private String societe;

	public Fournisseur() {}


	public Fournisseur(String nom, String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}


	public String getSociete() {
		return societe;
	}


	public void setSociete(String societe) {
		this.societe = societe;
	}


	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", societe=" + societe + "]";
	}
	
	
}
