package bibliotek.dto.response;

import bibliotek.model.Auteur;

public class AuteurResponse {

    private int id;
    private String nom;
    private String prenom;
    private String nationalite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static AuteurResponse convert(Auteur auteur){
        AuteurResponse resp = new AuteurResponse();

        resp.setId(auteur.getId());
        resp.setNationalite(auteur.getNationalite());
        resp.setNom(auteur.getNom());
        resp.setPrenom(auteur.getPrenom());

        return resp;
    }
}
