package restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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


	 @Override
	 public String toString() {
		return "Table [id=" + id + ", nbPlace=" + nbPlace + ", serveur=" + serveur + "]";
	 }
	 
	 
	 
	 
}
