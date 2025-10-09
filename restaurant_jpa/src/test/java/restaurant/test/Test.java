package restaurant.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import restaurant.model.Boisson;
import restaurant.model.Client;
import restaurant.model.Employe;
import restaurant.model.Genre;

public class Test {

	public static void main(String[] args) {
		Boisson boisson1 = new Boisson("Fanta",3.50,33);
		Boisson boisson2 = new Boisson("Eau",1.20,100);
		
		Employe emp1 = new Employe("Doe","John",LocalDate.parse("2020-01-01"),"1 bis","Rue de Paris","75009","Paris");
		
		Client client1 = new Client("Abid","Jordan",Genre.homme);
		Client client2 = new Client("Doe","Jane",Genre.femme);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(boisson1);
		em.persist(boisson2);
		em.persist(emp1);
		em.persist(client1);
		em.persist(client2 );
		
		em.getTransaction().commit();
	
	
		em.close();
		emf.close();
		
		//SELECT ID = > em.find(Boisson.class,x)
		//SELECT ALL => em.createQuery("from Boisson").getResultList()
		//INSERT => em.persist(boisson1)
		//UPDATE => em.merge(boisson1)
		//DELETE => em.remove(boisson1);

	}

}
