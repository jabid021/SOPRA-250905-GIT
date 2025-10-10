package restaurant.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dateReservation;
	private int nbPersonne;
	
	
	
	/*@XToY => 
	X => Combien de lien dans l'autre classe ?
	Y => Combien de lien dans la classe actuelle ?
			One Many
	*/		
			
	@ManyToOne	
	@JoinColumn(name="tableuh",nullable = false)
	private Tableuh table;
	@ManyToOne
	@JoinColumn(name="client",nullable=false)
	private Client client;
	
	
	public Reservation() {}


	public Reservation(LocalDateTime dateReservation, int nbPersonne, Tableuh table, Client client) {
		this.dateReservation = dateReservation;
		this.nbPersonne = nbPersonne;
		this.table = table;
		this.client = client;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(LocalDateTime dateReservation) {
		this.dateReservation = dateReservation;
	}


	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}


	public Tableuh getTable() {
		return table;
	}


	public void setTable(Tableuh table) {
		this.table = table;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", nbPersonne=" + nbPersonne
				+ ", table=" + table + ", client=" + client + "]";
	}

	
	
	
}
