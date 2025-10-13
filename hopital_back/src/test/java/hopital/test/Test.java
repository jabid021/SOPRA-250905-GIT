package hopital.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;

public class Test {

	public static IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	public static IDAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	public static IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();

	static Compte connected;
	static LinkedList<Patient> fileAttente = new LinkedList();
	static boolean pause=false;
	static File fichier = new File("fileAttente.txt");


	public static int saisieInt(String message) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(message);
		return monScanner.nextInt();
	}
	public static double saisieDouble(String message) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(message);
		return monScanner.nextDouble();
	}
	public static String saisieString(String message) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(message);
		return monScanner.nextLine();
	}
	public static boolean saisieBoolean(String message) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(message);
		return monScanner.nextBoolean();
	}




	public static void seConnecter() {
		String login = saisieString("Saisir login");
		String password = saisieString("Saisir password");
		connected = daoCompte.findByLoginAndPassword(login, password);

		if(connected==null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof Secretaire) 
		{
			if(pause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}
		else if(connected instanceof Medecin) 
		{
			int salle=saisieInt("Saisir votre salle");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}


	}



	public static void menuSecretaire() {
		System.out.println("\n----Menu Secretaire-------");
		System.out.println("1 - Accueillir patient");
		System.out.println("2 - Lister les visites d'un patient");
		System.out.println("3 - Afficher la file d'attente");
		System.out.println("4 - Supprimer un patient");
		System.out.println("5 - Partir en pause");
		System.out.println("6 - Se deconnecter");
		int choix = saisieInt("Choisir votre menue");
		switch(choix) 
		{
		case 1 : accueillirPatient();break;
		case 2 : afficherVisitesPatient();break;
		case 3 : afficherFile();break;
		case 4 : supprimerPatient();break;
		case 5 : partirEnPause();break;
		case 6 : seDeconnecter();break;
		}

		menuSecretaire();
	}



	public static void partirEnPause() {
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(fileAttente);
			fileAttente.clear();
			pause=true;


			oos.close();
			fos.close();

			menuSecretairePause();
		}catch(Exception e) {e.printStackTrace();}
	}

	public static void afficherFile() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else {
			System.out.println("Voici l'etat de la file d'attente : ");
			for(Patient p : fileAttente) 
			{
				System.out.println(p);
			}
			if(connected instanceof Medecin) 
			{
				Patient suivant = fileAttente.peekFirst();
				System.out.println("Le prochain patient est : "+suivant.getPrenom()+" "+suivant.getNom());
			}
		}

	}
	public static void afficherVisitesPatient() {
		int id = saisieInt("Saisir l'id du patient pour afficher son historique de visite");
		Patient patient = daoPatient.findById(id);

		if(patient==null) 
		{
			System.out.println("Aucun patient n'a l'id "+id);
		}
		else 
		{
			List<Visite> historiquePatient = daoVisite.findAllByIdPatient(id);
			if(historiquePatient.isEmpty()) 
			{
				System.out.println("Aucune visite pour le patient "+patient.getPrenom()+" "+patient.getNom()+" "+id);
			}
			else 
			{
				System.out.println("Historique des visites pour le patient "+patient.getPrenom()+" "+patient.getNom()+" "+id);
				for(Visite v : historiquePatient) 
				{
					System.out.println(v);
				}
			}
		}


	}
	public static void accueillirPatient() {
		int id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);

		if(patient==null) 
		{
			System.out.println("Inscription d'un nouveau patient : ");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			patient = new Patient(id, nom, prenom);
			daoPatient.insert(patient);
		}
		System.out.println("Ajout du patient dans la file d'attente "+patient+"");
		fileAttente.add(patient);
	}


	public static void supprimerPatient() {

		//La suppression d'un patient implique de gerer ses lignes de visite en cascade
		System.out.println("Liste des patients");
		for(Patient p : daoPatient.findAll()) 
		{
			System.out.println(p);
		}
		int id = saisieInt("Saisir l'id du patient à supprimer");
		List<Visite> visitesDuPatient = daoVisite.findAllByIdPatient(id);

		for(Visite v : visitesDuPatient) 
		{
			//Pour pouvoir delete le patient, on va delete toutes ses visites
			//daoVisite.delete(v.getNumero());

			//Si on veut garder une trace de toutes les visites, on passe à null l'id du patient
			v.setPatient(null);
			daoVisite.update(v);
		}
		daoPatient.delete(id);
	}

	public static void menuSecretairePause() {
		System.out.println("\n----Menu Secretaire en Pause-------");
		System.out.println("1 - Revenir de pause");
		System.out.println("2 - Se deconnecter");
		int choix = saisieInt("Choisir votre menue");
		switch(choix) 
		{
		case 1 : revenirDePause();break;
		case 2 : seDeconnecter();break;
		}
		menuSecretairePause();
	}

	public static void revenirDePause() {
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);

			fileAttente= (LinkedList<Patient>) ois.readObject();
			pause=false;


			ois.close();
			fis.close();

			menuSecretaire();
		}catch(Exception e) {e.printStackTrace();}

	}

	public static void menuMedecin() {
		System.out.println("\n----Menu Medecin-------");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher la file d'attente");
		System.out.println("3 - Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");
		int choix = saisieInt("Choisir votre menue");
		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFile();break;
		case 3 : sauvegarderVisites();break;
		case 4 :seDeconnecter();break;
		}
		menuMedecin();
	}


	public static void recevoirPatient() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Patient patient = fileAttente.poll();
			Medecin medecin = (Medecin) connected;
			medecin.getConsultations().add(new Visite(patient,medecin));

			if(medecin.getConsultations().size()==3) 
			{
				System.out.println("Cumul de 3 visites, sauvegarde auto :");
				sauvegarderVisites();
			}
		}
	}

	public static void sauvegarderVisites() {
		Medecin medecin = (Medecin) connected;
		if(medecin.getConsultations().isEmpty()) 
		{
			System.out.println("Vous n'avez pas de visite à sauvegarder");
		}
		else 
		{
			for(Visite v : medecin.getConsultations()) 
			{
				daoVisite.insert(v);
				System.out.println("Sauvegarde "+v);
			}
			medecin.getConsultations().clear();
		}
	}
	public static void seDeconnecter() 
	{
		connected=null;
		menuPrincipal();
	}

	public static void menuPrincipal() {
		System.out.println("\n-----HOPITAL---------");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Stop");
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}
		menuPrincipal();
	}



	public static void main(String[] args) {
		menuPrincipal();

	}

}
