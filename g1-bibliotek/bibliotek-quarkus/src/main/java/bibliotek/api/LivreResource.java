package bibliotek.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.request.CreateOrUpdateLivreRequest;
import bibliotek.dto.response.LivreResponse;
import bibliotek.model.Livre;
import bibliotek.service.LivreService;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/livre")
public class LivreResource {

    private static final Logger log = LoggerFactory.getLogger(LivreResource.class);

    private final LivreService service;

    public LivreResource(LivreService service) {
        this.service = service;
    }

    @GET
    public List<LivreResponse> findAll() {
        log.debug("Recherche de la liste des livres");

        return service.findAll()
                .map(LivreResponse::convert)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        log.debug("Recherche du livre {}", id);

        Optional<Livre> optLivre = this.service.findById(id);

        if (optLivre.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(LivreResponse.convert(optLivre.get())).build();
    }

    @POST
    public Response create(@Valid CreateOrUpdateLivreRequest request) {
        log.debug("Création d’un livre {}", request.getNom());

        Livre livre = this.service.create(request);

        return Response.status(Status.CREATED)
                .entity(Map.of("id", livre.getId()))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id,
                           @Valid CreateOrUpdateLivreRequest request) {
        log.debug("Mise à jour du livre {} - nouveau nom : {}", id, request.getNom());

        this.service.update(id, request);

        return Response.ok(id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        log.debug("Suppression du livre {}", id);

        this.service.deleteById(id);

        return Response.ok(id).build();
    }
}
