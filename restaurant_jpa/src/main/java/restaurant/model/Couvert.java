package restaurant.model;

import javax.persistence.Entity;

@Entity
public class Couvert extends Vaisselle {

	private boolean argent;
	public Couvert() {}
	
	
	public Couvert(String description, boolean argent) {
		super(description);
		this.argent = argent;
	}


	public boolean isArgent() {
		return argent;
	}
	public void setArgent(boolean argent) {
		this.argent = argent;
	}

	@Override
	public String toString() {
		return "Couvert [id=" + id + ", description=" + description + ", argent=" + argent + "]";
	}
	
	
}
