<%@ page import="com.virtualpairprogrammers.model.Movimento" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Movimento> allMovimenti = (List<Movimento>) request.getAttribute("visualizzaMovimenti");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>


 <table border="2">
     <tr>
         <th>
             ID Badge Reader
         </th>
         <th>
             ID Badge
         </th>
         <th>
             Data inizio
         </th>
         <th>
             Data fine
         </th>
		 </tr>
        <%for (Movimento movimento : allMovimenti) { %>
     <tr>
	<td>
             <%= movimento.getIdbadgereader()%>
         </td>
         <td>
             <%=  movimento.getIdbadge()%>
         </td>

         <td>
             <%=  movimento.getDatainizio()%>
         </td>

         <td>
             <%=  movimento.getDatafine()%>
         </td>
     </tr>
     <% }%>
 </table>
 <form action="MovimentoServlet" method=post>
<button type="submit" value="indietrohome" name="richiesta">Indietro</button>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>