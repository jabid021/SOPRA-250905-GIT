package biblio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.SubscribeRequest;
import biblio.model.Utilisateur;
import biblio.repo.UtilisateurRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.transaction.Transactional;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped

public class UtilisateurService {
    private final static Logger log = LoggerFactory.getLogger(UtilisateurService.class);

    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Utilisateur subscribe(SubscribeRequest request) {
        log.debug("Ajout de l'utilisateur {}", request.username());

        Utilisateur utilisateur = new Utilisateur();
        String hashedPassword = BcryptUtil.bcryptHash(request.password());

        utilisateur.setUsername(request.username());
        utilisateur.setPassword(hashedPassword);
        utilisateur.setAdmin(true);

        this.repository.persist(utilisateur);

        return utilisateur;
    }
}
