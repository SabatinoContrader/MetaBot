<%@ page import="com.virtualpairprogrammers.model.UserTypes" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<UserTypes> allUserTypes = (List<UserTypes>) request.getAttribute("allUserTypes");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica UserTypes------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="UserTypesServlet" method="post">
<table border="2">
	<tr><th>ID</th>
	<th>TIPO</th></tr>
<%for (UserTypes lista : allUserTypes) { %>
	<tr><td><%= lista.getUserTypesId()%></td>
	<td> <%=  lista.getUserTypes()%></td></tr>
<% }%>
 </table>
<table>
    <input type="hidden" name="idUserTypes" value="<%=scelta %>"> 
 	<tr><td><h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="user_types">Tipo</td></tr>
</table>
<table>    
	<tr><td><h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore"></td></tr>  
</table> 
<table> 
	<tr><input type="submit" value="updateUserTypes" name="richiesta"></tr>
</table>
</form>
<form action="UserTypesServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>