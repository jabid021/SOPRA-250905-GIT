package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.model.Filiere;
import quest.context.Singleton;

public class DAOFiliere implements IDAOFiliere {

	@Override
	public List<Filiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres  = em.createQuery("from Filiere").getResultList();
		em.close();
		return filieres;
	}

	@Override
	public Filiere findById(Integer id) {
		 EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
	        Filiere filiere = em.find(Filiere.class, id);
	        em.close();
	        return filiere;
	}

	@Override
	public Filiere save(Filiere filiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		filiere=  em.merge(filiere);
		em.getTransaction().commit();
		em.close();
		return filiere;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Filiere client = em.find(Filiere.class, id);
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Filiere filiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		filiere = em.merge(filiere);
		em.remove(filiere);
		em.getTransaction().commit();
		em.close();
	}

}
