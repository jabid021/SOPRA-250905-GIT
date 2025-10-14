package quest.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate debut;
	private LocalDate fin;
	
	@Column(unique = true)
	private int quest;
	@ManyToOne
	@JoinColumn(name = "filiere")
	private Filiere filiere;
	
	@OneToOne
	@JoinColumn
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn
	private Formateur formateur;
	
	
	public Module(LocalDate debut, LocalDate fin, int quest, Filiere filiere, Matiere matiere,Formateur formateur) {
		this.debut = debut;
		this.fin = fin;
		this.quest = quest;
		this.filiere = filiere;
		this.matiere = matiere;
		this.formateur=formateur;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", debut=" + debut + ", fin=" + fin + ", quest=" + quest + ", filiere=" + filiere
				+ ", matiere=" + matiere + ", formateur=" + formateur + "]";
	}

	
	
	
	

}
