package hopital.dao;

import java.util.List;

import hopital.model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer> {
	
	public List<Visite> findAllByIdPatient(Integer idPatient);

}
