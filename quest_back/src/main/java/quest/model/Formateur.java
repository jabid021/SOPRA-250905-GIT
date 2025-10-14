package quest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends Personne {

	@Column(name="admin", columnDefinition="tinyint(1)")
	private boolean admin;
	
	@ManyToOne
	@mappedBy(name="formateur")
	private List<Module> formations;
	
	public Formateur() {}
	
	public Formateur(Integer id, String login, String password, String nom, String prenom,Civilite civilite, boolean admin) {
		super(id, login, password, nom, prenom,civilite);
		this.admin = admin;
	}

	public Formateur(String login, String password, String nom, String prenom,Civilite civilite, boolean admin) {
		super(login, password, nom, prenom,civilite);
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
	public List<Module> getFormations() {
		return formations;
	}

	public void setFormations(List<Module> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", admin=" + admin + "]";
	}
	
	
}
