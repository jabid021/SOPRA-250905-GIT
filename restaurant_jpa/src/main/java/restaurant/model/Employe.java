package restaurant.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private LocalDate dateEmbauche;
	
	private transient Adresse adresse;
	
	public Employe() {}
	
	public Employe(String nom, String prenom, LocalDate dateEmbauche,String numero,String voie,String ville,String cp) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.adresse=new Adresse(numero,voie,ville,cp);
		
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
