package fr.formation.api;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.dto.request.CreateOrUpdateProduitRequest;
import fr.formation.dto.request.CreateProduitRequest;
import fr.formation.dto.response.ProduitResponse;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/produit")
public class ProduitResource {
    private final static Logger log = LoggerFactory.getLogger(ProduitResource.class);

    @Inject
    private ProduitService service;

    @GET
    public List<Produit> findAll() {
        log.debug("Recherche de la liste des produits");

        return this.service.findAll();
    }

    // @GET
    // public String findByIdQuery(@QueryParam("id") int id) {
    //     return "Produit " + id + " !";
    // }

    @Path("/{id}")
    @GET
    public ProduitResponse findById(@PathParam("id") int id) {
        log.debug("Recherche du produit {}", id);

        this.service.findById(id);

        return new ProduitResponse();
    }

    @Path("/create")
    @GET
    public Response createGet(@BeanParam CreateProduitRequest request) {
        // System.out.println(request.getLibelle());
        // System.out.println(request.getPrix());

        log.debug("Le nom du produit est : {}", request.getLibelle());
        log.debug("Le prix du produit est : {}", request.getPrix());

        // return Response.ok().build();

        return Response.ok("OK !").build();
    }

    @POST
    public Response create(CreateOrUpdateProduitRequest request) {
        log.debug("Le nom du produit est : {}", request.getLibelle());
        log.debug("Le prix du produit est : {}", request.getPrix());

        this.service.create(request);

        return Response.status(Status.CREATED)
            .entity(Map.of("id", 1))
            .build()
        ;
    }

    @Path("/{id}")
    @PUT
    public Response update(@PathParam("id") int id, CreateOrUpdateProduitRequest request) {
        log.debug("Le nom du produit est : {}", request.getLibelle());
        log.debug("Le prix du produit est : {}", request.getPrix());

        this.service.update(id, request);

        return Response.ok(id).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteById(@PathParam("id") int id) {
        log.debug("Suppression du produit {}", id);

        this.service.deleteById(id);

        return Response.ok(id).build();
    }
}
