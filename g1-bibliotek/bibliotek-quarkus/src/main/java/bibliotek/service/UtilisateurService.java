package bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.request.SubscribeRequest;
import bibliotek.model.Utilisateur;
import bibliotek.repository.UtilisateurRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UtilisateurService {
    private final static Logger log = LoggerFactory.getLogger(UtilisateurService.class);
    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository){
        this.repository = repository;
    }

    public List<Utilisateur> findAll() {
        log.debug("Liste des Utilisateurs");
        return this.repository.listAll();
        // == return this.repository.findAll().list()
    }

    @Transactional
    public Utilisateur create(SubscribeRequest request) {
        log.debug("Création de l'utilisateur {}", request.username());
        Utilisateur utilisateur = new Utilisateur();
        String password = BcryptUtil.bcryptHash(request.password());
        log.debug(request.password() + " --> " + password);

        utilisateur.setUsername(request.username());
        utilisateur.setPassword(password);
        utilisateur.setAdmin(false);

        this.repository.persist(utilisateur);

        return utilisateur;
    }

}
