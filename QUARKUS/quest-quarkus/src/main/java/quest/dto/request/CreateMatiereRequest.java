package quest.dto.request;

import jakarta.ws.rs.QueryParam;

public class CreateMatiereRequest {
    @QueryParam("libelle")
    private String libelle;

   
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}
