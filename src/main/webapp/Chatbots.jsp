<%@ page import="com.virtualpairprogrammers.dto.ChatbotsDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%
	List<ChatbotsDTO> allChatbotsDTO = (List<ChatbotsDTO>) request.getAttribute("allChatbotsDTO");
%>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%=request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU Management Chatbots -------</h2>
<form action="ChatbotsServlet" method="post">
 <table border="2">
<tr><th></th>
 <th>Id </th>
 <th>id_user_fk</th></tr>
 <th>id_nodo_root_fk</th></tr>
 <th>name_chat</th></tr>
 <%
 	for (ChatbotsDTO lista : allChatbotsDTO) {
 %>
 <tr><td><input type="radio" name="sChatID" value="<%= lista.getId()%>"></td>
 <td><%= lista.getId()%></td>
 <td><%=  lista.getIdUserFk()%></td>
 <td><%=  lista.getIdNodoRootFk()%></td>
 <td><%=  lista.getNameChat()%></td>
  <% }%>
 </table>
    <button type="submit" name="richiesta" value="chatbotsVisualizza" class="btn-link">Visualizza Chat</button> 
</form>
<form action="ChatbotsServlet" method=post>
<button type="submit" value="Indietro" name="richiesta" class="btn">Indietro</button>
</form>
<table>
</body>
</html>