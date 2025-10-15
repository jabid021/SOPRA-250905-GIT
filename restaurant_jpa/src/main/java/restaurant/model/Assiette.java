package restaurant.model;

import javax.persistence.Entity;

@Entity
public class Assiette extends Vaisselle{

	public Assiette() {}

	public Assiette(String description) {
		super(description);
	}

	@Override
	public String toString() {
		return "Assiette [id=" + id + ", description=" + description + "]";
	}
	
}
