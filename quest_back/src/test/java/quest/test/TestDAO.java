package quest.test;


import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Ordinateur;
import quest.model.Personne;
import quest.model.Module;

public class TestDAO {
	public static void main(String[] args) {

        System.out.println("========= TEST DAO Quest =========");

        // -------------------- PERSONNES --------------------
        System.out.println("\n---- Liste complète des personnes ----");
        for (Personne p : Singleton.getInstance().getDaoPersonne().findAll()) {
            System.out.println(p);
        }
        
        System.out.println("\n---- Personne avec ID ----");
        Personne personne = Singleton.getInstance().getDaoPersonne().findById(2);
        if (personne != null) {
            System.out.println(personne);
        } else {
            System.out.println("Aucune personne trouvée avec cet ID");
        }
        
        System.out.println("========= TEST DAO Ordinateur =========");

        // -------------------- ordinateurs --------------------
        System.out.println("\n---- Liste complète des ordinateurs ----");
        for (Ordinateur o : Singleton.getInstance().getDaoOrdinateur().findAll()) {
            System.out.println(o);
        }
        
        System.out.println("\n---- Ordinateur avec ID ----");
        Ordinateur ordinateur = Singleton.getInstance().getDaoOrdinateur().findById(2);
        if (ordinateur != null) {
            System.out.println(ordinateur);
        } else {
            System.out.println("Aucun ordinateur trouvé avec cet ID");
        }
        
        System.out.println("========= TEST DAO Module =========");

        // -------------------- Modules --------------------
        System.out.println("\n---- Liste complète des modules ----");
        for (Module mo : Singleton.getInstance().getDaoModule().findAll()) {
            System.out.println(mo);
        }
        
        System.out.println("\n---- Module avec ID ----");
        Module module = Singleton.getInstance().getDaoModule().findById(2);
        if (module != null) {
            System.out.println(module);
        } else {
            System.out.println("Aucun module trouvé avec cet ID");
        }
        
        
     // -------------------- Filieres --------------------
        System.out.println("\n---- Liste complète des filieres ----");
        for (Filiere f : Singleton.getInstance().getDaoFiliere().findAll()) {
            System.out.println(f);
        }
        
        System.out.println("\n---- Filiere avec ID ----");
        Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(2);
        if (filiere != null) {
            System.out.println(filiere);
        } else {
            System.out.println("Aucune filiere trouvée avec cet ID");
        }
        
	}
}
