package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOVisite implements IDAOVisite{

	@Override
	public List<Visite> findAll() {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		Visite visite = null;
		List<Visite> visites = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from visite");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				
				visite = new Visite(rs.getInt("numero"),rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")), patient,medecin);
				visites.add(visite);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public Visite findById(Integer id) {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		Visite visite = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from visite where numero=?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				
				visite = new Visite(rs.getInt("numero"),rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")), patient,medecin);
				
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public void insert(Visite visite) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("INSERT INTO visite (id_patient,id_medecin,prix,salle,date_visite) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setInt(1,visite.getPatient().getId() );
			requete.setInt(2,visite.getMedecin().getId());
			requete.setDouble(3, visite.getPrix());
			requete.setInt(4, visite.getSalle());
			requete.setString(5, visite.getDateVisite().toString());
			
			requete.executeUpdate();
			
			ResultSet rs = requete.getGeneratedKeys();
			while(rs.next()) 
			{
				int lastInsertId = rs.getInt(1);
				visite.setNumero(lastInsertId);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Visite visite) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("UPDATE visite set id_patient=?,id_medecin=?,prix=?,salle=?,date_visite=? where numero=?");
			if(visite.getPatient()==null) 
			{
				requete.setObject(1, null);
			}
			else 
			{
				requete.setInt(1,visite.getPatient().getId());
			}
			requete.setInt(2,visite.getMedecin().getId());
			requete.setDouble(3, visite.getPrix());
			requete.setInt(4, visite.getSalle());
			requete.setString(5, visite.getDateVisite().toString());
			requete.setInt(6, visite.getNumero());
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("DELETE from visite where numero=?");
			requete.setInt(1, id);
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<Visite> findAllByIdPatient(Integer idPatient) {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		Visite visite = null;
		List<Visite> visites = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from visite where id_patient=?");
			requete.setInt(1, idPatient);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				
				visite = new Visite(rs.getInt("numero"),rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")), patient,medecin);
				visites.add(visite);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

	
	
	

}
