<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><th>ID</th><th>nbPlace</th><th>Serveur</th><th>Couleurs</th><th>Actions</th></tr>


<c:forEach items="${tables}" var="table">

<tr>
<td>${table.id }</td>
<td>${table.nbPlace }</td>

<c:if test="${table.serveur==null }">
	<td>Pas de serveur</td>
</c:if>

<c:if test="${table.serveur!=null }">
	<td>${table.serveur.id} - ${table.serveur.prenom} ${table.serveur.nom}</td>
</c:if>


<c:choose>
	<c:when test="${table.couleurs.isEmpty()}"><td>PAS DE COULEUR</td></c:when>
	
	<c:otherwise>
		<td>${table.couleurs}</td>
	</c:otherwise>
</c:choose>

<td>
	<a href="table?id=${table.id}"><input type="button" value="Modifier"></a>
	<a href="table?id=${table.id}&delete"><input type="button" value="Supprimer"></a>
</td>
</tr>
</c:forEach>
</table>

	<form method="POST" action="table">
	Nombre de place  : <input required type="number" name="nbPlace"><br>
	Serveur : 
	<select name="serveur.id">
		<option value="">Pas de serveur</option>
		<c:forEach items="${serveurs}" var="serveur">
		<option value="${serveur.id}">${serveur.prenom} ${serveur.nom}</option>
	</c:forEach>
	</select><br>
	Couleurs de la table : 
	<c:forEach items="${couleurs}" var="couleur">
		<input name="couleurs[]" value="${couleur}" type="checkbox"> ${couleur} 
	</c:forEach> 
	<input type="submit" value="Ajouter">
	</form>

</body>
</html>