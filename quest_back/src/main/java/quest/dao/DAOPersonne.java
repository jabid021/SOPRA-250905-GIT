package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import quest.model.Civilite;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Ordinateur;
import quest.model.Personne;
import quest.model.Stagiaire;

public class DAOPersonne implements IDAO<Personne,Integer>{

	@Override
	public List<Personne> findAll() {
		DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
		DAOFiliere daoFiliere = new DAOFiliere();
		Personne personne = null;
		List<Personne> personnes = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from personne");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				if(rs.getString("type_personne").equals("Stagiaire")) 
				{
					Ordinateur ordinateur = daoOrdinateur.findById(rs.getInt("ordinateur"));
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),ordinateur,filiere);

				}
				else if(rs.getString("type_personne").equals("Formateur")) 
				{
					personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				}

				personnes.add(personne);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnes;
	}

	@Override
	public Personne findById(Integer id) {
		DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
		DAOFiliere daoFiliere = new DAOFiliere();
		Personne personne = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from personne where id=?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				if(rs.getString("type_personne").equals("Stagiaire")) 
				{
					Ordinateur ordinateur = daoOrdinateur.findById(rs.getInt("ordinateur"));
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),ordinateur,filiere);

				}
				else if(rs.getString("type_personne").equals("Formateur")) 
				{
					personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				}
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personne;
	}

	@Override
	public void insert(Personne personne) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("INSERT INTO personne (login,password,nom,prenom,civilite,admin,email,numero,voie,ville,cp,ordinateur,filiere,type_personne) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			if(personne instanceof Stagiaire) 
			{
				Stagiaire stagiaire = (Stagiaire) personne;
				requete.setString(1,stagiaire.getLogin());
				requete.setString(2,stagiaire.getPassword());
				requete.setString(3,stagiaire.getNom());
				requete.setString(4,stagiaire.getPrenom());
				requete.setString(5,stagiaire.getCivilite().toString());
				requete.setObject(6,null);
				requete.setString(7,stagiaire.getEmail());
				requete.setString(8,stagiaire.getAdresse().getNumero());
				requete.setString(9,stagiaire.getAdresse().getVoie());
				requete.setString(10,stagiaire.getAdresse().getVille());
				requete.setString(11,stagiaire.getAdresse().getCp());
				requete.setInt(12,stagiaire.getOrdinateur().getId());
				requete.setInt(13,stagiaire.getFiliere().getId());
				requete.setString(14, "Stagiaire");
			}
			else if(personne instanceof Formateur) 
			{
				Formateur formateur = (Formateur) personne;
				requete.setString(1,formateur.getLogin());
				requete.setString(2,formateur.getPassword());
				requete.setString(3,formateur.getNom());
				requete.setString(4,formateur.getPrenom());
				requete.setString(5,formateur.getCivilite().toString());
				requete.setObject(6,formateur.isAdmin());
				requete.setObject(7,null);
				requete.setObject(8,null);
				requete.setObject(9,null);
				requete.setObject(10,null);
				requete.setObject(11,null);
				requete.setObject(12,null);
				requete.setObject(13,null);
				requete.setString(14, "Formateur");
			}


			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Personne personne) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("UPDATE personne set login=?,password=?,nom=?,prenom=?,civilite=?,admin=?,email=?,numero=?,voie=?,ville=?,cp=?,ordinateur=?,filiere=?,type_personne=? where id=?");

			if(personne instanceof Stagiaire) 
			{
				Stagiaire stagiaire = (Stagiaire) personne;
				requete.setString(1,stagiaire.getLogin());
				requete.setString(2,stagiaire.getPassword());
				requete.setString(3,stagiaire.getNom());
				requete.setString(4,stagiaire.getPrenom());
				requete.setString(5,stagiaire.getCivilite().toString());
				requete.setObject(6,null);
				requete.setString(7,stagiaire.getEmail());
				requete.setString(8,stagiaire.getAdresse().getNumero());
				requete.setString(9,stagiaire.getAdresse().getVoie());
				requete.setString(10,stagiaire.getAdresse().getVille());
				requete.setString(11,stagiaire.getAdresse().getCp());
				requete.setInt(12,stagiaire.getOrdinateur().getId());
				requete.setInt(13,stagiaire.getFiliere().getId());
				requete.setString(14, "Stagiaire");
				requete.setInt(15,stagiaire.getId());
			}
			else if(personne instanceof Formateur) 
			{
				Formateur formateur = (Formateur) personne;
				requete.setString(1,formateur.getLogin());
				requete.setString(2,formateur.getPassword());
				requete.setString(3,formateur.getNom());
				requete.setString(4,formateur.getPrenom());
				requete.setString(5,formateur.getCivilite().toString());
				requete.setObject(6,formateur.isAdmin());
				requete.setObject(7,null);
				requete.setObject(8,null);
				requete.setObject(9,null);
				requete.setObject(10,null);
				requete.setObject(11,null);
				requete.setObject(12,null);
				requete.setObject(13,null);
				requete.setString(14, "Formateur");
				requete.setInt(15,formateur.getId());
			}


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

			PreparedStatement requete = conn.prepareStatement("DELETE from personne where id=?");
			requete.setInt(1, id);
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Personne> findAllStagiaire() {
		DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
		DAOFiliere daoFiliere = new DAOFiliere();
		Personne personne = null;
		List<Personne> personnes = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from personne where type_personne='Stagiaire'");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				Ordinateur ordinateur = daoOrdinateur.findById(rs.getInt("ordinateur"));
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),ordinateur,filiere);
				personnes.add(personne);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnes;
	}

	
	public List<Personne> findAllFormateur() {
		Personne personne = null;
		List<Personne> personnes = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from personne where type_personne='Formateur'");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Civilite.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				personnes.add(personne);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnes;
	}

}
