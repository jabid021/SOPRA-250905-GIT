<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quest Front</title>
</head>
<body>

<h1>Update de la tableuh ${table.id}</h1>

<form method="POST" action="table">
	<input type="hidden" name="id" value="${table.id}">
	Nombre de place  : <input required type="number" name="nbPlace" value="${table.nbPlace}"><br>
	Serveur : 
	<select name="serveur.id">
		
		
	<c:forEach items="${serveurs}" var="serveur">
		<c:choose>
			<c:when test="${table.serveur==null}">
				<option value="">Pas de serveur</option>
			</c:when>
			<c:when test="${table.serveur.id==serveur.id}">
				<option selected value="${serveur.id}">${serveur.prenom} ${serveur.nom}</option>
			</c:when>
			<c:otherwise>
				<option value="${serveur.id}">${serveur.prenom} ${serveur.nom}</option>
			</c:otherwise>
		</c:choose>
		
	</c:forEach>
	</select><br>
	Couleurs de la table : 
	<c:forEach items="${couleurs}" var="couleur">
	<c:choose>
		<c:when test="${table.couleurs.contains(couleur)}">
			<input name="couleurs[]" checked value="${couleur}" type="checkbox"> ${couleur} 
		</c:when>
		<c:otherwise>
			<input name="couleurs[]" value="${couleur}" type="checkbox"> ${couleur} 	
		</c:otherwise>
		
		</c:choose>
	</c:forEach> 
	<input type="submit" value="Modifier">
	</form>
</body>
</html>