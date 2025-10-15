package restaurant.dao;

import java.util.List;

import restaurant.model.Admin;
import restaurant.model.Compte;
import restaurant.model.Employe;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	public Compte findByLoginAndPassword(String login,String password);
	public List<Admin> findAllAdmin();
	public List<Employe> findAllEmploye();
}
