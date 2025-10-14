package quest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends Personne{
	
	@Column(length = 50, nullable=true)
	private String email;
	@Embedded
	private Adresse adresse;
	@OneToOne
	@JoinColumn(nullable=true)
	private Ordinateur ordinateur;
	@ManyToOne
	@JoinColumn(name="filiere", nullable=true)
	private Filiere filiere;
	
	public Stagiaire() {
		// TODO Auto-generated constructor stub
	}
	
	public Stagiaire(Integer id, String login, String password, String nom, String prenom,Civilite civilite, String email,
			String numero,String voie,String ville,String cp, Ordinateur ordinateur,Filiere filiere) {
		super(id, login, password, nom, prenom,civilite);
		this.email = email;
		this.adresse = new Adresse(numero,voie,ville,cp);
		this.ordinateur = ordinateur;
		this.filiere=filiere;
	}
	
	public Stagiaire(String login, String password, String nom, String prenom,Civilite civilite, String email,
			String numero,String voie,String ville,String cp, Ordinateur ordinateur,Filiere filiere) {
		super(login, password, nom, prenom,civilite);
		this.email = email;
		this.adresse = new Adresse(numero,voie,ville,cp);
		this.ordinateur = ordinateur;
		this.filiere=filiere;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", adresse=" + adresse + ", ordinateur=" + ordinateur + ", filiere="
				+ filiere + "]";
	}

	

	
	
	
}
