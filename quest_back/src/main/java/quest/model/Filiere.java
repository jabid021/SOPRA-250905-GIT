package quest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="filiere")
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,columnDefinition = "VARCHAR(50)")
	private String libelle;
	private LocalDate debut;
	private LocalDate fin;
	@OneToMany(mappedBy="matiere")
	private List<Module> matieres;
	@OneToMany(mappedBy="matiere")
	private List<Stagiaire> inscrits;
	
	public Filiere() {}
	//update,select
	public Filiere(Integer id, String libelle, LocalDate debut, LocalDate fin) {
		this.id = id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}

	//insert
	public Filiere(String libelle, LocalDate debut, LocalDate fin) {
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
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

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public List<Module> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Module> matieres) {
		this.matieres = matieres;
	}
	
	

	public List<Stagiaire> getInscrits() {
		return inscrits;
	}

	public void setInscrits(List<Stagiaire> inscrits) {
		this.inscrits = inscrits;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + "]";
	}
	
	
}
