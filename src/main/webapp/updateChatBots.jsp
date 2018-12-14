<%@ page import="com.virtualpairprogrammers.model.ChatBot" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<ChatBot> allChatBot = (List<ChatBot>) request.getAttribute("allChatBot");%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h1>------Modifica Useres------</h1>     
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>
<form action="ChatBotServlet" method="post">
<input type="hidden" name="chatbotID" value="<%=scelta %>"> 
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
  <% }%>
 </table>
<table border="2">	
    <h2>ownerFK inizio<input type="text" name="ownerFK"></h2>
    <h2>enterPoint inizio<input type="text" name="enterPoint"></h2>
    <h2>endPoint<input type="text" name="endPoint"></h2>
    <h2>name<input type="text" name="name"></h2>
    <h2>welcome<input type="text" name="welcome"></h2>
<tr><input type="submit" value="updateChatBot" name="richiesta"></tr>
</table>
</form>
<form action="ChatBotServlet" method=post>
<button type="submit" value="Indietro" name="richiesta">Indietro</button>
</form>
</body>
</html>