<%@ page import="com.virtualpairprogrammers.model.BadgeReader" %>
<%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<BadgeReader> allBadgeReaders = (List<BadgeReader>) request.getAttribute("id");%>
      <% List<Asset> allAssets = (List<Asset>) request.getAttribute("allAssets");%>
      
 </head>
 <body>
<h2>Benvenuto <%= request.getSession().getAttribute("utente")%></h2>
 <form action="BadgeReaderServlet" method="post">
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
        <%final int a= badgeReader.getIdBadgeReader();%>
         <input type="hidden" name="Badge" value="<%=a%>"/>
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
	</tr>
     <% }%>
 </table>
 
      <h2> Selezionare l'asset da assegnare al badge reader selezionato:</h2>


 <table border="2">
     <tr>
        <th></th>
         <th>
             ID Asset
         </th>

         <th>
             Tipo
         </th>
         <th>
             Prezzo
         </th>
         <th>
             Descrizione
         </th>


     </tr>
        <%for (Asset asset : allAssets) { %>
     <tr>
         <td>
             <input type="radio" name="asset" value="<%= asset.getId()%>"/>
         </td>

         <td>
             <%= asset.getId()%>
         </td>

         <td>
             <%=  asset.getTipo()%>
         </td>

         <td>
             <%=  asset.getPrezzo()%>
         </td>

         <td>
             <%=  asset.getDescrizione()%>
         </td>
	</tr>
     <% }%>
 </table>
 <button type="submit" value="updateBadgeReader" name="richiesta">Assegna</button>
</form>
 
 
 
 <form action="BadgeReaderServlet" method=post>
<button type="submit" value="indietro" name="richiesta"> Indietro </button>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>