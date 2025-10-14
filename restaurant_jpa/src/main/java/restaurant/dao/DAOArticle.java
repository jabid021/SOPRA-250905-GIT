package restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import restaurant.context.Singleton;
import restaurant.model.Article;
import restaurant.model.Boisson;
import restaurant.model.Plat;

public class DAOArticle implements IDAOArticle {

	@Override
	public List<Article> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Article> articles  = em.createQuery("from Article").getResultList();
		em.close();
		return articles;
	}

	@Override
	public Article findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Article article  = em.find(Article.class, id);
		em.close();
		return article;
	}

	@Override
	public Article save(Article article) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		article=  em.merge(article);
		em.getTransaction().commit();
		em.close();
		return article;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Article article = em.find(Article.class, id);
		em.remove(article);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Article article) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		article = em.merge(article);
		em.remove(article);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Boisson> findAllBoisson() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Boisson> articles  = em.createQuery("from Boisson").getResultList();
		em.close();
		return articles;
	}

	@Override
	public List<Plat> findAllPlat() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Plat> articles  = em.createQuery("from Plat").getResultList();
		em.close();
		return articles;
	}

	@Override
	public List<Article> findAllByNomLike(String recherche) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Article> articles  = em.createQuery("SELECT a from Article a where a.nom like :lib").setParameter("lib", "%"+recherche+"%").getResultList();
		em.close();
		return articles;
	}

	@Override
	public Long countArticleMinPrix(double prix) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Long count  = em.createQuery("SELECT COUNT(a) from Article a where prix<=:prix",Long.class).setParameter("prix", prix).getSingleResult();
		em.close();
		return count;
	}

}
