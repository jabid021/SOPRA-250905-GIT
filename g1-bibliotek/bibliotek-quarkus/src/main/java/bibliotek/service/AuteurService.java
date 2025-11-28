package bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.Request.CreateOrUpdateAuteurRequest;
import bibliotek.model.Auteur;
import bibliotek.repository.AuteurRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped      
public class AuteurService {
    private final static Logger log = LoggerFactory.getLogger(AuteurService.class);
    private final AuteurRepository repository;

    public AuteurService(AuteurRepository repository){
        this.repository = repository;
    }

    public List<Auteur> findAll() {
        log.debug("Liste des auteurs");
        return this.repository.listAll();
        // == return this.repository.findAll().list()
    }

    public Auteur findById(int id) {
        log.debug("Récupération du auteur {}", id);
        return this.repository.findById(id);
    }

    @Transactional
    public Auteur create(CreateOrUpdateAuteurRequest request) {
        log.debug("Création du auteur {}", request.getNom());
        Auteur auteur = new Auteur();

        auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setNationalite(request.getNationalite());

        this.repository.persist(auteur);

        return auteur;
    }

    @Transactional
    public Auteur update(int id, CreateOrUpdateAuteurRequest request) {
        log.debug("Mise à jour du auteur {}", id);
        Auteur auteur = this.repository.findById(id);

        auteur.setNom(request.getNom());
        auteur.setPrenom(request.getPrenom());
        auteur.setNationalite(request.getNationalite());

        this.repository.persist(auteur);

        return auteur;
    }

    @Transactional
    public void deleteById(int id) {
        log.debug("Suppression du auteur {}", id);

        this.repository.deleteById(id);
    }
}
