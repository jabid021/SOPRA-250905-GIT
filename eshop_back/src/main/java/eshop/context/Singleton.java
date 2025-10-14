package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOAchat;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;

public class Singleton {


	
	private static Singleton instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOProduit daoProduit = new DAOProduit();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	
	
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {instance = new Singleton();}
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}

	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}

	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}

	

	
	
	
	
}
