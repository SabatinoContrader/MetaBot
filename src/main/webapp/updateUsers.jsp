<%@ page import="com.virtualpairprogrammers.model.Users" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<Users> allUsers = (List<Users>) request.getAttribute("allUsers");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica Useres------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="UsersServlet" method="post">
<table border="2">
<tr><th>ID </th>
 <th>USERNAME</th>
 <th>PASSWORD</th>
 <th>TIPO</th></tr>
 <%for (Users lista : allUsers) { %>
 <tr><td><%= lista.getUsersId()%></td>
 <td><%=  lista.getUsername()%></td>
 <td><%=  lista.getPassword()%></td>
 <td><%=  lista.getUserTypeFk().getUserTypes()  %></td>
  <% }%>
 </table>
<table>
    <input type="hidden" name="idUsers" value="<%=scelta %>"> 
 	<tr><td><h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="password">Password</td></tr>
</table>
<table>    
	<tr><td><h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore"></td></tr>  
</table> 
<table> 
	<tr><input type="submit" value="updateUsers" name="richiesta"></tr>
</table>
</form>
<form action="UsersServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>