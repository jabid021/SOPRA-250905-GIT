package fr.formation.musique;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Ca permet de donner la gestion de l'instance à Quarkus
public class Guitare {
    @Override
    public String toString() {
        return "GLINK GLINK GLINK";
    }
}
