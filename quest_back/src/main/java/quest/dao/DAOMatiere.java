package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Matiere;

public class DAOMatiere implements IDAOMatiere {

	@Override
	public List<Matiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Matiere> matieres  = em.createQuery("from Matiere").getResultList();
		em.close();
		return matieres;
	}

	@Override
	public Matiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Matiere matiere  = em.find(Matiere.class, id);
		em.close();
		return matiere;
	}

	@Override
	public Matiere save(Matiere matiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		matiere=  em.merge(matiere);
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
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		matiere = em.merge(matiere);
		em.remove(matiere);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Matiere> findByLibelleLike(String recherche) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Matiere> matieres  = em.createQuery("SELECT m from Matiere m where m.libelle like :recherche")
		.setParameter("recherche","%"+recherche+"%")
		.getResultList();
		em.close();
		return matieres;
	}

}
