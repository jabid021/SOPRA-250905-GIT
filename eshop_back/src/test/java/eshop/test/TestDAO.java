package eshop.test;

import java.util.List;
import java.util.Scanner;

import eshop.context.Singleton;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestDAO {

	public static String saisieString(String message) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(message);
		return monScanner.nextLine();
	}
	
	public static void main(String[] args) {
		
		String saisie = saisieString("Saisir un libelle");
		List<Produit> produits = Singleton.getInstance().getDaoProduit().findByLibLike(saisie);
		
		if(produits.isEmpty()) 
		{
			System.out.println("Aucun produit ne contient "+saisie);
		}
		for(Produit p : produits) {
			System.out.println(p);
		}
		
		System.out.println("-----------");
		
		Produit p2 = Singleton.getInstance().getDaoProduit().findByIdWithVentes(1);
		System.out.println("Liste des ventes du produit "+p2.getLibelle()+" :");
		if(p2.getVentes().isEmpty()) 
		{
			System.out.println("Aucune vente");
		}
		else 
		{
			System.out.println("Ventes total : "+p2.getVentes().size());
		}
		
		System.out.println("-----------");
		
		
		Fournisseur fournisseur = Singleton.getInstance().getDaoPersonne().findByIdWithStock(1);
		System.out.println("----Fournisseur + le stock-----");
		System.out.println("Voici le stock du fournisseur "+fournisseur.getPrenom()+" "+fournisseur.getNom()+" :");
		for(Produit p : fournisseur.getStock())
		{
			System.out.println(p.getLibelle());
		}
		
		//Comment recuperer uniquement les produit du stock d'un fournisseur : 
		System.out.println("----Uniquement le stock-----");
		for(Produit p : Singleton.getInstance().getDaoProduit().findByFournisseur(1))
		{
			System.out.println(p.getLibelle());
		}
		
		System.out.println("-----------");
		
		Client client = Singleton.getInstance().getDaoPersonne().findByIdWithAchats(2);
		System.out.println("Le client "+client.getPrenom()+" "+client.getNom()+" a effectue "+client.getAchats().size()+" achat(s)");
		
		
		
		System.out.println(Singleton.getInstance().getDaoProduit().findById(1).getVentes());
		
		
		
		
		
		Singleton.getInstance().getEmf().close();
	}

}
