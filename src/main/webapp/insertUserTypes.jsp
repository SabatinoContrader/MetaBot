<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<form action="UserTypesServlet" method="post">
    
    <h2>Tipo<input type="text" name="tipo"></h2>
    
    <input type="submit" value="insertUserTypes" name="richiesta">
</form>
</body>
</html>