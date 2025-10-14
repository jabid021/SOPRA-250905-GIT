package eshop.test;

import java.util.List;



import eshop.context.Singleton;
import eshop.model.Achat;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;

public class TestDAO {


	
    public static void main(String[] args) {

        System.out.println("========= TEST DAO ESHOP =========");

        // -------------------- PERSONNES --------------------
        System.out.println("\n---- Liste complète des personnes ----");
        for (Personne p : Singleton.getInstance().getDaoPersonne().findAll()) {
            System.out.println(p);
        }

        System.out.println("\n---- Liste des clients ----");
        for (Client c : Singleton.getInstance().getDaoPersonne().findAllClient()) {
            System.out.println(c);
        }

        System.out.println("\n---- Liste des fournisseurs ----");
        for (Fournisseur f : Singleton.getInstance().getDaoPersonne().findAllFournisseur()) {
            System.out.println(f);
        }
        
        // Test : trouver un client avec ses achats
        System.out.println("\n---- Client avec ses achats ----");
        Client clientAvecAchats = Singleton.getInstance().getDaoPersonne().findByIdWithAchats(2);
        if (clientAvecAchats != null) {
            System.out.println(clientAvecAchats);
            System.out.println(clientAvecAchats.getAchats());
        } else {
            System.out.println("Aucun client trouvé avec cet ID");
        }
        

        // Test : trouver un fournisseur avec son stock
        System.out.println("\n---- Fournisseur avec son stock ----");
        Fournisseur fournisseurAvecStock = Singleton.getInstance().getDaoPersonne().findByIdWithStock(1);
        if (fournisseurAvecStock != null) {
            System.out.println(fournisseurAvecStock);
            System.out.println(fournisseurAvecStock.getStock());
        } else {
            System.out.println("Aucun fournisseur trouvé avec cet ID");
        }

        // -------------------- PRODUITS --------------------
        System.out.println("\n---- Liste complète des produits ----");
        for (Produit pr : Singleton.getInstance().getDaoProduit().findAll()) {
            System.out.println(pr);
        }
        String libelle = "Forma";
		System.out.println("Liste des produits contenant : "+libelle);
		
		for(Produit p : Singleton.getInstance().getDaoProduit().findByLibLike(libelle)) 
		{
			System.out.println(p);
		}

        // -------------------- ACHATS --------------------
        System.out.println("\n---- Liste complète des achats ----");
        for (Achat a : Singleton.getInstance().getDaoAchat().findAll()) {
            System.out.println(a);
        }
        System.out.println("\n---- Liste complète des ventes pour un produit ----");
        Produit produit = Singleton.getInstance().getDaoProduit().findByIdWithVentes(2);
		
		System.out.println(produit);
		System.out.println(produit.getVentes());
        
        


        // -------------------- FIN DU TEST --------------------
        Singleton.getInstance().getEmf().close();
        System.out.println("\n========= FIN DU TEST =========");
    }

}
