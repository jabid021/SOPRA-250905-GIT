package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordinateur {

	@Id //OBLIGATOIRE pour preciser quelle colonne sert d'id coté bdd
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBLIGATOIRE* 
	@Column(name="numero")
	private Integer id;
	
	@Column(name="marque",columnDefinition = "VARCHAR(25)")
	private String marque;
	
	@Column(name="ram")
	private int ram;
	
	
	public Ordinateur() {
		
	}
	public Ordinateur(Integer id, String marque, int ram) {
		this.id = id;
		this.marque = marque;
		this.ram = ram;
	}
	public Ordinateur(String marque, int ram) {
		this.marque = marque;
		this.ram = ram;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", ram=" + ram + "]";
	}
	
	
	
}
