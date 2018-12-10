<%@ page import="com.virtualpairprogrammers.model.ChatBots" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<ChatBots> allChatBots = (List<ChatBots>) request.getAttribute("allChatBots");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica Useres------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="ChatBotsServlet" method="post">
<table border="2">
<tr><th>ID </th>
 <th>MESSAGIO INIZIO</th>
 <th>NOME UTENTE</th></tr>
 <%for (ChatBots lista : allChatBots) { %>
 <tr><td><%= lista.getChatBotsId()%></td>
 <td><%=  lista.getInitialMessage()%></td>
 <td><%=  lista.getUsersFK().getUsername() %></td>
  <% }%>
 </table>
<table>
    <input type="hidden" name="idChatBots" value="<%=scelta %>"> 
 	<tr><td><h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="initial_message">Messagio Inizio</td></tr>
</table>
<table>    
	<tr><td><h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore"></td></tr>  
</table> 
<table> 
	<tr><input type="submit" value="updateChatBots" name="richiesta"></tr>
</table>
</form>
<form action="ChatBotsServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>