package biblio.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateAuteurRequest;
import biblio.dto.response.AuteurResponse;
import biblio.model.Auteur;
import biblio.service.AuteurService;
import io.quarkus.security.Authenticated;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import biblio.dto.response.*;

@Path("/auteur")
@Authenticated
public class AuteurRessource {
    private final static Logger log = LoggerFactory.getLogger(AuteurRessource.class);

    private final AuteurService service;

    public AuteurRessource(AuteurService service) {
        this.service = service;
    }

    @GET
    public List<AuteurResponse> findAll() {
        log.debug("Lister les auteurs");

        return this.service.findAll().map(AuteurResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") String id) {
        log.debug("Rechercher la auteur {}", id);

        Optional<Auteur> optAuteur = this.service.findById(id);

        if (optAuteur.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(AuteurResponse.convert(optAuteur.get())).build();
    }

    @POST
    public EntityCreatedResponse create(@Valid CreateOrUpdateAuteurRequest request) {
        log.debug("Créer la auteur {}", request.getNom());

        return new EntityCreatedResponse(this.service.create(request).getId());
    }

    @Path("/{id}")
    @PUT
    public EntityUpdatedResponse update(@PathParam("id") String id, @Valid CreateOrUpdateAuteurRequest request) {
        log.debug("Mettre à jour la auteur {}", id);

        this.service.update(id, request);

        return new EntityUpdatedResponse(id, true);
    }

    @Path("/{id}")
    @DELETE
    public boolean deleteById(@PathParam("id") String id) {
        log.debug("Supprimer la auteur {}", id);

        return this.service.deleteById(id);
    }
}
