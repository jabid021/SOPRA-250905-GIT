package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formateur")
public class FormateurController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			allFormateurs(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				ficheFormateur(request, response);
			}

			else 
			{
				supprimerFormateur(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			ajoutFormateur(request,response);
		}
		else 
		{
			modifierFormateur(request,response);
		}

	}

	
	
	
	

	public void ficheFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		this.getServletContext().getRequestDispatcher("/updateFormateur.jsp").forward(request, response);
	}



	public void allFormateurs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		this.getServletContext().getRequestDispatcher("/formateur.jsp").forward(request, response);
		
	}
	
	
	public void modifierFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
	}
	public void ajoutFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("");
		
	}
	public void supprimerFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
		
	}



}
