package quest.dto.response;

import quest.model.Matiere;

public class MatiereResponse {
    private int id;
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public static MatiereResponse convert(Matiere matiere) {
        MatiereResponse resp = new MatiereResponse();

        resp.setId(matiere.getId());
        resp.setLibelle(matiere.getLibelle());

        return resp;
    }
}
