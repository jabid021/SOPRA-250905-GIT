package restaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Tableuh {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int nbPlace;
	
	@OneToOne
	@JoinColumn(name="serveur")
	private Employe serveur;
	
	@OneToMany(mappedBy="table")
	private List<Reservation> historiqueResa;
	

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="couleurs_des_tables",joinColumns = @JoinColumn(name="la_table"))
	@Column(name="la_couleur")
	@Enumerated(EnumType.STRING)
	private List<Couleur> couleurs = new ArrayList();
	
	public Tableuh() {}


	 public Tableuh(int nbPlace) {
		this.nbPlace = nbPlace;
	 }


	 public Integer getId() {
		 return id;
	 }


	 public void setId(Integer id) {
		 this.id = id;
	 }


	 public int getNbPlace() {
		 return nbPlace;
	 }


	 public void setNbPlace(int nbPlace) {
		 this.nbPlace = nbPlace;
	 }


	 public Employe getServeur() {
		 return serveur;
	 }


	 public void setServeur(Employe serveur) {
		 this.serveur = serveur;
	 }


	 
	 public List<Reservation> getHistoriqueResa() {
		return historiqueResa;
	}


	 public void setHistoriqueResa(List<Reservation> historiqueResa) {
		 this.historiqueResa = historiqueResa;
	 }


	 
	 public List<Couleur> getCouleurs() {
		return couleurs;
	}


	 public void setCouleurs(List<Couleur> couleurs) {
		 this.couleurs = couleurs;
	 }


	 @Override
	 public String toString() {
		return "Tableuh [id=" + id + ", nbPlace=" + nbPlace + ", serveur=" + serveur + ", couleurs=" + couleurs + "]";
	 }


	
 
}
