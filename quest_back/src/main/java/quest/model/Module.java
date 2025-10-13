package quest.model;

import java.time.LocalDate;

public class Module {

	private Integer id;
	private LocalDate debut;
	private LocalDate fin;
	private int quest;
	private Filiere filiere;
	private Matiere matiere;
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
