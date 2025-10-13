package eshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	
	private int age;
	@Column(name="birthdate")
	private LocalDate dateNaissance;
	@Embedded
	private Adresse adresse;
	
	@OneToMany
	@JoinTable
	(
	name="achats",
	joinColumns = @JoinColumn(name="acheteur"),
	inverseJoinColumns = @JoinColumn(name="produit")
	)
	private List<Achat> achats = new ArrayList();
	
	public Client() {}

	public Client(String nom, String prenom, int age, LocalDate dateNaissance,String numero,String voie,String ville,String cp) {
		super(nom, prenom);
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.adresse=new Adresse(numero,voie,ville,cp);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + "]";
	}
	
	
	
}
