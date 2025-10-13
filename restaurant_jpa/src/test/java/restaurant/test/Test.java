package restaurant.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import restaurant.model.Achat;
import restaurant.model.Admin;
import restaurant.model.Boisson;
import restaurant.model.Client;
import restaurant.model.Employe;
import restaurant.model.Genre;
import restaurant.model.Plat;
import restaurant.model.Reservation;
import restaurant.model.Tableuh;

public class Test {

	public static void main(String[] args) {
		Boisson boisson1 = new Boisson("Fanta",38.55,33);
		Boisson boisson2 = new Boisson("Eau",1.20,100);
		
		Plat plat1 = new Plat("Pizza",15.80,"8 parts");
		Plat plat2=new Plat("Soupe",250,"1 personne");
		
		Employe emp1 = new Employe("login","password","Doe","John",LocalDate.parse("2020-01-01"),"1 bis","Rue de Paris","75009","Paris");
		Admin admin = new Admin("root","root");
		Client client1 = new Client("Abid","Jordan",Genre.homme);
		Client client2 = new Client("Doe","Jane",Genre.femme);

		
		//On ne gere plus les achats du client via sa liste, mais chaque achat independamment
		//Collections.addAll(client1.getAchats(), boisson1,boisson2,plat1);
		
		
		Achat achat1 = new Achat(LocalDate.now(),client1,boisson1);
		Achat achat2 = new Achat(LocalDate.now(),client1,boisson2);
		Achat achat3 = new Achat(LocalDate.now(),client1,plat1);
		
		Tableuh table1 = new Tableuh(6);
		Tableuh table2 = new Tableuh(12);
		Tableuh table3 = new Tableuh(4);
		
		

		Reservation resa1 = new Reservation(LocalDateTime.now(), 2, table3, client2);
		Reservation resa2 = new Reservation(LocalDateTime.now(), 5, table1, client1);
		
		table3.setServeur(emp1);
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();
		
		/*em.getTransaction().begin(); 
		
		em.persist(boisson1);
		em.persist(boisson2);
		
		em.persist(plat1);
		em.persist(plat2);
	
		
		em.persist(emp1);
		em.persist(client1);
		em.persist(client2 );
		em.persist(admin);
		
		em.persist(table1);
		em.persist(table2);
		em.persist(table3);
		
		em.persist(resa1);
		em.persist(resa2);
		
		
		em.persist(achat1);
		em.persist(achat2);
		em.persist(achat3);
		
		em.getTransaction().commit();*/

		em.close();
		emf.close();
		
		//SELECT ID = > em.find(Boisson.class,x)
		//SELECT ALL => em.createQuery("from Boisson").getResultList()
		//INSERT => em.persist(boisson1)
		//UPDATE => em.merge(boisson1)
		//DELETE => em.remove(boisson1);

	}

}
