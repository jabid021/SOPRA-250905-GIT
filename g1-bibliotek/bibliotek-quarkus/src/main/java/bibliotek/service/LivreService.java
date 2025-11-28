package bibliotek.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.request.CreateOrUpdateLivreRequest;
import bibliotek.model.Livre;
import bibliotek.repository.AuteurRepository;
import bibliotek.repository.CollectionRepo;
import bibliotek.repository.EditeurRepository;
import bibliotek.repository.LivreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class LivreService {

    private static final Logger log = LoggerFactory.getLogger(LivreService.class);

    private final LivreRepository repository;
    private final AuteurRepository auteurRepository;
    private final EditeurRepository editeurRepository;
    private final CollectionRepo collectionRepository;

    @Inject
    public LivreService(LivreRepository repository,
                        AuteurRepository auteurRepository,
                        EditeurRepository editeurRepository,
                        CollectionRepo collectionRepository) {
        this.repository = repository;
        this.auteurRepository = auteurRepository;
        this.editeurRepository = editeurRepository;
        this.collectionRepository = collectionRepository;
    }

    public Stream<Livre> findAll() {
        log.debug("Liste des livres");
        return this.repository.findAll().stream();
    }

    public Optional<Livre> findById(int id) {
        log.debug("Récupération du livre {}", id);
        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Livre create(CreateOrUpdateLivreRequest request) {
        log.debug("Création d’un livre : {}", request.getNom());

        Livre livre = new Livre();
        remplirDepuisRequest(livre, request);

        this.repository.persist(livre);

        return livre;
    }

    @Transactional
    public Livre update(int id, CreateOrUpdateLivreRequest request) {
        log.debug("Mise à jour du livre {}", id);

        Livre livre = this.repository.findByIdOptional(id)
                .orElseThrow(NotFoundException::new);

        remplirDepuisRequest(livre, request);

        return livre;
    }

    // --------- DELETE ---------

    @Transactional
    public boolean deleteById(int id) {
        log.debug("Suppression du livre {}", id);

        try {
            return this.repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Impossible de supprimer le livre {} : {}", id, ex.getMessage());
            return false;
        }
    }

    private void remplirDepuisRequest(Livre livre, CreateOrUpdateLivreRequest request) {
        livre.setNom(request.getNom());
        livre.setResume(request.getResume());
        livre.setPublication(request.getPublication());

        livre.setAuteur(auteurRepository.findById(request.getAuteurId()));
        livre.setEditeur(editeurRepository.findById(request.getEditeurId()));

        if (request.getCollectionId() != null) {
            livre.setCollection(collectionRepository.findById(request.getCollectionId()));
        } else {
            livre.setCollection(null);
        }
    }
}
