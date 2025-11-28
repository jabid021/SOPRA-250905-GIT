package bibliotek.dto.response;

import bibliotek.model.Utilisateur;

public class UtilisateurResponse {
    private Integer id;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public static UtilisateurResponse convert(Utilisateur utilisateur){
        UtilisateurResponse resp = new UtilisateurResponse();

        resp.setId(utilisateur.getId());
        resp.setUsername(utilisateur.getUsername());
        resp.setPassword(utilisateur.getPassword());

        return resp;
    }
}
