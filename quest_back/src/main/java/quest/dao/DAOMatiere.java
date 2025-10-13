package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Matiere;

public class DAOMatiere implements IDAO<Matiere,Integer>{

	@Override
	public List<Matiere> findAll() {
		Matiere matiere = null;
		List<Matiere> matieres = new ArrayList();
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from matiere");
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"),rs.getInt("quest"));
				matieres.add(matiere);
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return matieres;
	}

	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = null;
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("SELECT * from matiere where id=?");
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();


			while(rs.next()) {
				matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"),rs.getInt("quest"));
			}

			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return matiere;
	}

	@Override
	public void insert(Matiere matiere) {
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("INSERT INTO matiere (libelle,quest) VALUES (?,?)");
			requete.setString(1,matiere.getLibelle() );
			requete.setInt(2,matiere.getQuest());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void update(Matiere matiere) {
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("UPDATE matiere set libelle=?,quest=? where id=?");
			requete.setString(1,matiere.getLibelle() );
			requete.setInt(2,matiere.getQuest());
			requete.setInt(3, matiere.getId());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void delete(Integer id) {
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement requete = conn.prepareStatement("DELETE from matiere where id=?");
			requete.setInt(1, id);
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
