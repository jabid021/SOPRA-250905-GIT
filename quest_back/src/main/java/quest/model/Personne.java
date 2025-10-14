package quest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne", columnDefinition = "ENUM('Stagiaire','Formateur')")
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length=25)
	protected String login;
	@Column(length=180)
	protected String password;
	@Column(length=30)
	protected String nom;
	@Column(length=30)
	protected String prenom;
	@Column(columnDefinition="enum('Homme', 'Femme', 'NB')")
	protected Civilite civilite;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	public Personne(Integer id, String login, String password, String nom, String prenom,Civilite civilite) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite=civilite;
	}
	
	public Personne(String login, String password, String nom, String prenom,Civilite civilite) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite=civilite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

}
