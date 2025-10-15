package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOPersonne;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOPersonne;

public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private static Singleton instance=null;
	
	private IDAOModule daoModule = new DAOModule();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	private IDAOMatiere daoMatiere = new DAOMatiere();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {instance = new Singleton();}
		return instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDAOModule getDaoModule() {
		return daoModule;
	}

	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}

	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}

	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}

	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}

	
	
}
