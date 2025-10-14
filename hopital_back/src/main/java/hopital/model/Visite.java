package hopital.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="visite")
public class Visite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private double prix;
	private int salle;

	@Column(name="date_visite",nullable = false)
	private LocalDate dateVisite;
	
	@JoinColumn(name="id_patient")
	@ManyToOne
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="id_medecin",nullable = false)
	private Medecin medecin;
	
	public Visite() {}
	
	public Visite(Integer numero, double prix, int salle, LocalDate dateVisite, Patient patient, Medecin medecin) {
		this.numero = numero;
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
		this.patient = patient;
		this.medecin = medecin;
	}

	public Visite(double prix, int salle, LocalDate dateVisite, Patient patient, Medecin medecin) {
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
		this.patient = patient;
		this.medecin = medecin;
	}
	
	public Visite(Patient patient, Medecin medecin) {
		this.prix = 20.0;
		this.salle = medecin.getSalle();
		this.dateVisite = LocalDate.now();
		this.patient = patient;
		this.medecin = medecin;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", prix=" + prix + ", salle=" + salle + ", dateVisite=" + dateVisite
				+ ", patient=" + patient + ", medecin=" + medecin + "]";
	}
	
	
	
	
	
}
