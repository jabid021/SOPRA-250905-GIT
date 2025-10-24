<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Modifier Pro fait soeur</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>

    <form action="updateFormateur" method="post">

        <input type="hidden" id="id" name="id" value="${formateur.id}">

        <label for="login">Login :</label>
        <input type="text" id="login" name="login" placeholder="login" required value="${formateur.login}"><br><br>

        <label for="password">Password :</label>
        <input type="password" name="password" placeholder="password" required value="${formateur.password}"><br><br>
        
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" placeholder="nom" required value="${formateur.nom}"><br><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" placeholder="prenom" required value="${formateur.prenom}"><br><br>

        <p>Civilite</p>
        <div class="civilite">
            
            <input type="radio" id="homme" name="civilite" value="homme" checked>
            <label for="homme">Homme</label>
            <input type="radio" id="femme" name="civilite" value="femme">
            <label for="femme">Femme</label>
            <input type="radio" id="nb" name="civilite" value="nb">
            <label for="nb">Non-binaire</label> 
        </div>
        <br><br>
        <div class="admin">
            <input type="checkbox" id="admin" name="admin">
            <label for="admin">Admin</label><br><br>
        </div>
        
        
        
        
        <input type="submit" value="Modifier">
    </form> 

</body>
</html>