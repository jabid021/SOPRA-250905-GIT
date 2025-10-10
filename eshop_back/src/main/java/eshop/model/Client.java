package eshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	
	private int age;
	@Column(name="birthdate")
	private LocalDate dateNaissance;
	@Embedded
	private Adresse adresse;
	
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + "]";
	}
	
	
	
}
