package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Formateur;

public class DAOFormateur implements IDAOFormateur {

	@Override
	public List<Formateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Formateur> formateurs  = em.createQuery("from Formateur").getResultList();
		em.close();
		return formateurs;
	}

	@Override
	public Formateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Formateur formateur  = em.find(Formateur.class, id);
		em.close();
		return formateur;
	}

	@Override
	public Formateur save(Formateur formateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		formateur=  em.merge(formateur);
		em.getTransaction().commit();
		em.close();
		return formateur;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Formateur formateur = em.find(Formateur.class, id);
		em.remove(formateur);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Formateur formateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		formateur = em.merge(formateur);
		em.remove(formateur);
		em.getTransaction().commit();
		em.close();
	}

}
