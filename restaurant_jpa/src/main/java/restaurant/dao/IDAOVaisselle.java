package restaurant.dao;

import java.util.List;

import restaurant.model.Assiette;
import restaurant.model.Couvert;
import restaurant.model.Vaisselle;
import restaurant.model.Verre;

public interface IDAOVaisselle extends IDAO<Vaisselle,Integer> {

	public List<Couvert> findAllCouvert();
	public List<Assiette> findAllAssiette();
	public List<Verre> findAllVerre();
	
}
