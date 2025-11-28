package bibliotek.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bibliotek.dto.request.CreateOrUpdateEditeurRequest;
import bibliotek.model.Editeur;
import bibliotek.repository.EditeurRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EditeurService {
    
    private final static Logger log = LoggerFactory.getLogger(EditeurService.class);
    private final EditeurRepository repository;

    public EditeurService(EditeurRepository repository){
        this.repository = repository;
    }

    public List<Editeur> findAll() {
        log.debug("findAll des editeurs");
        return this.repository.listAll();
        // == return this.repository.findAll().list()
    }

    public Editeur findById(int id) {
        log.debug("findById de l'éditeur {}", id);
        return this.repository.findById(id);
    }

    @Transactional
    public Editeur create(CreateOrUpdateEditeurRequest request) {
        log.debug("create de l'éditeur {}", request.getNom());
        Editeur editeur = new Editeur();

        editeur.setNom(request.getNom());
        editeur.setNationalite(request.getNationalite());

        this.repository.persist(editeur);

        return editeur;
    }

    @Transactional
    public Editeur update(int id, CreateOrUpdateEditeurRequest request) {
        log.debug("update de l'éditeur {}", id);
        Editeur editeur = this.repository.findById(id);

        editeur.setNom(request.getNom());
        editeur.setNationalite(request.getNationalite());

        this.repository.persist(editeur);

        return editeur;
    }

    @Transactional
    public void deleteById(int id) {
        log.debug("deleteById de l'éditeur {}", id);

        this.repository.deleteById(id);
    }
}
