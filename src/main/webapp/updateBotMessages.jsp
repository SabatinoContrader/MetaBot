<%@ page import="com.virtualpairprogrammers.model.BotMessages" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<BotMessages> allBotMessages = (List<BotMessages>) request.getAttribute("allBotMessages");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica BotMessages------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="BotMessagesServlet" method="post">
<table border="2">
	<tr><th>ID</th>
	<th>TIPO</th></tr>
<%for (BotMessages lista : allBotMessages) { %>
	<tr><td><%= lista.getBotMessagesId()%></td>
	<td> <%=  lista.getBotMessages()%></td></tr>
<% }%>
 </table>
<table>
    <input type="hidden" name="idBotMessages" value="<%=scelta %>"> 
 	<tr><td><h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="bot_messages">Message</td></tr>
</table>
<table>    
	<tr><td><h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore"></td></tr>  
</table> 
<table> 
	<tr><input type="submit" value="updateBotMessages" name="richiesta"></tr>
</table>
</form>
<form action="BotMessagesServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>