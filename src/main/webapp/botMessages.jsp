<%@ page import="com.virtualpairprogrammers.model.BotMessages" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<BotMessages> allBotMessages = (List<BotMessages>) request.getAttribute("allBotMessages");%>
     <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU BotMessages -------</h2>
<form action="BotMessagesServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="BotMessagesServlet" method="post">
 <table border="2">
 <tr><th>ID </th>
 <th>MESSAGE</th></tr>
 <%for (BotMessages lista : allBotMessages) { %>
 <tr><td><%= lista.getBotMessagesId()%></td>
 <td><%=  lista.getBotMessages()%></td>
 <td><a href="BotMessagesServlet?richiesta=update&id=<%=  lista.getBotMessagesId()%>">Modifica</a></td>
 <td><a href="BotMessagesServlet?richiesta=eliminaBotMessages&id=<%= lista.getBotMessagesId()%>">Elimina</a> </td></tr>
 <% }%>
 </table>
  <h2></h2>
   <h2></h2>
<input type="submit" value="Indietro" name="richiesta">
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <h3></h3>

 </form>
 </body>
</html>