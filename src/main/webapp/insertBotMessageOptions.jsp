<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<form action="BotMessageOptionsServlet" method="post">
    
    <h2>Message<input type="text" name="message"></h2>
    
    <input type="submit" value="insertBotMessageOptions" name="richiesta">
</form>
</body>
</html>