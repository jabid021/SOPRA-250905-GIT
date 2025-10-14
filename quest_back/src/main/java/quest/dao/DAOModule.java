package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;


public class DAOModule implements IDAOModule{

	@Override
	public List<Module> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Module> modules  = em.createQuery("from Module").getResultList();
		em.close();
		return modules;
	}

	@Override
	public Module findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Module module  = em.find(Module.class, id);
		em.close();
		return module;
	}

	@Override
	public Module save(Module module) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		module=  em.merge(module);
		em.getTransaction().commit();
		em.close();
		return module;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Module module = em.find(Module.class, id);
		em.remove(module);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Module module) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		module = em.merge(module);
		em.remove(module);
		em.getTransaction().commit();
		em.close();
	}

}
