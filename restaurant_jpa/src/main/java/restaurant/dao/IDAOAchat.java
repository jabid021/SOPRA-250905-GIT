package restaurant.dao;

import javax.persistence.EntityManager;

import eshop.model.Produit;
import restaurant.model.Achat;

public interface IDAOAchat extends IDAO<Achat,Integer> {

}

public Fournisseur findByIdWithStock (idFournisseur) {
	
	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

    Fournisseur fournisseur = em.createQuery(
        "SELECT * FROM Fournisseur LEFT JOIN FETCH fournisseur.produits WHERE fournisseur.id = :id",
        Fournisseur.class
    )
    .setParameter("id", idFournisseur)
    .getSingleResult();

    em.close();
    return fournisseur;
	
	
}


