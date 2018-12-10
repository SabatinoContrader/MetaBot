<%@ page import="com.virtualpairprogrammers.model.BotMessageOptions" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<BotMessageOptions> allBotMessageOptions = (List<BotMessageOptions>) request.getAttribute("allBotMessageOptions");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica BotMessageOptions------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="BotMessageOptionsServlet" method="post">
<table border="2">
	<tr><th>ID</th>
	<th>TIPO</th></tr>
<%for (BotMessageOptions lista : allBotMessageOptions) { %>
	<tr><td><%= lista.getBotMessageOptionsId()%></td>
	<td> <%=  lista.getBotMessageOptions()%></td></tr>
<% }%>
 </table>
<table>
    <input type="hidden" name="idBotMessageOptions" value="<%=scelta %>"> 
 	<tr><td><h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="bot_message_options">Message</td></tr>
</table>
<table>    
	<tr><td><h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore"></td></tr>  
</table> 
<table> 
	<tr><input type="submit" value="updateBotMessageOptions" name="richiesta"></tr>
</table>
</form>
<form action="BotMessageOptionsServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>