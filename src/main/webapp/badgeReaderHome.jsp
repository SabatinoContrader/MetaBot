<%@ page import="com.pCarpet.dto.BadgeReaderDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
  <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
     <% List<BadgeReaderDTO> allBadgeReaders = (List<BadgeReaderDTO>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>

<form action="/BadgeReader/homeBadgeReader" method="GET">
 <table class="border rcorners">
  <tr><th><h4>BADGE READERS</h4></th><TD></TD><TD></TD><TD></TD></tr>
 
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
        <%for (BadgeReaderDTO badgeReader : allBadgeReaders) { %>
     <tr>
         <td>
             <%= badgeReader.getIdBadgeReader()%>
         </td>

         <td>
             <%=  badgeReader.getAsset().getIdAsset()%>
         </td>

         <td>
             <%=  badgeReader.getDescrizione()%>
         </td>

         <td>
             <%=  badgeReader.getTipologia()%>
         </td>

</form>
     </tr>
     <% }%>
 </table>
 <table>
 <form action="/BadgeReader/homeBadgeReader" method=get>
<tr><td><button type="submit" class="btn lg btn-primary" value="indietro" name="scelta">Indietro</button></td>
</form>
<form action="/BadgeReader/homeBadgeReader" method="POST">
   <td> <button type="submit" class="btn lg btn-primary" value="insert" name="scelta">Inserisci</button></td></tr>
</form>
</table>


 </form>
 </body>
</html>