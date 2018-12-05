<%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Asset> allAssets = (List<Asset>) request.getAttribute("allAssets");%>
 </head>
 <body>
<h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
<form action="AssetServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

<form action="AssetServlet" method="post">
 <table border="2">

     <tr>
       
         <th>
             ID
         </th>

         <th>
             TIPO
         </th>
         <th>
             PREZZO
         </th>
         <th>
             DESCRIZIONE
         </th>
         

     </tr>
        <%for (Asset asset : allAssets) { %>
     <tr>
        
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

          <td>
             <a href="AssetServlet?richiesta=update&id=<%=  asset.getId()%>">Modifica</a>
         </td>
         <td>
             <a href="AssetServlet?richiesta=eliminaAsset&id=<%= asset.getId()%>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
<input type="submit" value="Indietro" name="richiesta">
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>