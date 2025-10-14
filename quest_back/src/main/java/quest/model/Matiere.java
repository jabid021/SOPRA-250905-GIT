package quest.model;

import javax.persistence.*;

@Entity
@Table(name="matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,columnDefinition = "VARCHAR(50)")
	private String libelle;
	
	public Matiere() {}
	public Matiere(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}

	
}
