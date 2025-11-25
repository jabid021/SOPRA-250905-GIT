package fr.bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.bibliotek.api.request.CreateOrUpdateLivreRequest;
import fr.bibliotek.exception.LivreNotFoundException;
import fr.bibliotek.model.Livre;
import fr.bibliotek.repo.AuteurRepository;
import fr.bibliotek.repo.CollectionRepository;
import fr.bibliotek.repo.EditeurRepository;
import fr.bibliotek.repo.LivreRepository;
import fr.bibliotek.security.config.SecurityConfig;

@Service
public class LivreService {
    private final LivreRepository repository;
    private final AuteurRepository auteurRepository;
    private final EditeurRepository editeurRepository;
    private final CollectionRepository collectionRepository;
    private final static Logger log = LoggerFactory.getLogger(SecurityConfig.class);


    public LivreService(LivreRepository repository, AuteurRepository auteurRepository, EditeurRepository editeurRepository, CollectionRepository collectionRepository) {
        log.info("Création de AuteurService");
        this.repository = repository;
        this.auteurRepository = auteurRepository;
        this.editeurRepository = editeurRepository;
        this.collectionRepository = collectionRepository;
    }

    public List<Livre> findAll() {
        log.info("Création de la liste des livres");
        return this.repository.findAll();
    }

    public Livre findById(String id) {
        log.info("Récupération livre d'id {}", id);
        return this.repository.findById(id).orElseThrow(LivreNotFoundException::new);
    }

    public Livre save(CreateOrUpdateLivreRequest request) {
        log.info("Save (ajout) du livre {} {} {}", request.getAuteurId(), request.getEditeurId(), request.getCollectionId());
        return this.save(new Livre(), request);
    }

    public Livre save(String id, CreateOrUpdateLivreRequest request) {
        log.info("Save (ajout) du livre {} {} {}", request.getAuteurId(), request.getEditeurId(), request.getCollectionId());
        Livre livre = this.findById(id);

        return this.save(livre, request);
    }

    public void deleteById(String id) {
        log.info("Création de AuteurService");
        this.repository.deleteById(id);
    }

    private Livre save(Livre livre, CreateOrUpdateLivreRequest request) {
        log.info("Création de AuteurService");
        livre.setNom(request.getNom());
        livre.setResume(request.getResume());
        livre.setPublication(request.getPublication());

        livre.setAuteur(this.auteurRepository.getReferenceById(request.getAuteurId()));
        livre.setEditeur(this.editeurRepository.getReferenceById(request.getEditeurId()));

        if (request.getCollectionId() != null && !request.getCollectionId().isBlank()) {
            livre.setCollection(this.collectionRepository.getReferenceById(request.getCollectionId()));
        }

        else {
            livre.setCollection(null);
        }

        return this.repository.save(livre);
    }
}
