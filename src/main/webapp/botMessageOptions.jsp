<%@ page import="com.virtualpairprogrammers.model.BotMessageOptions" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<BotMessageOptions> allBotMessageOptions = (List<BotMessageOptions>) request.getAttribute("allBotMessageOptions");%>
     <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU BotMessageOptions -------</h2>
<form action="BotMessageOptionsServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="BotMessageOptionsServlet" method="post">
 <table border="2">
 <tr><th>ID </th>
 <th>MESSAGE</th></tr>
 <%for (BotMessageOptions lista : allBotMessageOptions) { %>
 <tr><td><%= lista.getBotMessageOptionsId()%></td>
 <td><%=  lista.getBotMessageOptions()%></td>
 <td><a href="BotMessageOptionsServlet?richiesta=update&id=<%=  lista.getBotMessageOptionsId()%>">Modifica</a></td>
 <td><a href="BotMessageOptionsServlet?richiesta=eliminaBotMessageOptions&id=<%= lista.getBotMessageOptionsId()%>">Elimina</a> </td></tr>
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