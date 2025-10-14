package hopital.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Patient;

public class DAOPatientJDBC implements IDAOPatient{

	@Override
	public List<Patient> findAll() {
		Patient patient = null;
		List<Patient> patients = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from patient");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
				patients.add(patient);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public Patient findById(Integer id) {
		Patient patient = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from patient where id=?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public Patient save(Patient patient) {
		if(findById(patient.getId())==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

				PreparedStatement requete = conn.prepareStatement("INSERT INTO patient (id,nom,prenom) VALUES (?,?,?)");
				requete.setInt(1, patient.getId());
				requete.setString(2,patient.getNom() );
				requete.setString(3,patient.getPrenom());
				requete.executeUpdate();

				requete.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

				PreparedStatement requete = conn.prepareStatement("UPDATE patient set nom=?,prenom=? where id=?");

				requete.setString(1,patient.getNom() );
				requete.setString(2,patient.getPrenom());
				requete.setInt(3, patient.getId());
				requete.executeUpdate();

				requete.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return patient;

	}

	

	@Override
	public void delete(Patient patient) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("DELETE from patient where id=?");
			requete.setInt(1, patient.getId());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("DELETE from patient where id=?");
			requete.setInt(1, id);
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Patient> findByNom(String nom){
		return null;
	}
	@Override
	public List<Patient> findByNomAndPrenom(String nom, String prenom){
		return null;
	}
}


