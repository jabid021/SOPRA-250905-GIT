package restaurant.test;

import restaurant.context.Singleton;
import restaurant.model.Client;
import restaurant.model.Genre;

public class TestHeritage {

	
	public static void main(String[] args) {
		
		///DEMO SINGLE TABLE
		//Singleton.getInstance().getDaoCompte().findAll();
		//System.out.println("-------");
		//Singleton.getInstance().getDaoCompte().findAllAdmin();
		
		
		///DEMO JOINED
		//Singleton.getInstance().getDaoArticle().findAll();
		//System.out.println("-------");
		//Singleton.getInstance().getDaoArticle().findAllBoisson();
		
		
		///DEMO TABLE PER CLASS
		//	Singleton.getInstance().getDaoVaisselle().findAll();
		//System.out.println("-------");
		//Singleton.getInstance().getDaoVaisselle().findAllAssiette();
		
		
		
		Client client1 = Singleton.getInstance().getDaoClient().findById(1);
	
		
		
		Client client2 = Singleton.getInstance().getDaoClient().findById(1);
		
		client1.setCivilite(Genre.femme);
		client2.setNom("TOTO");
		
		Singleton.getInstance().getDaoClient().save(client1);
		
		//Grace à l'attribut "@Version" ce save ne marchera pas car la ligne du client a ete modif en bdd depuis le find à la ligne 35.
		Singleton.getInstance().getDaoClient().save(client2);
		
		
		
		System.out.println(Singleton.getInstance().getDaoClient().findById(1));
		
		Singleton.getInstance().getEmf().close();
	}
}
