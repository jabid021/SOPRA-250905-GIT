package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Produit produit1 = new Produit("Formation SQL",1500);
		Produit produit2 = new Produit("Formation Spring",2500);
		
		Personne client1 = new Personne("Abid","Jordan");
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(client1);
		em.persist(produit1);
		em.persist(produit2);
		

		em.getTransaction().commit();
	
	
		em.close();
		emf.close();

	}

}
