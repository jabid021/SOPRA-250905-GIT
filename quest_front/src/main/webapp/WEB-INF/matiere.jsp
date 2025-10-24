<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style>

tr
{
 text-align: center;
}

#fond {
  background-image: url('assets/images/tpt.png');
  background-position: center;
}

</style>

<head>
<meta charset="UTF-8">

<title>Page Matiere</title>
</head>
<body id="fond">

<h1>Gestion des matières</h1>

<div>${matieres}</div>

<table id="taz">
<tr><th>ID</th><th>Libellé</th><th>Actions</th></tr>
<tr><td>1</td><td>java</td><td>
	<a href="matiere?id=1"><input type="button" value="Modifier"></a>
	<a href="matiere?id=1&delete"><input type="button" value="Supprimer"></a>
</td></tr>
<tr><td>2</td><td>html</td><td>
	<a href="matiere?id=2"><input type="button" value="Modifier"></a>
	<a href="matiere?id=2&delete"><input type="button" value="Supprimer"></a>
</td></tr>

</table>

<form method="POST" action="matiere">
	Libelle  : <input required type="text" name="libelle"><br>
	<input type="submit" value="Ajouter">
	</form>
</body>

</html>