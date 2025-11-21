package quest.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;
import quest.rest.MatiereRestController;

@Service
public class MatiereService {

	private final static Logger log = LoggerFactory.getLogger(MatiereService.class);
	@Autowired
	IDAOMatiere daoMatiere;

	public Matiere getById(Integer id) throws RuntimeException
	{
		log.error("On pioche la matiere{} dans la base de données",id);
		if(id==null) 
		{
			throw new RuntimeException("L'id d'une matiere ne peut pas etre null");
			
		}
	return daoMatiere.findById(id).orElse(null);
	}

	public List<Matiere> getAll()
	{
		return daoMatiere.findAll();
	}
	
	public List<Matiere> getAllByLibelleLike(String recherche)
	{
		return daoMatiere.findByLibelleContaining(recherche);
	}

	public Matiere create(Matiere matiere) 
	{
		return daoMatiere.save(matiere);
	}

	public Matiere update(Matiere matiere) 
	{
		return daoMatiere.save(matiere);
	}

	public void deleteById(Integer id) 
	{
		daoMatiere.deleteById(id);
	}

	public void delete(Matiere matiere)
	{
		daoMatiere.delete(matiere);
	}
	
}
