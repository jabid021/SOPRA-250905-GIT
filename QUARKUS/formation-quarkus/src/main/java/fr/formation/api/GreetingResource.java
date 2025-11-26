package fr.formation.api;

import fr.formation.dto.response.ExempleResponse;
import fr.formation.musique.Guitariste;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    // @Inject
    private final Guitariste guitariste;

    public GreetingResource(Guitariste guitariste) {
        this.guitariste = guitariste;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        this.guitariste.jouer();

        return "Hello from Quarkus REST";
    }

    @Path("/demo")
    @GET
    public Guitariste demo() {
        return this.guitariste;
    }

    @Path("/exemple")
    @GET
    public ExempleResponse exemple() {
        return new ExempleResponse("Coucou !");
    }
}
