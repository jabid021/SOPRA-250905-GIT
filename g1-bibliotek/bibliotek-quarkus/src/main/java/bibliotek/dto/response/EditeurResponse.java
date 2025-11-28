package bibliotek.dto.response;

import bibliotek.model.Editeur;

public class EditeurResponse {

    private int id;
    private String nom;
    private String nationalite;

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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public static EditeurResponse convert(Editeur editeur) {
        EditeurResponse resp = new EditeurResponse();

        resp.setId(editeur.getId());
        resp.setNom(editeur.getNom());
        resp.setNationalite(editeur.getNationalite());

        return resp;
    }
    
}
