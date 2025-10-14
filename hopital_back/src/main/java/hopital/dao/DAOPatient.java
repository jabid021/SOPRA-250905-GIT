package hopital.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import hopital.context.Singleton;
import hopital.model.Compte;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOPatient implements IDAOPatient {

   
    @Override
    public List<Patient> findAll() {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Patient> patients  = em.createQuery("from Compte").getResultList();
		em.close();
		return patients;
    }

    @Override
    public Patient findById(Integer id) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Patient patient  = em.find(Patient.class, id);
		em.close();
		return patient;
    }

    @Override
    public Patient save(Patient patient) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		patient=  em.merge(patient);
		em.getTransaction().commit();
		em.close();
		return patient;
    }

    @Override
    public void deleteById(Integer id) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Patient patient = em.find(Patient.class, id);
		em.remove(patient);
		em.getTransaction().commit();
		em.close();
    }

    @Override
    public void delete(Patient patient) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		patient = em.merge(patient);
		em.remove(patient);
		em.getTransaction().commit();
		em.close();
    }

    @Override
    public List<Patient> findByNom(String nom) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Patient> patients = em.createQuery("SELECT p FROM Patient p WHERE p.nom = :nom", Patient.class).setParameter("nom", nom).getResultList();
		em.close();
		return patients;
    }

    @Override
    public List<Patient> findByNomAndPrenom(String nom, String prenom) {
    	EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
        List<Patient> patients = em.createQuery("SELECT p FROM Patient p WHERE p.nom = :nom AND p.prenom = :prenom", Patient.class).setParameter("nom", nom).setParameter("prenom", prenom).getResultList();
        em.close();
        return patients;
    }
}
