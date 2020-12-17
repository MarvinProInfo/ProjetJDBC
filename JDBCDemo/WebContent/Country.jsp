<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "co.simplon.model.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pays</title>
</head>
<body>
<h1>LISTE DE PAYS</h1>
<form method = "post" action="helloworld">

<p>
<label for = 'nom'>NOM : </label>
<input type = 'text' name = 'nom' value="${requestScope.modifNom}"/>
<br>
<label>ID: </label>
<input type='text' name='id' value="${requestScope.modifId}"/>
</p>
<input type='submit' value="Soumettre la requête">

</form>



<table>
<thead>
<tr>
<th>
PAYS
</th>
</tr>
</thead>
<tbody>
<c:forEach var='nPays' items="${requestScope.pays}">
<tr>
<td><c:out value="${nPays.nom}"/></td>
<td><a href="<c:url value="helloworld?action=update&id=${nPays.id}&nom=${nPays.nom}"/>">MODIFIER</a></td>
<td><a href="<c:url value="helloworld?action=delete&id=${nPays.id}"/>">EFFACER</a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>