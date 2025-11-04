package eshop.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Fournisseur;
import eshop.model.Produit;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

	@GetMapping("/{nb}")
	public String demo(@PathVariable Integer nb, String login) 
	{
		return "Requête avec les valeurs "+nb+" et "+login;
	}
	
	@GetMapping("/produit")
	@ResponseBody
	public Produit produit() 
	{
		Produit produit = new Produit();
		Fournisseur fournisseur = new Fournisseur();
		produit.setFournisseur(fournisseur);
		return produit;
	}
}
