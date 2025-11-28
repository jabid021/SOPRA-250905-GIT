package bibliotek.api;

import bibliotek.dto.request.AuthRequest;
import bibliotek.dto.response.AuthResponse;
import io.quarkus.security.credential.PasswordCredential;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.request.UsernamePasswordAuthenticationRequest;
import io.quarkus.security.jpa.runtime.JpaIdentityProvider;
import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/auth")
public class JwtRessource {
    @Inject
    private JpaIdentityProvider identityProvider;

    @Inject
    private EntityManager entityManager;

    @POST
    public AuthResponse auth(AuthRequest request) {
        UsernamePasswordAuthenticationRequest authenticationRequest = new UsernamePasswordAuthenticationRequest(
            request.getUsername(), 
            new PasswordCredential(request.getPassword().toCharArray()
        ));

        SecurityIdentity identity = this.identityProvider.authenticate(this.entityManager, authenticationRequest);

        String jwt = Jwt.issuer("bibliotek-issuer")
            .upn(request.getUsername())
            .groups(identity.getRoles())
            .sign()
        ;
        
        return new AuthResponse(jwt);
    }
}
