<%@ page import="com.pCarpet.dto.MovimentoDTO" %>
<%@ page import="com.pCarpet.dto.UserDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<% List<UserDTO> allUsers = (List<UserDTO>) request.getAttribute("visualizzaUsers");%>
<meta charset="ISO-8859-1">
<title>Export</title>
</head>
<body>
<form action="/Movimento/homeMovimento" method="post">
<table>
<tr><td>
<h3>Inserire percorso dove si vuole esportare il file</h3></td></tr>
<tr>
<td>
<input type="text" name="dir"></td></tr>
<tr><td>
<h3>Inserire nome del file</h3></td></tr>
<tr>
<td>

<input type="text" name="name"></td></tr></table>
</br></br>
  <table class="border rcorners" width="550px">
     <tr><th><h4>Users</h4></th><td></td><td></td><td class="userimg"></td></tr>
     
     <tr>
         <th>
             ID User
         </th>

         <th>
             Username
         </th>
         <th>Ragione Sociale
             
         </th>
          <th>
             Partita Iva
         </th>


     </tr>
        <%for (UserDTO u : allUsers) { %>
     <tr>
		
         <td>
             <%= u.getIduser()%>
         </td>

         <td>
             <%=  u.getUsername()%>
         </td>

         <td>
             <%=  u.getRagioneSociale()%>
         </td>
         
          <td>
             <%=  u.getPartitaiva()%>
         </td>

        

     </tr>
     <% }%>
 </table>
<tr><td>
<h3>Se si vuole esportare i movimenti relativi ad un utente specifico inserire l'id,<br> altrimenti premere Esporta per esportare i movimenti e le prenotazioni di tutti gli utenti</h3></td></tr>
<tr>
<td>
<input type="text" name="scelta"></td></tr>

 <form action="/Movimento/homeMovimento" method=post>
<table>
<tr>
<td>
<button type="submit" class="btn lg btn-primary" value="indietroHome" name="richiesta">Indietro</button>
</td>
<td><button type="submit" value="exportdue" class="btn lg btn-primary" name="richiesta">Esporta</button>
</td>
</tr>
</table>
</form>
<c:choose>
     
			<c:when test="${feedback == 'success'}">
				<div class="alert alert-success">
    				<strong>Success!</strong> Export effettuato con successo nella directory selezionata.
  				</div>
			</c:when>
			
			<c:when test="${feedback == 'wrong'}">
				<div class="alert alert-danger">
    				<strong>Error!</strong> Export non riuscito, controlla i dati inseriti e riprova.
  				</div>
			</c:when>
			
     </c:choose>
</body>
</html>