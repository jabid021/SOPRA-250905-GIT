package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Ordinateur;


@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allOrdinateurs(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheOrdinateur(request, response);
			}

			else 
			{
				supprimerOrdinateur(request,response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutOrdinateur(request,response);
		}
		else 
		{
			modifierOrdinateur(request,response);
		}
	}


	public void ficheOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Ordinateur tableBdd = Singleton.getInstance().getDaoOrdinateur().findById(id);

		request.setAttribute("ordinateur", tableBdd);
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);
	}


	public void allOrdinateurs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Ordinateur> ordinateurs = Singleton.getInstance().getDaoOrdinateur().findAll();
		request.setAttribute("ordinateurs", ordinateurs);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateur.jsp").forward(request, response);
	}
	
	
	public void modifierOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		String marque = request.getParameter("marque");
		int ram = Integer.parseInt(request.getParameter("ram"));

		Ordinateur ordinateur = new Ordinateur(id,marque,ram);

		Singleton.getInstance().getDaoOrdinateur().save(ordinateur);
		
		response.sendRedirect("ordinateur");
	}
	
	
	public void ajoutOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String marque = request.getParameter("marque");
		int ram = Integer.parseInt(request.getParameter("ram"));

		Ordinateur ordinateur = new Ordinateur(marque,ram);
		Singleton.getInstance().getDaoOrdinateur().save(ordinateur);
		
		response.sendRedirect("ordinateur");
	}
	
	public void supprimerOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Singleton.getInstance().getDaoOrdinateur().deleteById(id);
		
		response.sendRedirect("ordinateur");
	}

}
