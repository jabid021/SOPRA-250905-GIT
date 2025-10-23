package quest.dao;

import java.util.List;

import quest.model.Matiere;

public interface IDAOMatiere extends IDAO<Matiere,Integer> {

	public List<Matiere> findByLibelleLike(String recherche);
}
