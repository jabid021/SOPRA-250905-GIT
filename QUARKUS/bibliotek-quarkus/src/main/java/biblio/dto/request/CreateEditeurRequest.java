package biblio.dto.request;

import biblio.enumerator.NationaliteEnum;
import jakarta.ws.rs.QueryParam;


public class CreateEditeurRequest {
    @QueryParam("nom")
     private String nom;

    @QueryParam("pays")
    private NationaliteEnum pays;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NationaliteEnum getPays() {
        return pays;
    }

    public void setPays(NationaliteEnum pays) {
        this.pays = pays;
    }

   
    


}
