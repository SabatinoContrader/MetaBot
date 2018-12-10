<%@ page import="com.virtualpairprogrammers.model.ChatBots" %>
<%@ page import="com.virtualpairprogrammers.model.Users" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<Users> allUsers = (List<Users>) request.getAttribute("allUsers");%>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<form action="ChatBotsServlet" method="post">
    
    <h2>Messagio inizio<input type="text" name="initialMessage"></h2>
    
 <table border="2">
	<tr><th></th>
	<th>ID</th>
	<th>NOME UTENTE</th></tr>
<%for (Users lista : allUsers) { %>
	<tr><td><input type="radio" name="choice" value=<%= lista.getUsersId() %> ></td>
	<td><%= lista.getUsersId()%></td>
	<td> <%=  lista.getUsername()%></td></tr>
<% }%>
 </table>
    <input type="submit" value="insertChatBots" name="richiesta">
</form>
</body>
</html>