package restaurant.model;

import javax.persistence.Entity;

@Entity
public class Verre extends Vaisselle{

	private int taille;
	
	public Verre() {}

	public Verre(String description, int taille) {
		super(description);
		this.taille = taille;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Verre [id=" + id + ", description=" + description + ", taille=" + taille + "]";
	}

	
}
