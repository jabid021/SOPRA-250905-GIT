package fr.bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.bibliotek.api.request.CreateOrUpdateAuteurRequest;
import fr.bibliotek.exception.AuteurNotFoundException;
import fr.bibliotek.model.Auteur;
import fr.bibliotek.repo.AuteurRepository;
import fr.bibliotek.security.config.SecurityConfig;

@Service
public class AuteurService {
    private final AuteurRepository repository;
    private final static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    public AuteurService(AuteurRepository repository) {
        log.info("Création de AuteurService");
        this.repository = repository;
    }

    public List<Auteur> findAll() {
        log.info("Récupération de la liste des auteurs");
        return this.repository.findAll();
    }

    public Auteur findById(String id) {
        log.info("Récupération de l'auteur d'id {}", id);
        return this.repository.findById(id).orElseThrow(AuteurNotFoundException::new);
    }

    public Auteur save(CreateOrUpdateAuteurRequest request) {
        log.info("Save (ajout) de l'auteur {} {}", request.getPrenom(), request.getNom());
        return this.save(new Auteur(), request);
    }

    public Auteur save(String id, CreateOrUpdateAuteurRequest request) {
        Auteur auteur = this.findById(id);
        log.info("Save (modif) de l'auteur {} {}, d'id {}", request.getPrenom(), request.getNom(), id);
        return this.save(auteur, request);
    }

    public void deleteById(String id) {
        log.info("Supression de l'auteur d'id {}", id);
        this.repository.deleteById(id);
    }

    private Auteur save(Auteur auteur, CreateOrUpdateAuteurRequest request) {
        auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setNationalite(request.getNationalite());
        log.info("Save d'un auteur d'id initial {} avec les données {} {} {}", auteur.getId(), request.getPrenom(),
                request.getNom(), request.getNationalite());
        return this.repository.save(auteur);
    }
}
