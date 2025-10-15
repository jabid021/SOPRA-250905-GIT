package restaurant.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import restaurant.dao.DAOAchat;
import restaurant.dao.DAOArticle;
import restaurant.dao.DAOClient;
import restaurant.dao.DAOCompte;
import restaurant.dao.DAOReservation;
import restaurant.dao.DAOTableuh;
import restaurant.dao.DAOVaisselle;
import restaurant.dao.IDAOAchat;
import restaurant.dao.IDAOArticle;
import restaurant.dao.IDAOClient;
import restaurant.dao.IDAOCompte;
import restaurant.dao.IDAOReservation;
import restaurant.dao.IDAOTableuh;
import restaurant.dao.IDAOVaisselle;

public class Singleton {


	
	private static Singleton instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOArticle daoArticle = new DAOArticle();
	private IDAOClient daoClient = new DAOClient();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOReservation daoReservation = new DAOReservation();
	private IDAOTableuh daoTableuh = new DAOTableuh();
	private IDAOVaisselle daoVaisselle = new DAOVaisselle();
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {instance = new Singleton();}
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}

	public IDAOArticle getDaoArticle() {
		return daoArticle;
	}

	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}

	public IDAOTableuh getDaoTableuh() {
		return daoTableuh;
	}

	public IDAOVaisselle getDaoVaisselle() {
		return daoVaisselle;
	}


	
	
	
	
	
}
