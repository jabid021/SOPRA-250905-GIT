package restaurant.dao;

import restaurant.model.Client;

public interface IDAOClient extends IDAO<Client,Integer> {

	
	public Client findByIdWithHistoriqueResa(Integer idClient);
}
