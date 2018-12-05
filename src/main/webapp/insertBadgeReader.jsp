 <%@ page import="com.virtualpairprogrammers.model.Asset" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="BadgeReaderServlet" method="post">
<table>
	<tr>
	<td>
    <h2>Descrizione</h2></td>	<td><input type="text" name="descrizione"></td>
    </tr>
    <tr><td>
    <h2>Tipologia</h2></td><td><input type="text" name="tipologia">
    </td></tr>
    <tr><td>
    <h2>IdAsset</h2></td><td><input type="text" name="idasset">
    </td></tr>
   	<tr><td>
    <button type="submit" value="insertBadgeReader" name="richiesta">Inserisci</button>
    </td></tr>
    </table>
</form>
</body>
</html>