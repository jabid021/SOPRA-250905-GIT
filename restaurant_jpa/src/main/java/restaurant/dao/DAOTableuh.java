package restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import restaurant.context.Singleton;
import restaurant.model.Tableuh;

public class DAOTableuh implements IDAOTableuh {

	@Override
	public List<Tableuh> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Tableuh> tableuhs  = em.createQuery("from Tableuh").getResultList();
		em.close();
		return tableuhs;
	}

	@Override
	public Tableuh findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Tableuh tableuh  = em.find(Tableuh.class, id);
		em.close();
		return tableuh;
	}

	@Override
	public Tableuh save(Tableuh tableuh) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		tableuh=  em.merge(tableuh);
		em.getTransaction().commit();
		em.close();
		return tableuh;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Tableuh tableuh = em.find(Tableuh.class, id);
		em.remove(tableuh);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Tableuh tableuh) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		tableuh = em.merge(tableuh);
		em.remove(tableuh);
		em.getTransaction().commit();
		em.close();
	}

}
