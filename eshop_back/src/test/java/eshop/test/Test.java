package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Achat;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly","AJC");
		
		Produit produit1 = new Produit("Formation SQL",1500,fournisseur1);
		Produit produit2 = new Produit("Formation Spring",2500,fournisseur1);
		
		Client client1 = new Client("Abid","Jordan",32,LocalDate.parse("1993-05-01"),"1 bis","rue de paris","75009","Paris");
	
		
		//client1.getAchats().add(produit1);
		//client1.getAchats().add(produit2);
		
		Achat achat1 = new Achat(LocalDate.now(),1,client1,produit1);
		Achat achat2 = new Achat(LocalDate.now(),2,client1,produit2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		//em.persist(fournisseur1);
		
		em.persist(produit1);
		em.persist(produit2);
		
		/*em.persist(client1);
	
		em.persist(achat1);
		em.persist(achat2);
*/
		em.getTransaction().commit();
	
	
		em.close();
		emf.close();

	}

}
