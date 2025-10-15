package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Filiere;

public class DAOFiliere implements IDAOFiliere {

    @Override
    public Filiere findById(Integer id) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        Filiere f = em.find(Filiere.class, id);
        em.close();
        return f;
    }

    @Override
    public List<Filiere> findAll() {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        List<Filiere> filieres = em.createQuery("from Filiere", Filiere.class).getResultList();
        em.close();
        return filieres;
    }

    @Override
    public Filiere save(Filiere filiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		filiere = em.merge(filiere);
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
