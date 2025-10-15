package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
    public Filiere insert(Filiere f) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(f);
        tx.commit();
        em.close();
        return f;
    }

    @Override
    public Filiere update(Filiere f) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        f = em.merge(f);
        tx.commit();
        em.close();
        return f;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Filiere f = em.find(Filiere.class, id);
        if (f != null) {
            tx.begin();
            em.remove(f);
            tx.commit();
            em.close();
            return true;
        }
        em.close();
        return false;
    }
}
