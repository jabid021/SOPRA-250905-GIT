package restaurant.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("worker")
public class Employe extends Compte{

	//Impossible de mettre nullable false pour le nom d'un employe car les admin qui sont dans la même table n'ont JAMAIS de nom/prenom, la colonne doit forcement pouvoir etre null
	@Column(columnDefinition = "VARCHAR(20)")
	private String nom;
	
	@Column(length = 25)
	private String prenom;
	
	@Column(name="date_embauche")
	private LocalDate dateEmbauche;
	
	//Les infos de l'adresse doivent etre embarquées dans la table compte
	@Embedded
	private  Adresse adresse;
	
	public Employe() {}
	
	
	public Employe(String login, String password, String nom, String prenom, LocalDate dateEmbauche, String numero,String voie,String ville,String cp) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.adresse = new Adresse(numero,voie,ville,cp);
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

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateEmbauche=" + dateEmbauche
				+ ", adresse=" + adresse + "]";
	}
	
	
	
	
}
