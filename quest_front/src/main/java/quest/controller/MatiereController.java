package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("")
public class MatiereController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allMatieres(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheMatiere(request, response);
			}

			else 
			{
				supprimerMatiere(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutMatiere(request,response);
		}
		else 
		{
			modifierMatiere(request,response);
		}

	}

	
	
	
	

	public void ficheMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		this.getServletContext().getRequestDispatcher("/updateMatiere.jsp").forward(request, response);
	}



	public void allMatieres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		this.getServletContext().getRequestDispatcher("/matiere.jsp").forward(request, response);
		
	}
	
	
	public void modifierMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
	}
	public void ajoutMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("");
		
	}
	public void supprimerMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
		
	}



}
