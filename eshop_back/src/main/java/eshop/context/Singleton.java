package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.*;



public class Singleton {


	
	private static Singleton instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private IDAOAchat daoAchat = new DAOAchat();

	private IDAOPersonne daoPersonne = new DAOPersonne();
	private IDAOProduit daoProduit = new DAOProduit();

	
	
	
	
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

	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}

	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}

	
	
	

}
