package quest.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import quest.dto.request.CreateOrUpdateMatiereRequest;
import quest.dto.response.MatiereResponse;
import quest.model.Matiere;
import quest.service.MatiereService;

@Path("/matiere")
@Authenticated
public class MatiereResource {
    private final static Logger log = LoggerFactory.getLogger(MatiereResource.class);

    private final MatiereService service;

    public MatiereResource(MatiereService service) {
        this.service = service;
    }

    @GET
    public List<MatiereResponse> findAll() {
        log.debug("Lister les matières");

        return this.service.findAll().map(MatiereResponse::convert).toList();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") int id) {
        log.debug("Rechercher la matière {}", id);

        Optional<Matiere> optMatiere = this.service.findById(id);

        if (optMatiere.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(MatiereResponse.convert(optMatiere.get())).build();
    }

    @POST
    public int create(@Valid CreateOrUpdateMatiereRequest request) {
        log.debug("Créer la matière {}", request.getLibelle());

        return this.service.create(request).getId();
    }

    @Path("/{id}")
    @PUT
    public int update(@PathParam("id") int id, @Valid CreateOrUpdateMatiereRequest request) {
        log.debug("Mettre à jour la matière {}", id);

        this.service.update(id, request);

        return id;
    }

    @Path("/{id}")
    @DELETE
    public boolean deleteById(@PathParam("id") int id) {
        log.debug("Supprimer la matière {}", id);

        return this.service.deleteById(id);
    }
}
