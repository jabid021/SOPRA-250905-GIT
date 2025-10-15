package restaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;

import restaurant.context.Singleton;
import restaurant.model.Assiette;
import restaurant.model.Couvert;
import restaurant.model.Vaisselle;
import restaurant.model.Verre;

public class DAOVaisselle implements IDAOVaisselle {

	@Override
	public List<Vaisselle> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Vaisselle> vaisselles  = em.createQuery("from Vaisselle").getResultList();
		em.close();
		return vaisselles;
	}

	@Override
	public Vaisselle findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Vaisselle vaisselle  = em.find(Vaisselle.class, id);
		em.close();
		return vaisselle;
	}

	@Override
	public Vaisselle save(Vaisselle vaisselle) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		vaisselle=  em.merge(vaisselle);
		em.getTransaction().commit();
		em.close();
		return vaisselle;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Vaisselle vaisselle = em.find(Vaisselle.class, id);
		em.remove(vaisselle);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Vaisselle vaisselle) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		vaisselle = em.merge(vaisselle);
		em.remove(vaisselle);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Couvert> findAllCouvert() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Couvert> vaisselles  = em.createQuery("from Couvert").getResultList();
		em.close();
		return vaisselles;
	}

	@Override
	public List<Assiette> findAllAssiette() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Assiette> vaisselles  = em.createQuery("from Assiette").getResultList();
		em.close();
		return vaisselles;
	}

	@Override
	public List<Verre> findAllVerre() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Verre> vaisselles  = em.createQuery("from Verre").getResultList();
		em.close();
		return vaisselles;
	}

}
