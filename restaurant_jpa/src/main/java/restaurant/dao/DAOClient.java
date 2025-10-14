package restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import restaurant.context.Singleton;
import restaurant.model.Client;

public class DAOClient implements IDAOClient {

	@Override
	public List<Client> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Client> clients  = em.createQuery("from Client").getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Client client  = em.find(Client.class, id);
		em.close();
		return client;
	}

	@Override
	public Client save(Client client) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		client=  em.merge(client);
		em.getTransaction().commit();
		em.close();
		return client;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Client client = em.find(Client.class, id);
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	
	}

	@Override
	public void delete(Client client) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		client = em.merge(client);
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Client findByIdWithHistoriqueResa(Integer idClient) {
		Client client=null;
		try {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		client  = em.createQuery("SELECT c from Client c LEFT JOIN FETCH c.historiqueResa where c.id=:id",Client.class).setParameter("id", idClient).getSingleResult();
		em.close();
		}catch(Exception e) {e.printStackTrace();}
		return client;
	}

}
