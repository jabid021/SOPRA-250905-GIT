package restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "sequence_vaisselle",sequenceName = "vaisselle_id_bdd")
public abstract class Vaisselle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_vaisselle")
	@Column(name="id_vaisselle")
	protected Integer id;
	
	
	
	@Column(length = 50,nullable = false)
	protected String description;
	
	public Vaisselle() {}
	
	public Vaisselle(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	
}
