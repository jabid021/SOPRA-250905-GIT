package biblio.dto.request;

import biblio.enumerator.NationaliteEnum;
import jakarta.ws.rs.QueryParam;


public class CreateAuteurRequest {
    @QueryParam("nom")
     private String nom;

    @QueryParam("prenom")
    private String prenom;
    @QueryParam("nationalite")
    private NationaliteEnum nationalite;

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
    public NationaliteEnum getNationalite() {
        return nationalite;
    }
    public void setNationalite(NationaliteEnum nationalite) {
        this.nationalite = nationalite;
    }


   
    


}
