package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="plat")
@PrimaryKeyJoinColumn(name="plat_id")
public class Plat extends Article{

	@Column(length = 50,nullable=false)
	private String taille;
	
	public Plat() {}
	
	public Plat(String nom, double prix,String taille) {
		super(nom, prix);
		this.taille=taille;
	}

	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", taille=" + taille + "]";
	}

	
	
	
}
