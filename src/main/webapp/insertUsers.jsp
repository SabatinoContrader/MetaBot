<%@ page import="com.virtualpairprogrammers.model.Users" %>
<%@ page import="com.virtualpairprogrammers.model.UserTypes" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<UserTypes> allUserTypes = (List<UserTypes>) request.getAttribute("allUserTypes");%>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<form action="UsersServlet" method="post">
    
    <h2>Username<input type="text" name="username"></h2>
    <h2>Password<input type="text" name="password"></h2>
    
 <table border="2">
	<tr><th></th>
	<th>ID</th>
	<th>TIPO</th></tr>
<%for (UserTypes lista : allUserTypes) { %>
	<tr><td><input type="radio" name="choice" value=<%= lista.getUserTypesId() %> ></td>
	<td><%= lista.getUserTypesId()%></td>
	<td> <%=  lista.getUserTypes()%></td></tr>
<% }%>
 </table>
    <input type="submit" value="insertUsers" name="richiesta">
</form>
</body>
</html>