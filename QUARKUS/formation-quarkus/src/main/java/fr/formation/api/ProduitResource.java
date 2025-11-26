package fr.formation.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.dto.request.CreateProduitRequest;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/produit")
public class ProduitResource {
    private final static Logger log = LoggerFactory.getLogger(ProduitResource.class);

    @GET
    public String findByIdQuery(@QueryParam("id") int id) {
        return "Produit " + id + " !";
    }


    @Path("/{id}")
    @GET
    public String findByIdPath(@PathParam("id") int id) {
        return "Produit " + id + " !";
    }

    @Path("/create")
    @GET
    public Response create(@BeanParam CreateProduitRequest request) {
        // System.out.println(request.getLibelle());
        // System.out.println(request.getPrix());

        log.debug("Le nom du produit est : {}", request.getLibelle());
        log.debug("Le prix du produit est : {}", request.getPrix());

        // return Response.ok().build();

        return Response.ok("OK !").build();
    }
}
