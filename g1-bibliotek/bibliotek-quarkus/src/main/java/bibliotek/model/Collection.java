
package bibliotek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="Collection")
public class Collection {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column()
    protected String nom;
	
	public Collection() {
		// TODO Auto-generated constructor stub
	}

	public Collection(String nom) {
		this.nom = nom;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Collection [id=" + id + ", nom=" + nom + "]";
	}
}