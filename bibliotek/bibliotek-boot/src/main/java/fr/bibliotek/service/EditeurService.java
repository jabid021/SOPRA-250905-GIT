package fr.bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.bibliotek.api.request.CreateOrUpdateEditeurRequest;
import fr.bibliotek.exception.EditeurNotFoundException;
import fr.bibliotek.model.Editeur;
import fr.bibliotek.repo.EditeurRepository;
import fr.bibliotek.security.config.SecurityConfig;

@Service
public class EditeurService {
    private final EditeurRepository repository;
    private final static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    public EditeurService(EditeurRepository repository) {
        log.info("Création de EditeurService");
        this.repository = repository;
    }

    public List<Editeur> findAll() {
        log.info("Récupération de la liste des éditeurs");
        return this.repository.findAll();
    }

    public Editeur findById(String id) {
        log.info("Récupération de l'éditeur d'id {}", id);
        return this.repository.findById(id).orElseThrow(EditeurNotFoundException::new);
    }

    public Editeur save(CreateOrUpdateEditeurRequest request) {
        log.info("Save (ajout) de l'éditeur {}, pays : {}", request.getNom(), request.getPays());
        return this.save(new Editeur(), request);
    }

    public Editeur save(String id, CreateOrUpdateEditeurRequest request) {
        Editeur editeur = this.findById(id);
        log.info("Save (modif) de l'éditeur {}, pays : {}", request.getNom(), request.getPays());
        return this.save(editeur, request);
    }

    public void deleteById(String id) {
        log.info("Suppression de l'éditeur d'id {}", id);
        this.repository.deleteById(id);
    }

    private Editeur save(Editeur editeur, CreateOrUpdateEditeurRequest request) {
        editeur.setNom(request.getNom());
        editeur.setPays(request.getPays());
        log.info("Save d'un éditeur d'id initial {} avec les données {} {}", editeur.getId(), request.getNom(),
                request.getPays());
        return this.repository.save(editeur);
    }
}
