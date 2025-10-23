package restaurant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant.context.Singleton;
import restaurant.model.Tableuh;

@WebServlet("/table2")
public class ServletTableuh extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {}
		
		
		List<Tableuh> tables = Singleton.getInstance().getDaoTableuh().findAll();
		response.getWriter().println("<html>");
		
		response.getWriter().println("<table border>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<th>Id</th><th>Nb Places</th><th>Serveur</th></tr>");
		
		for(Tableuh t : tables) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+t.getId()+"</td><td>"+t.getNbPlace()+"</td>");
			if(t.getServeur()==null) 
			{
				response.getWriter().println("<td>PAS DE SERVEUR</td>");
			}
			else 
			{
				response.getWriter().println("<td>"+t.getServeur().getId()+" - "+t.getServeur().getPrenom()+" "+t.getServeur().getNom()+" </td>");
			}
			response.getWriter().println("</tr>");
		}
		
		response.getWriter().println("</table>");
		response.getWriter().println("</html>");
	}
	
	
}
