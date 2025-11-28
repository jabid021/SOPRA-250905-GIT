package biblio.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateEditeurRequest;
import biblio.dto.response.EditeurResponse;
import biblio.dto.response.EntityCreatedResponse;
import biblio.model.Editeur;
import biblio.service.EditeurService;
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


@Path("/editeur")
@Authenticated
public class EditeurRessource {
    private final static Logger log = LoggerFactory.getLogger(EditeurRessource.class);

    private final EditeurService service;

    public EditeurRessource(EditeurService service) {
        this.service = service;
    }

    @GET
    public List<EditeurResponse> findAll() {
        log.debug("Lister les editeurs");

        return this.service.findAll().map(EditeurResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") String id) {
        log.debug("Rechercher la editeur {}", id);

        Optional<Editeur> optEditeur = this.service.findById(id);

        if (optEditeur.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(EditeurResponse.convert(optEditeur.get())).build();
    }

    @POST
    public EntityCreatedResponse create(@Valid CreateOrUpdateEditeurRequest request) {
        log.debug("Créer la editeur {}", request.getNom());

        return new EntityCreatedResponse(this.service.create(request).getId());
    }

    @Path("/{id}")
    @PUT
    public EntityUpdatedResponse update(@PathParam("id") String id, @Valid CreateOrUpdateEditeurRequest request) {
        log.debug("Mettre à jour la editeur {}", id);

        this.service.update(id, request);

        return new EntityUpdatedResponse(id, true);
    }

    @Path("/{id}")
    @DELETE
    public boolean deleteById(@PathParam("id") String id) {
        log.debug("Supprimer la editeur {}", id);

        return this.service.deleteById(id);
    }
}
