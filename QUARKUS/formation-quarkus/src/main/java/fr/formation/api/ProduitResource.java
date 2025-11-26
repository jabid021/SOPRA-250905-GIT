package fr.formation.api;

import fr.formation.dto.request.CreateProduitRequest;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/produit")
public class ProduitResource {
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
        System.out.println(request.getLibelle());
        System.out.println(request.getPrix());

        // return Response.ok().build();

        return Response.ok("OK !").build();
    }
}
