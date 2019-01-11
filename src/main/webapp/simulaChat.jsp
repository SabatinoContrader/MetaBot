
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simula</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container">
<form action="/Chatbot/simulazione/${simulatedChatID}" method ="post">
    <jstl:forEach items="${chatlog}" var="log">
        <input readonly type="text" value="${log}" name="chatlog"><br>
    </jstl:forEach>
    <br>
    <jstl:forEach items="${prossimiNodi}" var="nodo">
        <button type="submit" name="nodoScelto" value="${nodo.idNodo}">${nodo.text}</button>
    </jstl:forEach>
</form>

</div>

</body>
</html>





