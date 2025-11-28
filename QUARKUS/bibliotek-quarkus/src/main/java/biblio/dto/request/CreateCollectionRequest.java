package biblio.dto.request;

import jakarta.ws.rs.QueryParam;

public class CreateCollectionRequest {
    @QueryParam("nom")
     private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


   
    


}
