package eshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="num",length = 10)
	private String numero;
	@Column(name="street",length = 50)
	private String voie;
	@Column(name="city",length = 50)
	private String ville;
	@Column(name="postal_code",length = 15)
	private String cp;
	
	public Adresse() {}
	
	public Adresse(String numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}

	
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + "]";
	}
	
	
	
}
