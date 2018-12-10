<%@ page import="com.virtualpairprogrammers.model.UserTypes" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<UserTypes> allUserTypes = (List<UserTypes>) request.getAttribute("allUserTypes");%>
     <link rel="stylesheet" type="text/css" href="styles.css">
 </head>
 <body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<h2>------- MENU UserTypes -------</h2>
<form action="UserTypesServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="UserTypesServlet" method="post">
 <table border="2">
 <tr><th>ID </th>
 <th>TIPO</th></tr>
 <%for (UserTypes lista : allUserTypes) { %>
 <tr><td><%= lista.getUserTypesId()%></td>
 <td><%=  lista.getUserTypes()%></td>
 <td><a href="UserTypesServlet?richiesta=update&id=<%=  lista.getUserTypesId()%>">Modifica</a></td>
 <td><a href="UserTypesServlet?richiesta=eliminaUserTypes&id=<%= lista.getUserTypesId()%>">Elimina</a> </td></tr>
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