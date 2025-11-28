package bibliotek.api;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.security.Authenticated;
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

import bibliotek.dto.request.CreateOrUpdateEditeurRequest;
import bibliotek.dto.response.AuteurResponse;
import bibliotek.dto.response.EditeurResponse;
import bibliotek.model.Auteur;
import bibliotek.model.Editeur;
import bibliotek.service.EditeurService;


@Path("/editeurs")
public class EditeurResource {
    
    private final static Logger log = LoggerFactory.getLogger(EditeurResource.class);

    private final EditeurService service;

    public EditeurResource(EditeurService service) {
        this.service = service;
    }

    //public List<Editeur> findAll()
    //public Editeur findById(int id)
    //public Editeur create(CreateOrUpdateEditeurRequest request)
    //public Editeur update(int id, CreateOrUpdateEditeurRequest request)

    @GET
    @PermitAll
    public List<EditeurResponse> findAll() {
        log.debug("findAll des editeurs");

        return this.service.findAll().stream()
            .map(EditeurResponse::convert)
            .toList();
    }

    @Path("/{id}")
    @GET
    //@RolesAllowed({"admin","user"})
    public Response findById(@PathParam("id") int id) {
        log.debug("findById de l'éditeur {}", id);

        Optional<Editeur> optEditeur = this.service.findById(id);

        if(optEditeur.isEmpty()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(EditeurResponse.convert(optEditeur.get())).build();
    }

    //@RolesAllowed({"admin"})
    @POST
    public Response create(@Valid CreateOrUpdateEditeurRequest request) {
        log.debug("create de l'éditeur {}", request.getNom());

        Editeur editeur = this.service.create(request);

        return Response.status(Status.CREATED).entity(EditeurResponse.convert(editeur)).build();
    }

    //@RolesAllowed({"admin"})
    @Path("/{id}")
    @PUT
    public Response update(@PathParam("id") int id, @Valid CreateOrUpdateEditeurRequest request) {
        log.debug("update de l'éditeur {}", id);

        Editeur editeur = this.service.update(id, request);

        return Response.ok(EditeurResponse.convert(editeur)).build();
    }

    //@RolesAllowed({"admin"})
    @Path("/{id}")
    @DELETE
    public Response deleteById(@PathParam("id") int id) {
        log.debug("deleteById de l'éditeur {}", id);

        this.service.deleteById(id);

        return Response.noContent().build();
    }

}
