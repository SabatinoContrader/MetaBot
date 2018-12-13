<%@ page import="com.virtualpairprogrammers.model.Node" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<Node> allNodes = (List<Node>) request.getAttribute("allUsers");%>
</head>
<body>
<form action="NodeServlet" method="post">
    <table border="2">
        <tr><th>NODE ID </th>
            <th>CHATBOT_FK</th>
            <th>CONTENT</th>
        </tr>
        <%for (Node lista : allNodes) { %>
        <tr><td><%= lista.getNodeID()%></td>
            <td><%=  lista.getChatbotFK()%></td>
            <td><%=  lista.getContent()%></td>
            <td><a href="NodeServlet ? richiesta = eliminaNode <% request.setAttribute("node_to_delete",lista) %>">Elimina</a> </td></tr>
            <td><a href="NodeServlet ? richiesta = updateNode  <% request.setAttribute("node_to_update", lista)%>">Update </a> </td></tr>
        <% }%>
    </table>
    <h2></h2>
    <h2></h2>
    <input type="submit" value="Indietro" name="richiesta">
</form>
</body>
</html>
