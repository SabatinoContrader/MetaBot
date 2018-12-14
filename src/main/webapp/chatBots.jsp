<%@ page import="com.virtualpairprogrammers.model.ChatBot" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<ChatBot> allChatBot = (List<ChatBot>) request.getAttribute("allChatBot");%>
     <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU ChatBots -------</h2>
<form action="ChatBotServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="ChatBotServlet" method="post">
 <table border="2">	
 <tr><th>chatbotID </th>
 <th>ownerFK</th>
 <th>enterPoint</th>
 <th>endPoint</th>
 <th>name</th>
 <th>welcome</th></tr>
 <%for (ChatBot lista : allChatBot) { %>
 <tr><td><%= lista.getChatbotID()%></td>
 <td><%=  lista.getOwnerFK()%></td>
 <td><%=  lista.getEnterPoint()%></td>
 <td><%=  lista.getEndPoint()%></td>
 <td><%=  lista.getName()%></td>
 <td><%=  lista.getWelcome()%></td>
 <td><a href="ChatBotServlet?richiesta=update&id=<%=  lista.getChatbotID()%>">Modifica</a></td>
 <td><a href="ChatBotServlet?richiesta=eliminaChatBot&id=<%= lista.getChatbotID()%>">Elimina</a> </td></tr>
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