package bibliotek.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CreateOrUpdateEditeurRequest {
    
    @NotBlank
    private String nom;
    @NotBlank
    private String nationalite;

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


}
