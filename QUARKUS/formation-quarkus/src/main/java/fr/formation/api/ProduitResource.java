package fr.formation.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

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
}
