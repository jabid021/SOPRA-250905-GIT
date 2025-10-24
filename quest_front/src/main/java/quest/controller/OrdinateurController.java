package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		
		this.getServletContext().getRequestDispatcher("/updateOrdinateur.jsp").forward(request, response);
	}



	public void allOrdinateurs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		this.getServletContext().getRequestDispatcher("/ordinateur.jsp").forward(request, response);
		
	}
	
	
	public void modifierOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
	}
	public void ajoutOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("");
		
	}
	public void supprimerOrdinateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.sendRedirect("");
		
	}



}
