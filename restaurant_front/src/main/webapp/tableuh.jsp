<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>${tables}</div>

<table>
<tr><th>ID</th><th>nbPlace</th><th>Serveur</th><th>Couleurs</th><th>Actions</th></tr>
<tr>
<td>1</td>
<td>3</td>
<td>Pas de serveur</td>
<td>Rouge,Jaune</td>
<td>
	<a href="table?id=1"><input type="button" value="Modifier"></a>
	<a href="table?id=1&delete"><input type="button" value="Supprimer"></a>
</td>
</tr>

<tr>
<td>2</td>
<td>6</td>
<td>1 - John Doe </td>
<td>Pas de couleurs</td>
<td>
	<a href="table?id=2"><input type="button" value="Modifier"></a>
	<a href="table?id=2&delete"><input type="button" value="Supprimer"></a>
</td>
</tr>


<tr>
<td>3</td>
<td>1</td>
<td>Pas de serveur</td>
<td>Rouge</td>
<td>
	<a href="table?id=3"><input type="button" value="Modifier"></a>
	<a href="table?id=3&delete"><input type="button" value="Supprimer"></a>
</td>
</tr>
</table>

	<form method="POST" action="table">
	Nombre de place  : <input required type="number" name="nbPlace"><br>
	Serveur : 
	<select name="serveur.id">
		<option value="">Pas de serveur</option>
		<option value="1">John Doe</option>
		<option value="2">Jane Doe</option>
	</select><br>
	Couleurs de la table : <input name="couleurs[]" value="Rouge" type="checkbox"> Rouge <input name="couleurs[]" value="Bleue" type="checkbox"> Bleue <input name="couleurs[]" value="Jaune" type="checkbox"> Jaune  
	<input type="submit" value="Ajouter">
	</form>

</body>
</html>