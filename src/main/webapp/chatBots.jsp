<%@ page import="com.virtualpairprogrammers.model.ChatBots" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<ChatBots> allChatBots = (List<ChatBots>) request.getAttribute("allChatBots");%>
     <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU ChatBots -------</h2>
<form action="ChatBotsServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="ChatBotsServlet" method="post">
 <table border="2">
 <tr><th>ID </th>
 <th>MESSAGIO INIZIO</th>
 <th>NOME UTENTE</th></tr>
 <%for (ChatBots lista : allChatBots) { %>
 <tr><td><%= lista.getChatBotsId()%></td>
 <td><%=  lista.getInitialMessage()%></td>
 <td><%=  lista.getUsersFK().getUsername()%></td>
 <td><a href="ChatBotsServlet?richiesta=update&id=<%=  lista.getChatBotsId()%>">Modifica</a></td>
 <td><a href="ChatBotsServlet?richiesta=eliminaChatBots&id=<%= lista.getChatBotsId()%>">Elimina</a> </td></tr>
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