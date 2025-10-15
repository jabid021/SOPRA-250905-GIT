package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private static Singleton instance=null;
	private IDAOPersonne daoAchat = new DAOPersonne();
	private IDAOOrdinateur daoArticle = new DAOOrdinateur();
	private IDAOFiliere daoClient = new DAOFiliere());
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

	public IDAOPersonne getDaoAchat() {
		return daoAchat;
	}

	public IDAOOrdinateur getDaoArticle() {
		return daoArticle;
	}

	public IDAOFiliere getDaoClient() {
		return daoClient;
	}

	public IDAOModule getDaoCompte() {
		return daoCompte;
	}

	public IDAOMatiere getDaoTableuh() {
		return daoTableuh;
	}
	
	
}
