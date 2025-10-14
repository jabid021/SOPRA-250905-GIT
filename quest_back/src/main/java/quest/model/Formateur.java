package quest.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends Personne {

	private boolean admin;
	
	@OneToMany(mappedBy="Formateur")
	private List<Module> formations;
	
	public Formateur(Integer id, String login, String password, String nom, String prenom,Civilite civilite, boolean admin) {
		super(login, password, nom, prenom,civilite);
		this.admin = admin;
	}

	public Formateur(String login, String password, String nom, String prenom,Civilite civilite, boolean admin) {
		super(login, password, nom, prenom,civilite);
		this.admin = admin;
	}

	public Formateur() {}
	
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
