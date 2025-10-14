package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import eshop.context.Singleton;
import eshop.model.Produit;


public class DAOProduit implements IDAOProduit {

	@Override
	public List<Produit> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Produit> produits  = em.createQuery("from Produit").getResultList();
		em.close();
		return produits;
	}

	@Override
	public Produit findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit produit  = em.find(Produit.class, id);
		em.close();
		return produit;
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		produit=  em.merge(produit);
		em.getTransaction().commit();
		em.close();
		return produit;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Produit produit = em.find(Produit.class, id);
		em.remove(produit);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Produit produit) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		produit = em.merge(produit);
		em.remove(produit);
		em.getTransaction().commit();
		em.close();
	}

	
	@Override
	public List<Produit> findByLibLike(String libelle)  {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Produit> produits  = em.createQuery("SELECT p from Produit p where p.libelle like :lib").setParameter("lib", "%"+libelle+"%").getResultList();
		em.close();
		return produits;
	}
	
	@Override
	public Produit findByIdWithVentes(Integer idProduit) {
		Produit produit=null;
		try {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		produit  = em.createQuery("SELECT p from Produit p LEFT JOIN FETCH p.ventes where p.id=:id",Produit.class).setParameter("id", idProduit).getSingleResult();
		em.close();
		}catch(Exception e) {e.printStackTrace();}
		return produit;
	}

	@Override
	public List<Produit> findByFournisseur(Integer idFournisseur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Produit> produits  = em.createQuery("SELECT p from Produit p where p.fournisseur.id=:id").setParameter("id", idFournisseur).getResultList();
		em.close();
		return produits;
	}


}
