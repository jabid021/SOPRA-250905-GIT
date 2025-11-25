package fr.bibliotek.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.bibliotek.api.request.CreateOrUpdateCollectionRequest;
import fr.bibliotek.exception.CollectionNotFoundException;
import fr.bibliotek.model.Collection;
import fr.bibliotek.repo.CollectionRepository;
import fr.bibliotek.security.config.SecurityConfig;

@Service
public class CollectionService {
    private final CollectionRepository repository;
     private final static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    public CollectionService(CollectionRepository repository) {
        log.info("Création CollectionService");
        this.repository = repository;
    }

    public List<Collection> findAll() {
        log.info("Récupération de la liste des collections");
        return this.repository.findAll();
    }

    public Collection findById(String id) {
        log.info("Récupération de l'id {}", id);
        return this.repository.findById(id).orElseThrow(CollectionNotFoundException::new);
    }

    public Collection save(CreateOrUpdateCollectionRequest request) {
        log.info("Save (ajout) de la collection {}", request.getNom());
        return this.save(new Collection(), request);
    }

    public Collection save(String id, CreateOrUpdateCollectionRequest request) {
        Collection collection = this.findById(id);
        log.info("Save (modif) de la collection {}", request.getNom());
        return this.save(collection, request);
    }

    public void deleteById(String id) {
        log.info("Supression de la collection d'id {}", id);
        this.repository.deleteById(id);
    }

    private Collection save(Collection collection, CreateOrUpdateCollectionRequest request) {
        collection.setNom(request.getNom());
        log.info("Save d'une collection d'id initial {} avec les données {}",collection.getId(),request.getNom());
        return this.repository.save(collection);
    }
}
