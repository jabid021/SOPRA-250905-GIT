package biblio.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateAuteurRequest;
import biblio.model.Auteur;
import biblio.repo.AuteurRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AuteurService {
    private final static Logger log = LoggerFactory.getLogger(AuteurService.class);

    private final AuteurRepository repository;

    public AuteurService(AuteurRepository repository) {
        this.repository = repository;
    }

    public Stream<Auteur> findAll() {
        log.debug("Liste des auteurs");

        return this.repository.findAll().stream();
    }

    public Optional<Auteur> findById(String id) {
        log.debug("Récupération de auteur {}", id);

        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Auteur create(CreateOrUpdateAuteurRequest request) {
        log.debug("Création de auteur {}", request.getNom());

        Auteur auteur = new Auteur();

        auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setNationalite(request.getNationalite());

        this.repository.persist(auteur);

        return auteur;
    }

    @Transactional
    public Auteur update(String id, CreateOrUpdateAuteurRequest request) {
        log.debug("Mise à jour de auteur {}", id);

        Auteur auteur = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

         auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setNationalite(request.getNationalite());

        this.repository.persist(auteur);

        return auteur;
    }

    @Transactional
    public boolean deleteById(String id) {
        log.debug("Suppression de auteur {}", id);

        try {
            this.repository.deleteById(id);
            return true;
        }

        catch (Exception ex) {
            log.error("Impossible de supprimer auteur {} : {}", id, ex.getMessage());
            return false;
        }
    }
}
