package restaurant.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="achat")
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_achat",nullable = false)
	private LocalDate dateAchat;
	
	
	@ManyToOne
	@JoinColumn(name="client",nullable = false)
	private Client client;
	@ManyToOne
	@JoinColumn(name="article",nullable = false)
	private Article article;

	
	public Achat() {}


	public Achat(LocalDate dateAchat, Client client, Article article) {
		this.dateAchat = dateAchat;
		this.client = client;
		this.article = article;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", client=" + client + ", article=" + article + "]";
	}

	
}
