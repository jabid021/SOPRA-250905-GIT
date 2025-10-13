package restaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;

import restaurant.context.Singleton;
import restaurant.model.Compte;

public class DAOCompte implements IDAOCompte {

	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Compte> comptes  = em.createQuery("from Compte").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte  = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		compte=  em.merge(compte);
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Compte compte = em.find(Compte.class, id);
		em.remove(compte);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Compte compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		compte = em.merge(compte);
		em.remove(compte);
		em.getTransaction().commit();
		em.close();
	}

}
