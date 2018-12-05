<%@ page import="com.virtualpairprogrammers.model.Movimento" %>
<%@ page import="com.virtualpairprogrammers.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<% List<User> allUsers = (List<User>) request.getAttribute("visualizzaUsers");%>
<meta charset="ISO-8859-1">
<title>Export</title>
</head>
<body>
<form action="MovimentoServlet" method="post">
<table>
<tr><td>
<h2>Inserire percorso dove si vuole esportare il file</h2></td></tr>
<tr>
<td>
<input type="text" name="dir"></td></tr>
<tr><td>
<h2>Inserire nome del file</h2></td></tr>
<tr>
<td>

<input type="text" name="name"></td></tr></table>
</br></br>
  <table border="2">
     <tr>
         <th>
             ID User
         </th>

         <th>
             Username
         </th>
         <th>
             Nome
         </th>
         <th>
             Cognome
         </th>
          <th>
             Partita Iva
         </th>


     </tr>
        <%for (User u : allUsers) { %>
     <tr>
		
         <td>
             <%= u.getIdutente()%>
         </td>

         <td>
             <%=  u.getUsername()%>
         </td>

         <td>
             <%=  u.getNome()%>
         </td>

         <td>
             <%=  u.getCognome()%>
         </td>
         
          <td>
             <%=  u.getPartitaiva()%>
         </td>

        

     </tr>
     <% }%>
 </table>
<tr><td>
<h2>Se si vuole esportare i movimenti relativi ad un utente specifico inserire l'id, altrimenti premere Esporta</h2></td></tr>
<tr>
<td>
<input type="text" name="scelta"></td></tr>

 <form action="MovimentoServlet" method=post>
<table>
<tr>
<td>
<button type="submit" value="indietrohome" name="richiesta">Indietro</button>
</td>
<td><button type="submit" value="exportMov" name="richiesta">Esporta</button>
</td>
</tr>
</table>
</form>
</body>
</html>