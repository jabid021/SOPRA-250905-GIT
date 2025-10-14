package restaurant.dao;

import java.util.List;

import restaurant.model.Article;
import restaurant.model.Boisson;
import restaurant.model.Plat;

public interface IDAOArticle extends IDAO<Article,Integer> {

	
	public List<Boisson> findAllBoisson();
	public List<Plat> findAllPlat();
	public List<Article> findAllByNomLike(String recherche);
}
