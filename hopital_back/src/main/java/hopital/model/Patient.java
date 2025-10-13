package hopital.model;

import java.io.Serializable;
import java.util.List;

public class Patient implements Serializable{

	private Integer id;
	private String nom;
	private String prenom;
	
	private List<Visite> historique;
	
	public Patient(Integer id, String nom, String prenom) {
		this.id = id;
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

	public List<Visite> getHistorique() {
		return historique;
	}


	public void setHistorique(List<Visite> historique) {
		this.historique = historique;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	
	

	
	
}
