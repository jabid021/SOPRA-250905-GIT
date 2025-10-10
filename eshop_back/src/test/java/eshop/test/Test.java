package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Produit produit1 = new Produit("Formation SQL",1500);
		Produit produit2 = new Produit("Formation Spring",2500);
		
		Client client1 = new Client("Abid","Jordan",32,LocalDate.parse("1993-05-01"),"1 bis","rue de paris","75009","Paris");
		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly","AJC");
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(client1);
		em.persist(fournisseur1);
		em.persist(produit1);
		em.persist(produit2);
		

		em.getTransaction().commit();
	
	
		em.close();
		emf.close();

	}

}
