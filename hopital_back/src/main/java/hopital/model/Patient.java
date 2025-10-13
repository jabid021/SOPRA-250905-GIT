package hopital.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient implements Serializable{

	@Id
	private Integer id;
	@Column(length = 50,nullable=false)
	private String nom;
	@Column(length = 50,nullable=false)
	private String prenom;
	
	@OneToMany(mappedBy="patient")
	private List<Visite> historique;
	
	public Patient() {}
	
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
