package biblio.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import biblio.dto.request.CreateOrUpdateLivreRequest;
import biblio.model.Livre;
import biblio.repo.AuteurRepository;
import biblio.repo.LivreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import biblio.repo.*;

@ApplicationScoped
public class LivreService {
    private final static Logger log = LoggerFactory.getLogger(LivreService.class);

    private final LivreRepository repository;
    private final AuteurRepository auteurRepo;
     private final CollectionRepository collectionRepo;
      private final EditeurRepository editeurRepo;


    public LivreService(LivreRepository repository, AuteurRepository auteurRepo, CollectionRepository collectionRepo,
            EditeurRepository editeurRepo) {
        this.repository = repository;
        this.auteurRepo = auteurRepo;
        this.collectionRepo = collectionRepo;
        this.editeurRepo = editeurRepo;
    }


    public Stream<Livre> findAll() {
        log.debug("Liste des livres");

        return this.repository.findAll().stream();
    }

    public Optional<Livre> findById(String id) {
        log.debug("Récupération du livre {}", id);

        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Livre create(CreateOrUpdateLivreRequest request) {
        log.debug("Création du livre {}", request.getNom());

        Livre livre = new Livre();

        livre.setNom(request.getNom());
        livre.setAuteur(this.auteurRepo.findById(request.getAuteurId()));
        livre.setCollection(this.collectionRepo.findById(request.getCollectionId()));
        livre.setEditeur(this.editeurRepo.findById(request.getEditeurId()));
        livre.setPublication(request.getPublication());
        livre.setResume(request.getResume());

        this.repository.persist(livre);

        return livre;
    }

    @Transactional
    public Livre update(String id, CreateOrUpdateLivreRequest request) {
        log.debug("Mise à jour du livre {}", id);

        Livre livre = this.repository.findByIdOptional(id).orElseThrow(NotFoundException::new);

        livre.setNom(request.getNom());
        livre.setAuteur(this.auteurRepo.findById(request.getAuteurId()));
        livre.setCollection(this.collectionRepo.findById(request.getCollectionId()));
        livre.setEditeur(this.editeurRepo.findById(request.getEditeurId()));
        livre.setPublication(request.getPublication());
        livre.setResume(request.getResume());

        this.repository.persist(livre);

        return livre;
    }

    @Transactional
    public boolean deleteById(String id) {
        log.debug("Suppression du livre {}", id);

        try {
            this.repository.deleteById(id);
            return true;
        }

        catch (Exception ex) {
            log.error("Impossible de supprimer le livre {} : {}", id, ex.getMessage());
            return false;
        }
    }
}