package restaurant.test;

import restaurant.context.Singleton;
import restaurant.model.Article;
import restaurant.model.Boisson;
import restaurant.model.Client;
import restaurant.model.Compte;

public class TestDAO {

	public static void main(String[] args) {
		
		
	
		
		//Singleton.getInstance().getDaoArticle().save(new Plat("test",15,"2p"));
		
		System.out.println("----Carte complete :----");
		
		for(Article a : Singleton.getInstance().getDaoArticle().findAll()) 
		{
			System.out.println(a);
		}
		
		System.out.println("----Liste des boissons----");
		
		for(Boisson b : Singleton.getInstance().getDaoArticle().findAllBoisson()) 
		{
			System.out.println(b);
		}
		
		
		
		Compte connected = Singleton.getInstance().getDaoCompte().findByLoginAndPassword("root", "root");
		System.out.println(connected);
		
		connected = Singleton.getInstance().getDaoCompte().findByLoginAndPassword("test", "test");
		if(connected==null) 
		{
			System.out.println("identifiants invalides");
			System.out.println(connected);
		}
		
		String recherche = "A";
		System.out.println("Liste des articles contenant : "+recherche);
		
		for(Article a : Singleton.getInstance().getDaoArticle().findAllByNomLike(recherche)) 
		{
			System.out.println(a);
		}
		
		Client c = Singleton.getInstance().getDaoClient().findById(1);
		Client c2 = Singleton.getInstance().getDaoClient().findByIdWithHistoriqueResa(4);
		
		
		System.out.println(c2);
		System.out.println(c2.getHistoriqueResa());
		
		Singleton.getInstance().getEmf().close();
	}
	
	
	
	////Si obj a des associations avec d'autres objets, ils doivent aussi être managed
	
	//em.persist(obj) =>
		// uniquement pour faire un insert
		//obj devient managed par JPA
		//Si obj a des associations avec d'autres objets, ils doivent aussi être managed
	
	//copieObjet = em.merge(obj) => 
	//Update si l'id est deja present dans la bdd, sinon insert
	//obj n'est pas managed, copieObjet est managed
	
	//Object x = em.find(Objet.class,id) =>   x est managed
	
	//List<Object> xs = em.createQuery(from Object).getResultList();  => tous les objets de la liste sont managed
	
	//em.remove(obj) => obj doit etre managed
	
		

}
