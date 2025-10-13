package restaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"lastname","firstname"}))
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lastname",nullable = false,columnDefinition = "VARCHAR(15)")
	private String nom;
	
	@Column(name="firstname",nullable = false,length = 15)
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genre",nullable = false,columnDefinition = "enum('homme', 'femme', 'nb')")
	private Genre civilite;

	@OneToMany
	@JoinTable
	(
			name="achats",
			joinColumns = @JoinColumn(name="client"), //col gauche
			inverseJoinColumns = @JoinColumn(name="article"), //col droite
			uniqueConstraints=@UniqueConstraint(columnNames = {"client","article"}) 		
	)
	private List<Achat> achats = new ArrayList();
	
	public Client() {}
	
	public Client(String nom, String prenom, Genre civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Genre getCivilite() {
		return civilite;
	}


	public void setCivilite(Genre civilite) {
		this.civilite = civilite;
	}
	
	
	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}
	

	
}
