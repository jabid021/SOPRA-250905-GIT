package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.dto.request.CreateOrUpdateProduitRequest;
import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProduitService {
    private final static Logger log = LoggerFactory.getLogger(ProduitService.class);

    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> findAll() {
        log.debug("Liste des produits");

        return this.repository.findAll().list();
    }

    public Optional<Produit> findById(int id) {
        log.debug("Récupération du produit {}", id);

        return this.repository.findByIdOptional(id);
    }

    @Transactional
    public Produit create(CreateOrUpdateProduitRequest request) {
        log.debug("Création du produit {}", request.getLibelle());

        Produit produit = new Produit();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return produit;
    }

    @Transactional
    public Produit update(int id, CreateOrUpdateProduitRequest request) {
        log.debug("Mise à jour du produit {}", id);

        Produit produit = this.repository.findByIdOptional(id).orElseThrow();

        produit.setLibelle(request.getLibelle());
        produit.setPrix(request.getPrix());

        this.repository.persist(produit);

        return produit;
    }

    @Transactional
    public void deleteById(int id) {
        log.debug("Suppression du produit {}", id);

        this.repository.deleteById(id);
    }
}
