package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.model.Matiere;
import quest.context.Singleton;

public class DAOMatiere implements IDAOMatiere {

    @Override
    public List<Matiere> findAll() {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        List<Matiere> liste = em.createQuery("from Matiere", Matiere.class).getResultList();
        em.close();
        return liste;
    }

    @Override
    public Matiere findById(Integer id) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        Matiere matiere = em.find(Matiere.class, id);
        em.close();
        return matiere;
    }

    @Override
    public Matiere save(Matiere matiere) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        matiere = em.merge(matiere);
        em.getTransaction().commit();
        em.close();
        return matiere;
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        Matiere matiere = em.find(Matiere.class, id);
        em.remove(matiere);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Matiere matiere) {
        deleteById(matiere.getId());
        /*EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(matiere));
        em.getTransaction().commit();
        em.close();*/
    }

}
