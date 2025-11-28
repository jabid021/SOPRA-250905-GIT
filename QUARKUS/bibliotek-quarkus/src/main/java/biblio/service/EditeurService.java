package biblio.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateEditeurRequest;
import biblio.model.Editeur;
import biblio.repo.EditeurRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EditeurService {
    private final static Logger log = LoggerFactory.getLogger(EditeurService.class);

    private final EditeurRepository repository;

    public EditeurService(EditeurRepository repository) {
        this.repository = repository;
    }

    public Stream<Editeur> findAll() {
        log.debug("Liste des editeurs");

        return this.repository.findAll().stream();
    }

    public Optional<Editeur> findById(String id) {
        log.debug("Récupération de editeur {}", id);

        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Editeur create(CreateOrUpdateEditeurRequest request) {
        log.debug("Création de editeur {}", request.getNom());

        Editeur editeur = new Editeur();

        editeur.setNom(request.getNom());
        editeur.setPays(request.getPays());

        this.repository.persist(editeur);

        return editeur;
    }

    @Transactional
    public Editeur update(String id, CreateOrUpdateEditeurRequest request) {
        log.debug("Mise à jour de editeur {}", id);

        Editeur editeur = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        editeur.setNom(request.getNom());
        editeur.setPays(request.getPays());

        this.repository.persist(editeur);

        return editeur;
    }

    @Transactional
    public boolean deleteById(String id) {
        log.debug("Suppression de editeur {}", id);

        try {
            this.repository.deleteById(id);
            return true;
        }

        catch (Exception ex) {
            log.error("Impossible de supprimer editeur {} : {}", id, ex.getMessage());
            return false;
        }
    }
}
