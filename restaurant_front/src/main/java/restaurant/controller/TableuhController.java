package restaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant.context.Singleton;
import restaurant.model.Tableuh;


@WebServlet("/table")
public class TableuhController extends HttpServlet {

	//findById => GET
	//findAll => GET
	//delete => GET
	//update => POST
	//insert => POST

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			findAll(request,response);
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				findById(request, response);
			}

			else 
			{
				delete(request,response);
			}
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) {
			insert(request,response);
		}
		else 
		{
			update(request,response);
		}

	}



	/**/

	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Tableuh tableBdd = Singleton.getInstance().getDaoTableuh().findById(id);

		request.setAttribute("table", tableBdd);

		this.getServletContext().getRequestDispatcher("/updateTableuh.jsp").forward(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{}



}
