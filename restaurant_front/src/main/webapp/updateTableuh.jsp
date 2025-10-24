<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quest Front</title>
</head>
<body>

<div>${table}</div>
<h1>Update de la tableuh ${table.id}</h1>

<form method="POST" action="table">
	<input type="hidden" name="id" value="${table.id}">
	Nombre de place  : <input required type="number" name="nbPlace" value="${table.nbPlace}"><br>
	Serveur : 
	<select name="serveur.id">
		<option value="">Pas de serveur</option>
		<option value="1" selected>John Doe</option>
		<option value="2">Jane Doe</option>
	</select><br>
	Couleurs de la table : <input name="couleurs[]" checked value="Rouge" type="checkbox"> Rouge <input name="couleurs[]"  checked value="Bleue" type="checkbox"> Bleue <input name="couleurs[]" value="Jaune" type="checkbox"> Jaune  
	<input type="submit" value="Modifier">
	</form>
</body>
</html>