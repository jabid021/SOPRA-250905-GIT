package hopital.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import hopital.model.Patient;

public class DAOPatient implements IDAOPatient {

    private EntityManager em;

    public DAOPatient(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = null;
        try {
            Query query = em.createQuery("SELECT p FROM Patient p");
            patients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient findById(Integer id) {
        Patient patient = null;
        try {
            patient = em.find(Patient.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient save(Patient patient) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (patient.getId() == null) {
                // insert patient
                em.persist(patient);
            } else {
                // Update patient
                patient = em.merge(patient);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Patient patient = em.find(Patient.class, id);
            if (patient != null) {
                em.remove(patient);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Patient patient) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (!em.contains(patient)) {
                patient = em.merge(patient);
            }
            em.remove(patient);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Additional utility methods if needed
    public List<Patient> findByNom(String nom) {
        List<Patient> patients = null;
        try {
            Query query = em.createQuery("SELECT p FROM Patient p WHERE p.nom = :nom");
            query.setParameter("nom", nom);
            patients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    public List<Patient> findByNomAndPrenom(String nom, String prenom) {
        List<Patient> patients = null;
        try {
            Query query = em.createQuery("SELECT p FROM Patient p WHERE p.nom = :nom AND p.prenom = :prenom");
            query.setParameter("nom", nom);
            query.setParameter("prenom", prenom);
            patients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
