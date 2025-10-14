package hopital.model;


import javax.persistence.*;
@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Compte{

	public Secretaire() {}

	public Secretaire(String login, String password) {
		super(login, password);
	}
	public Secretaire(Integer id,String login, String password) {
		super(id,login, password);
	}
	
	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
