package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity 
@Table(name="boisson")
@PrimaryKeyJoinColumn(name="boisson_id")
public class Boisson extends Article{

	
	private int volume;

	public Boisson() {}


	public Boisson(String nom, double prix, int volume) {
		super(nom, prix);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prix=" + prix + ", volume=" + volume + "]";
	}
	
	
	
	
	
	
	
}
