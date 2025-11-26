package fr.formation.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/produit")
public class ProduitResource {
    @GET
    public String findById(@QueryParam("id") int id) {
        return "Produit " + id + " !";
    }
}
