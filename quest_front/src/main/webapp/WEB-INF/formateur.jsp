<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des formateurs</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>

<h1>Gestion des formateurs</h1>

<div>${formateurs}</div>


<table>
	<tr><th>ID</th><th>Login</th><th>Password</th><th>Nom</th><th>Prénom</th><th>Civilité</th><th>Admin</th><th>Actions</th></tr>
	<tr>
		<td>1</td>
		<td>profchen</td>
		<td>profchen</td>
		<td>Chen</td>
		<td>Professeur</td>
		<td>homme</td>
		<td>oui</td>
		<td>
			<a href="formateur?id=1"><input type="button" value="Modifier"></a>
			<a href="formateur?id=1&delete"><input type="button" value="Supprimer"></a>
		</td>
	</tr>
	
	<tr>
		<td>2</td>
		<td>profketeleeria</td>
		<td>profketeleeria</td>
		<td>Keteleeria</td>
		<td>Professeure</td>
		<td>femme</td>
		<td>non</td>
		<td>
			<a href="formateur?id=2"><input type="button" value="Modifier"></a>
			<a href="formateur?id=2&delete"><input type="button" value="Supprimer"></a>
		</td>
	</tr>
</table>

<form method="POST" action="formateur">
	Login : <input type="text" id="login" name="login" placeholder="login" required><br>
	Password : <input type="password" name="password" placeholder="password" required><br>
	Nom : <input type="text" id="nom" name="nom" placeholder="nom" required><br>
	Prénom : <input type="text" id="prenom" name="prenom" placeholder="prenom" required><br>
	Civilité : <input type="radio" id="homme" name="civilite" value="Homme" checked>
            <label for="homme">Homme</label>
            <input type="radio" id="femme" name="civilite" value="Femme">
            <label for="femme">Femme</label>
            <input type="radio" id="nb" name="civilite" value="NB">
            <label for="nb">Non-binaire</label><br>
	Admin : <input type="checkbox" id="admin" name="admin"> Admin
	<input type="submit" value="Ajouter">
</form>

</body>
</html>