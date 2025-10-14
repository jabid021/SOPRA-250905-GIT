package restaurant.dao;

import java.util.List;

import restaurant.model.Client;

public interface IDAOClient extends IDAO<Client,Integer> {

	
	public Client findByIdWithHistoriqueResa(Integer idClient);
	
	
	public List<Client> findAllWithHistoriqueResa();
	
	public List<Long> countClientByCivilite();
	
	public List<Object[]> countClientByCiviliteWithCivilite();
}
