package fr.formation.musique;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Guitariste {
    @Inject // Permet de demander à Quarkus d'injecter l'instance
    private Guitare guitare;

    public void jouer() {
        System.out.println("Guitariste joue " + guitare);
    }
}
