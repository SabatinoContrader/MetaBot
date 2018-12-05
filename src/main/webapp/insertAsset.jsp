 <%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="AssetServlet" method="post">
    
    <h2>Tipo<input type="text" name="tipo"></h2>
    <h2>Prezzo<input type="text" name="prezzo"></h2>
    <h2>Descrizione<input type="text" name="descrizione"> </h2>
   	
    <input type="submit" value="insertAsset" name="richiesta">
</form>
</body>
</html>