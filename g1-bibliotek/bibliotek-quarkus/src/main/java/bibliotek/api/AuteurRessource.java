package bibliotek.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.request.CreateOrUpdateAuteurRequest;
import bibliotek.dto.response.AuteurResponse;
import bibliotek.model.Auteur;
import bibliotek.service.AuteurService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/auteur")
public class AuteurRessource {
    private final static Logger log = LoggerFactory.getLogger(AuteurRessource.class);
    private final AuteurService service;


    public AuteurRessource(AuteurService service){
        this.service = service;
    }

    @GET
    @PermitAll
    public List<AuteurResponse> findAll() {
        log.debug("Recherche de la liste des auteurs");

        return this.service.findAll().stream()
            .map(AuteurResponse::convert)
            .toList();
    }
    
    @Path("/{id}")
    @GET
    //@RolesAllowed({"admin","user"})
    public Response findById(@PathParam("id") int id){
        log.debug("Recherche de l'auteur {}",id);

        Optional<Auteur> optAuteur = this.service.findById(id);

        if(optAuteur.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(AuteurResponse.convert(optAuteur.get())).build();
    }

    //@RolesAllowed({"admin"})
    @POST
    public Response create(@Valid CreateOrUpdateAuteurRequest request) {
        log.debug("Le nom de l'auteur est : {}", request.getNom());

        Auteur auteur = this.service.create(request);

        return Response.status(Status.CREATED)
            .entity(Map.of("id", auteur.getId()))
            .build();
    }

    //@RolesAllowed({"admin"})
    @Path("/{id}")
    @PUT
    public Response update(@PathParam("id") int id, CreateOrUpdateAuteurRequest request){
        log.debug("Le nom de l'auteur est : {}", request.getNom());

        this.service.update(id, request);

        return Response.ok(id).build();
    }

    //@RolesAllowed({"admin"})
    @Path("/{id}")
    @DELETE
    public Response deleteById(@PathParam("id") int id){
        log.debug("Suppresion de l'auteur {}", id);

        this.service.deleteById(id);

        return Response.ok(id).build();
    }
}
