package quest.dao;

import java.util.List;

public interface IDAO<T,K> {


	String urlBdd = "jdbc:mysql://localhost:3306/projet_quest";
	String loginBdd = "root";
	String passwordBdd = "root";
	
	public List<T> findAll();
	public T findById(K id);
	public void insert(T obj);
	public void update(T obj);
	public void delete(K id);
}
