package hopital.dao;

import java.util.List;

import javax.persistence.EntityManager;

import hopital.context.Singleton;
import hopital.model.Visite;


public class DAOVisite implements IDAOVisite {
	
	@Override
	public List<Visite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visite  = em.createQuery("from Visite").getResultList();
		em.close();
		return visite;
	}

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		visite =  em.merge(visite);
		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Visite visite = em.find(Visite.class, id);
		em.remove(visite);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Visite visite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		visite = em.merge(visite);
		em.remove(visite);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Visite> findAllByIdPatient(Integer idPatient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visites  = em.createQuery("Select v from Visite v WHERE v.patient.id = :id", Visite.class)
	    .setParameter("id", idPatient)
	    .getResultList();
		em.close();
		return visites;
	}


}
