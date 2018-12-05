 <%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<Asset> allAssets = (List<Asset>) request.getAttribute("allAssets");%>
<h1>------Modifica Asset------</h1>     
</head>
<body>
<%int scelta = Integer.parseInt(request.getParameter("id")); %>

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


     </tr>
     <% }%>
 </table>
    <table>
    <input type="hidden" name="idAsset" value="<%=scelta %>"> 
 <tr> 
 <td>  
    <h2>Seleziona il campo:</h2></td>
    <td><input type="radio" name="campo" value="tipo">Tipo</td>
    <td><input type="radio" name="campo" value="prezzo">Prezzo</td>
    <td><input type="radio" name="campo" value="descrizione">Descrizione</td>
    </tr></table>
<table>    <tr><td>
    <h2>Inserisci il nuovo valore del campo</h2></td>
    <td><input type="text" name="newData" placeholder = "Nuovo valore">
    
 </td>
 </tr>  
 
 </table> 
 <table> 

<tr>
    <input type="submit" value="updateAsset" name="richiesta">
</tr>
</table>
</form>
 <form action="AssetServlet" method=post>
<button type="submit" value="IndietroHome" name="richiesta">Indietro</button>
</form>
</body>
</html>