<%@ page import="com.virtualpairprogrammers.model.ChatBot" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>SEI LOGGATO COME: <%= request.getSession().getAttribute("utente")%></h1>
<form action="ChatBotServlet" method="post">
    <h2>ownerFK inizio<input type="text" name="ownerFK"></h2>
    <h2>enterPoint inizio<input type="text" name="enterPoint"></h2>
    <h2>endPoint<input type="text" name="endPoint"></h2>
    <h2>name<input type="text" name="name"></h2>
    <h2>welcome<input type="text" name="welcome"></h2>
    <input type="submit" value="insertChatBot" name="richiesta">
</form>
</body>
</html>