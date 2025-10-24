package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allStagiaires(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheStagiaire(request, response);
			}

			else 
			{
				supprimerStagiaire(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutStagiaire(request,response);
		}
		else 
		{
			modifierStagiaire(request,response);
		}

	}

	
	
	
	

	public void ficheStagiaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		this.getServletContext().getRequestDispatcher("/updateStagiaire.jsp").forward(request, response);
	}



	public void allStagiaires(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		this.getServletContext().getRequestDispatcher("/stagiaire.jsp").forward(request, response);
		
	}
	
	
	public void modifierStagiaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
	}
	public void ajoutStagiaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("");
		
	}
	public void supprimerStagiaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
		
	}



}
