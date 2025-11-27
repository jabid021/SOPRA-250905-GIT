package quest.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import quest.dto.request.CreateOrUpdateMatiereRequest;
import quest.model.Matiere;
import quest.repo.MatiereRepository;

@ApplicationScoped
public class MatiereService {
    private final static Logger log = LoggerFactory.getLogger(MatiereService.class);

    private final MatiereRepository repository;

    public MatiereService(MatiereRepository repository) {
        this.repository = repository;
    }

    public Stream<Matiere> findAll() {
        log.debug("Liste des produits");

        return this.repository.findAll().stream();
    }

    public Optional<Matiere> findById(int id) {
        log.debug("Récupération de la matière {}", id);

        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Matiere create(CreateOrUpdateMatiereRequest request) {
        log.debug("Création de la matière {}", request.getLibelle());

        Matiere matiere = new Matiere();

        matiere.setLibelle(request.getLibelle());

        this.repository.persist(matiere);

        return matiere;
    }

    @Transactional
    public Matiere update(int id, CreateOrUpdateMatiereRequest request) {
        log.debug("Mise à jour de la matière {}", id);

        Matiere matiere = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        matiere.setLibelle(request.getLibelle());

        this.repository.persist(matiere);

        return matiere;
    }

    @Transactional
    public boolean deleteById(int id) {
        log.debug("Suppression de la matière {}", id);

        try {
            this.repository.deleteById(id);
            return true;
        }

        catch (Exception ex) {
            log.error("Impossible de supprimer la matière {} : {}", id, ex.getMessage());
            return false;
        }
    }
}
