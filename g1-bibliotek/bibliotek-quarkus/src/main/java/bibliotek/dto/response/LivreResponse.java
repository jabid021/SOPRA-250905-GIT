package bibliotek.dto.response;

import java.time.LocalDate;

import bibliotek.model.Livre;

public class LivreResponse {

    private int id;
    private String nom;
    private String resume;
    private LocalDate publication;

    private int auteurId;
    private int editeurId;
    private int collectionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

    public int getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(int auteurId) {
        this.auteurId = auteurId;
    }

    public int getEditeurId() {
        return editeurId;
    }

    public void setEditeurId(int editeurId) {
        this.editeurId = editeurId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public static LivreResponse convert(Livre livre) {
        LivreResponse resp = new LivreResponse();

        resp.setId(livre.getId());
        resp.setNom(livre.getNom());
        resp.setResume(livre.getResume());
        resp.setPublication(livre.getPublication());
        resp.setAuteurId(livre.getAuteur().getId());
        resp.setEditeurId(livre.getEditeur().getId());

        if (livre.getCollection() != null) {
            resp.setCollectionId(livre.getCollection().getId());
        }

        return resp;
    }
}

