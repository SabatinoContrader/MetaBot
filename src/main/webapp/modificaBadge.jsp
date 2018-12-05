<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>

<h2>Inserisci i dati del badge</h2>
 
 </br>
 
<form action="/Badge/modificaBadge" method="post">
        
<table class="border rcorners">	
<tr><th><h4>Badges</h4></th><td></td><td class="imgB"></td></tr>
	<tr>
        
         <th>
             ID Badge
         </th>

         <th>
             Tipologia
         </th>
         
         <th>
             Descrizione
         </th>
         
         
	</tr>
	<tr>
	
        <td>
            <input type="text" value="${badge.idBadge}" disabled>
         </td>

		<td>
             <input type="text" value="${badge.descrizione}" name="descrizione" style="opacity:0.8">
         </td>
         
         <td>
            <input type="text" value="${badge.tipologia}" name="tipologia" style="opacity:0.8">
         </td>

         
     </tr>
   
     
</table>

<br>

<br>
<input type="hidden" name="id" value="${badge.idBadge}"/>

<table>
<tr>
<td>
<p align="left">
<button class="btn lg btn-primary" type="submit" value="update" name="choice">Effettua Modifica</button>
</p>
</td>
<td>
<a class="btn lg btn-primary" 
		href="/Badge/HomeBadge?scelta=indietrobadgemanagement">Indietro</a>
</td></tr>

</table>
</form>

</body>
</html>