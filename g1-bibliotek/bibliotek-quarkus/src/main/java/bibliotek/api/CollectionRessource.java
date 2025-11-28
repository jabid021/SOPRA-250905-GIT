package bibliotek.api;
import bibliotek.dto.request.CollectionRequest;
import bibliotek.dto.response.CollectionResponse;
import bibliotek.model.Collection;
import bibliotek.service.CollectionService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/collection")
public class CollectionRessource {
    private final static Logger log = LoggerFactory.getLogger(CollectionRessource.class);

    private final CollectionService service;

    public CollectionRessource(CollectionService service) {
        this.service = service;
    }

    @GET
    public List<CollectionResponse> findAll() {
        log.debug("Lister les collections");

        return this.service.findAll().map(CollectionResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") int id) {
        log.debug("Rechercher la collection {}", id);

        Optional<Collection> optCollection = this.service.findById(id);

        if (optCollection.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(CollectionResponse.convert(optCollection.get())).build();
    }

    @POST
    public Response create(@Valid CollectionRequest request) {
        log.debug("Créer la collection {}", request.getNom());

        Collection collection = this.service.create(request);
        
        return Response.status(Status.CREATED).entity(Map.of("id", collection.getId())).build();
    }

    @Path("/{id}")
    @PUT
    public int update(@PathParam("id") int id, @Valid CollectionRequest request) {
        log.debug("Mettre à jour la collection {}", id);

        this.service.update(id, request);

        return id;
    }

    @Path("/{id}")
    @DELETE
    public void deleteById(@PathParam("id") int id) {
        log.debug("Supprimer la collection {}", id);
        this.service.deleteById(id);
    }
}