package restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant.context.Singleton;
import restaurant.model.Couleur;
import restaurant.model.Employe;
import restaurant.model.Tableuh;


@WebServlet("/table")
public class TableuhController extends HttpServlet {

	//findAll => localhost:8080/restaurant_front/table [GET]
	//findById => localhost:8080/restaurant_front/table?id=1  [GET]
	//delete => localhost:8080/restaurant_front/table?id=1&delete [GET]

	//insert => localhost:8080/restaurant_front/table [POST] 
	//update => localhost:8080/restaurant_front/table [POST] (avec un id dans le formulaire)

	//Les données qu'on recoit du navigateur vers le controller => parametres => request.getParameter(x) (aussi bien en GET qu'en POST)
	//Les données qu'on veut envoyer du controller vers le navigateur => attributs => request.setAttribute("x",y) , x etant le nom qu'on utilisera dans la jsp, y la donnée qu'on souhaite envoyer

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allTableuhs(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheTableuh(request, response);
			}

			else 
			{
				supprimerTableuh(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutTableuh(request,response);
		}
		else 
		{
			modifierTableuh(request,response);
		}

	}

	
	
	
	
	
	/*Nos differentes actions pour réaliser le CRUD */

	public void ficheTableuh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Tableuh tableBdd = Singleton.getInstance().getDaoTableuh().findById(id);
		
		request.setAttribute("serveurs", Singleton.getInstance().getDaoCompte().findAllEmploye());
		request.setAttribute("couleurs", Couleur.values());
		request.setAttribute("table", tableBdd);

		this.getServletContext().getRequestDispatcher("/WEB-INF/updateTableuh.jsp").forward(request, response);
	}



	public void allTableuhs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Tableuh> tables = Singleton.getInstance().getDaoTableuh().findAll();
		request.setAttribute("serveurs", Singleton.getInstance().getDaoCompte().findAllEmploye());
		request.setAttribute("couleurs", Couleur.values());
		request.setAttribute("tables", tables);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/tableuh.jsp").forward(request, response);
		
	}
	
	
	public void modifierTableuh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Integer nbPlace = Integer.parseInt(request.getParameter("nbPlace"));
		Employe serveur=null;
		if(request.getParameter("serveur.id")!="")
		{
			serveur =(Employe) Singleton.getInstance().getDaoCompte().findById(Integer.parseInt(request.getParameter("serveur.id"))); 
		}

		Tableuh table = new Tableuh(id,nbPlace,serveur);
		for(String couleur : request.getParameterValues("couleurs[]")) 
		{
			table.getCouleurs().add(Couleur.valueOf(couleur));
		}

		Singleton.getInstance().getDaoTableuh().save(table);
		
		response.sendRedirect("table");

		
		
	}
	public void ajoutTableuh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Integer nbPlace = Integer.parseInt(request.getParameter("nbPlace"));
		Employe serveur=null;
		if(request.getParameter("serveur.id")!="")
		{
			serveur =(Employe) Singleton.getInstance().getDaoCompte().findById(Integer.parseInt(request.getParameter("serveur.id"))); 
		}

		Tableuh table = new Tableuh(null,nbPlace,serveur);
		for(String couleur : request.getParameterValues("couleurs[]")) 
		{
			table.getCouleurs().add(Couleur.valueOf(couleur));
		}

		Singleton.getInstance().getDaoTableuh().save(table);
		
		
		response.sendRedirect("table");
		
	}
	public void supprimerTableuh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Singleton.getInstance().getDaoTableuh().deleteById(id);
		
		response.sendRedirect("table");
		
	}



}
