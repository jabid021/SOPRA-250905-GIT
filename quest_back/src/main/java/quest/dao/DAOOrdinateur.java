package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Ordinateur;

public class DAOOrdinateur implements IDAO<Ordinateur,Integer>{

	@Override
	public List<Ordinateur> findAll() {
		Ordinateur ordinateur = null;
		List<Ordinateur> ordinateurs = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from ordinateur");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				ordinateur = new Ordinateur(rs.getInt("numero"),rs.getString("marque"),rs.getInt("ram"));
				ordinateurs.add(ordinateur);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordinateurs;
	}

	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur ordinateur = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from ordinateur where numero=?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				ordinateur = new Ordinateur(rs.getInt("numero"),rs.getString("marque"),rs.getInt("ram"));
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordinateur;
	}

	@Override
	public void insert(Ordinateur ordinateur) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("INSERT INTO ordinateur (marque,ram) VALUES (?,?)");
			requete.setString(1,ordinateur.getMarque() );
			requete.setInt(2,ordinateur.getRam());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Ordinateur ordinateur) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("UPDATE ordinateur set marque=?,ram=? where numero=?");
			requete.setString(1,ordinateur.getMarque() );
			requete.setInt(2,ordinateur.getRam());
			requete.setInt(3, ordinateur.getId());
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

			PreparedStatement requete = conn.prepareStatement("DELETE from ordinateur where numero=?");
			requete.setInt(1, id);
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
