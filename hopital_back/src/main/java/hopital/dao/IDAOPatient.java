package hopital.dao;

import java.util.List;

import hopital.model.Patient;

public interface IDAOPatient extends IDAO<Patient,Integer> {
	public List<Patient> findByNom(String nom);
	public List<Patient> findByNomAndPrenom(String nom, String prenom);

	
}
