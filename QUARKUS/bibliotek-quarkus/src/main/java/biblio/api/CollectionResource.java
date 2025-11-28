package biblio.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateCollectionRequest;
import biblio.dto.response.CollectionResponse;
import biblio.dto.response.EntityCreatedResponse;
import biblio.model.Collection;
import biblio.service.CollectionService;
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

@Path("/collection")
@Authenticated
public class CollectionResource {

    private final static Logger log = LoggerFactory.getLogger(CollectionResource.class);

    private final CollectionService service;

    public CollectionResource(CollectionService service) {
        this.service = service;
    }

    @GET
    //@PermitAll
    public List<CollectionResponse> findAll() {
        log.debug("Lister les collections");

        return this.service.findAll().map(CollectionResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    //@RolesAllowed("admin")
    public Response findById(@PathParam("id") String id) {
        log.debug("Rechercher la collection {}", id);

        Optional<Collection> optCollection = this.service.findById(id);

        if (optCollection.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(CollectionResponse.convert(optCollection.get())).build();
    }

    @POST
    //@RolesAllowed("admin")
    public EntityCreatedResponse create(@Valid CreateOrUpdateCollectionRequest request) {
        log.debug("Créer la collection {}", request.getNom());

        return new EntityCreatedResponse(this.service.create(request).getId());
    }

    @Path("/{id}")
    @PUT
    //@RolesAllowed("admin")
    public EntityUpdatedResponse update(@PathParam("id") String id, @Valid CreateOrUpdateCollectionRequest request) {
        log.debug("Mettre à jour la collection {}", id);

       this.service.update(id, request);

        return new EntityUpdatedResponse(id, true);
    }

    @Path("/{id}")
    @DELETE
    //@RolesAllowed("admin")
    public boolean deleteById(@PathParam("id") String id) {
        log.debug("Supprimer la collection {}", id);

        return this.service.deleteById(id);
    }

}