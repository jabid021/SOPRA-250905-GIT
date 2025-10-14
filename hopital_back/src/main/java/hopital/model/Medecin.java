package hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte{
	@OneToMany(mappedBy="medecin")
	private transient List<Visite> consultations=new ArrayList();  
	private transient int salle;

	
	public Medecin() {}
	


	public Medecin(String login, String password) {
		super(login, password);
	}
	public Medecin(Integer id,String login, String password) {
		super(id,login, password);
	}


	public List<Visite> getConsultations() {
		return consultations;
	}


	public void setConsultations(List<Visite> consultations) {
		this.consultations = consultations;
	}


	public int getSalle() {
		return salle;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", salle=" + salle + "]";
	}
	
	
}
