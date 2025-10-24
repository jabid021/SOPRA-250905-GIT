package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allFilieres(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheFiliere(request, response);
			}

			else 
			{
				supprimerFiliere(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutFiliere(request,response);
		}
		else 
		{
			modifierFiliere(request,response);
		}

	}

	
	
	
	

	public void ficheFiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		this.getServletContext().getRequestDispatcher("/updateFiliere.jsp").forward(request, response);
	}



	public void allFilieres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		this.getServletContext().getRequestDispatcher("/filiere.jsp").forward(request, response);
		
	}
	
	
	public void modifierFiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
	}
	public void ajoutFiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("");
		
	}
	public void supprimerFiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
		
	}



}
