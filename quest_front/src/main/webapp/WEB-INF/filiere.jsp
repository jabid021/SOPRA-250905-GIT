<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	text-align:center;
	font-family: cursive;
	background-color: #f2f2f2;

}
table{
width : 100%;
}
table, th, td {
border: 1px solid black;
border-collapse: collapse;
padding: 5px;
}
th {
background-color: #f2f2f2;
}
form {
margin-bottom: 20px;
}
.retour{
background-color: gray;
}
.supprimer{
background-color:red;
width:30%;
}
.modifier{
background-color:orange;
width:30%;
}
.ajouter{
background-color:yellow;
}

</style>
</head>

<div>${filieres}</div>

<body>


<h1>Gestion des filieres</h1>

<a href="index.html" ><input type="button" value="Retour" class="retour"></a>

<table>
<tr><th>ID</th><th>libelle</th><th>debut</th><th>fin</th><th>Actions</th></tr>
<tr>
<th id="id">1</th>
<td>SOPRA2025</td>
<td>2025-10-10</td>
<td>2025-12-10</td>
<td>
	<a href="filiere?id=1"><input type="button" value="Modifier" class="modifier"></a>
	<a href="filiere?id=1&delete"><input type="button" value="Supprimer" class="supprimer" onclick="alert('Êtes-vous sûr de vouloir supprimer ?')"></a>
</td>
</tr>
<tr>
<th id="id">2</th>
<td>SOPRA2022</td>
<td>2022-10-10</td>
<td>2022-12-10</td>
<td>
	<a href="filier?id=2"><input type="button" value="Modifier" class="modifier"></a>
	<a href="filiere?id=2&delete"><input type="button" value="Supprimer" class="supprimer" onclick="alert('Êtes-vous sûr de vouloir supprimer ?')"></a>
</td>
</tr>

</table>



	<form method="POST" action="filiere">
	Nom de la formation : <input required type="text" name="libelle"><br>
	Date de debut : <input required type="date" name="debut">
	<br>
	Date de fin : <input required type="date" name="fin">
	<br>  
	<input type="submit" value="Ajouter" class="ajouter">
	</form>
</body>
</html>
