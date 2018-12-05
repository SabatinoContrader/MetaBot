<%@ page import="com.virtualpairprogrammers.model.BadgeReader" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<BadgeReader> allBadgeReaders = (List<BadgeReader>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>
<form action="BadgeReaderServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

 <table border="2">
     <tr>
         <th>
             ID Badge Reader
         </th>

         <th>
             ID Asset
         </th>
         <th>
             Descrizione
         </th>
         <th>
             Tipologia
         </th>


     </tr>
        <%for (BadgeReader badgeReader : allBadgeReaders) { %>
     <tr>

         <td>
             <%= badgeReader.getIdBadgeReader()%>
         </td>

         <td>
             <%=  badgeReader.getIdAsset()%>
         </td>

         <td>
             <%=  badgeReader.getDescrizione()%>
         </td>

         <td>
             <%=  badgeReader.getTipologia()%>
         </td>

          <td>
             <a href="BadgeReaderServlet?richiesta=update&id=<%=  badgeReader.getIdBadgeReader()%>">Modifica</a>
         </td>
         <td>
             <a href="BadgeReaderServlet?richiesta=deleteBadgeReader&delBadgeReader=<%= badgeReader.getIdBadgeReader()%>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
 <form action="BadgeReaderServlet" method=post>
<button type="submit" value="indietrohome" name="richiesta">Indietro</button>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>