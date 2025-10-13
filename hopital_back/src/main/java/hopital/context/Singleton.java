package hopital.context;

import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;

public class Singleton {

	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPatient daoPatient = new DAOPatient();
	private IDAOVisite daoVisite = new DAOVisite();
	
	private static Singleton instance=null;
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		//Si c'est la premiere fois qu'on call .getInstance() dans l'app, la creation de l'objet se fait
		if(instance==null) {instance = new Singleton();}
		return instance;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}
	
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}
	
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}
	
	
	
	
	
	
}
