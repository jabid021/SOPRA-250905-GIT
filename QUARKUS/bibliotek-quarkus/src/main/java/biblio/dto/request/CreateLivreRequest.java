package biblio.dto.request;

import java.time.LocalDate;

import jakarta.ws.rs.QueryParam;

public class CreateLivreRequest {
    @QueryParam("nom")
    private String nom;
    @QueryParam("resume")
    private String resume;
    @QueryParam("publication")
    private LocalDate publication;
    @QueryParam("auteurId")
    private String auteurId;
    @QueryParam("editeurId")
    private String editeurId;
    @QueryParam("collectionId")
    private String collectionId;

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

    public String getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(String auteurId) {
        this.auteurId = auteurId;
    }

    public String getEditeurId() {
        return editeurId;
    }

    public void setEditeurId(String editeurId) {
        this.editeurId = editeurId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

}
