package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import quest.dao.*;

public class Singleton {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private static Singleton instance=null;
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOModule daoModule = new DAOModule();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOPersonne daoPersonne = new DAOPersonne();
 
	
	
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

	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}
	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}
	public IDAOModule getDaoModule() {
		return daoModule;
	}
	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}
	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}
	
	
	
	
	
}
