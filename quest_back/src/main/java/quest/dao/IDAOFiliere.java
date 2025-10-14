package quest.dao;

import java.util.List;

import quest.model.Filiere;

public interface IDAOFiliere extends IDAO<Filiere, Integer> {
	
	public List<Filiere> findByLibLike(String libelle);
	public Filiere findByIdWithVentes(Integer idFiliere);

}
