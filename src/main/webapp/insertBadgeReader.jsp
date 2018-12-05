<%@ page import="com.pCarpet.dto.BadgeReaderDTO" %>
<%@ page import="com.pCarpet.dto.BadgeDTO" %>
<%@ page import="com.pCarpet.dto.AssetDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
      <% List<AssetDTO> allAssets = (List<AssetDTO>) request.getAttribute("allAssets");%>
</head>
<body>
<form action="/BadgeReader/homeBadgeReader" method="post">
 <table class="border rcorners">
	<tr><th><h4>ASSETS LIBERI</h4></th><td></td><td></td><td></td></tr>
     <tr>
       
         	<th>
             Id Asset
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
        <%for (AssetDTO asset : allAssets) { %>
     <tr>
        
         <td>
             <%= asset.getIdAsset()%>
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
 <br>
<table class="border rcorners">
<tr><th><h4>Inserimento BadgeReader</h4></th><td></td><td></td><td></td></tr>
	<tr>
	<td>
    Descrizione</td><td><input type="text" name="descrizione" required autofocus></td>
    </tr>
    <tr><td>
    Tipologia</td><td><input type="text" name="tipologia" required autofocus>
    </td></tr>
    <tr><td>
    IdAsset</td><td><input type="text" name="idasset" required autofocus>
    </td></tr>
   	</table>
   	<table>
   	<tr><td>
    <button type="submit" class="btn lg btn-primary" value="insertbadgereader" name="scelta">Inserisci</button>
   </td>
   </form> 
     <form action="/BadgeReader/homeBadgeReader" method="post">
   <td> <button type="submit" class="btn lg btn-primary" value="indietro" name="scelta">Indietro</button>
</td></tr>
</form>
</table>
</body>
</html>