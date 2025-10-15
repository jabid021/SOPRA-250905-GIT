package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOModule;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;


public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private static Singleton instance=null;
	private IDAOPersonne daoAchat = new DAOPersonne();
	private IDAOOrdinateur daoArticle = new DAOOrdinateur();
	private IDAOFiliere daoClient = new DAOFiliere();
	private IDAOModule daoCompte = new DAOModule();
	private IDAOMatiere daoTableuh = new DAOMatiere();
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {instance = new Singleton();}
		return instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}

	
	
}
