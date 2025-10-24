<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="restaurant.model.Tableuh" %>
    <%@ page import="restaurant.context.Singleton" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Fiche de la table X</h1>



<table>
<tr><th>ID</th><th>nbPlace</th><th>Serveur</th><th>Couleurs</th><th>Actions</th></tr>


<%

List<Tableuh> tables = Singleton.getInstance().getDaoTableuh().findAll();

for(Tableuh t : tables)
{
	out.println("<td>"+t.getId()+"</td><td>"+t.getNbPlace()+"</td>");
	if(t.getServeur()==null) 
	{
		out.println("<td>PAS DE SERVEUR</td>");
	}
	else 
	{
		out.println("<td>"+t.getServeur().getId()+" - "+t.getServeur().getPrenom()+" "+t.getServeur().getNom()+" </td>");
	}
	out.println("</tr>");
}

%>

</table>

<div>

<%
Integer id = Integer.parseInt(request.getParameter("id"));

Tableuh table = Singleton.getInstance().getDaoTableuh().findById(id);

out.println(table);

%>






</div>



</body>
</html>