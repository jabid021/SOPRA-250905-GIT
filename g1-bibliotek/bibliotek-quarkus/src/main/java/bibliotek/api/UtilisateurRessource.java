package bibliotek.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import bibliotek.dto.request.SubscribeRequest;
import bibliotek.dto.response.UtilisateurResponse;
import bibliotek.model.Utilisateur;
import bibliotek.service.UtilisateurService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/inscription")
public class UtilisateurRessource {
    private final static Logger log = org.slf4j.LoggerFactory.getLogger(UtilisateurRessource.class);    

    @Inject
    private UtilisateurService service;

    @POST
    public Response inscription(SubscribeRequest request){
        log.debug("Username est : {}", request.username());
        log.debug("Password est : {}", request.password());

        Utilisateur utilisateur = this.service.create(request);
        return Response.status(Status.CREATED)
            .entity(Map.of("id", utilisateur.getId()))
            .build();
    }

    @GET
    public List<UtilisateurResponse> findAll() {
        log.debug("recherche de tous les Utilisateurs ");
        return this.service.findAll().stream()
                .map(UtilisateurResponse::convert)
                .toList();
    }

}

