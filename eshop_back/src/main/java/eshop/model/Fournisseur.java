package eshop.model;


import java.util.List;

import javax.persistence.*;


@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{


	@Column(name="company",length = 30)
	private String societe;
	@OneToMany(mappedBy="fournisseur")
	private List<Produit> stock;
	
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


	public List<Produit> getStock() {
		return stock;
	}


	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", societe=" + societe + "]";
	}
	
	


}