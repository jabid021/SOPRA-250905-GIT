<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Stagiaire</title>
</head>
<body>

<h1> Modifier Stagiaires</h1>

<form  method="POST" action="stagiaire">

<input type="hidden" name="id" value="${stagiaire.id}">

Login : <input type="text" name="login" placeholder="login" required value="${stagiaire.login}"> <br>
Password : <input type="password" name="password" placeholder="password" required value="${stagiaire.password}"> <br>
Nom : <input type="text" name="nom" placeholder="nom" required value="${stagiaire.nom}"> <br>
Prenom : <input type="text" name="prenom" placeholder="prenom" required value="${stagiaire.prenom}"> <br>
Civilite : 
	<select name="civilite" required>
		<option value=""> Choisir civilite  </option>
		<option selected>Homme</option>
		<option>Femme</option>
		<option>NB</option>
	</select><br>
Email : <input type="text" name="email" placeholder="email" required value="${stagiaire.email}"> <br>

Adresse :   <input type="text" name="adresse.numero" placeholder="numero_rue" required value="${stagiaire.numero}"> <br>
 			<input type="text" name="adresse.rue" placeholder="rue" required value="${stagiaire.voie}"> <br>
 			<input type="text" name="adresse.cp" placeholder="cp" required value="${stagiaire.cp}"> <br>
 			<input type="text" name="adresse.ville" placeholder="ville" required value="${stagiaire.ville}"> <br>

<input type="submit" value="Modifier">




</form>


</body>
</html>