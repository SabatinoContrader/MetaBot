
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HomeNodo</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/userManagement/">User</a></li>
            <li><a href="/Home/indietro/">Indietro</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
	<div class="container">
		<table class="table table-dark table-borderedtable-hover">
			<thead>
				<tr>
					<th scope="col">ID Chat</th>
					<th scope="col">Nome Chat</th>
					<th scope="col">utenteCollegato</th>
					<th scope="col">NodoPadre</th>

				</tr>
			</thead>
			<jstl:forEach items="${allChatbotsDTO}" var="chatbot">
				<tbody>
					<tr>
						<td><jstl:out value="${chatbot.idChatbot}"></jstl:out></td>
						<td><jstl:out value="${chatbot.nomeChatbot}"></jstl:out></td>
						<td><jstl:out value="${chatbot.user.username}"></jstl:out></td>
						<td><jstl:out value="${chatbot.nodoPadre.text}"></jstl:out></td>
						<td><a class="btn btn-lg btn-secondary btn-block"
							href="/Chatbot/gestisci/?idChatDaGestire=${chatbot.idChatbot}">Gestisci</a></td>
						<td><a class="btn btn-lg btn-secondary btn-block"
							href="/Chatbot/esportareXML/?idChatDaEsportare=${chatbot.idChatbot}">Esportare
								XML</a></td>
						<td><a class="btn btn-lg btn-secondary btn-block"
							href="/Chatbot/simulazione/?chatbotID=${chatbot.idChatbot}">Simula</a></td>
					</tr>
				</tbody>
			</jstl:forEach>
			<tr>
				<td><a class="btn btn-lg btn-success btn-block"
					href="/Chatbot/crea/">Crea nuova
						Chatbot</a></td>

				<td><a class="btn btn-lg btn-secondary btn-block"
					href="/Chatbot/importareXML/">Importare
						XML</a></td>
				<td>
					<form class="example" action="/Chatbot/cercaChatbot" method="get">
						<input type="text" placeholder="Search.." name="search"
							class="btn btn-default">
						<button type="submit" class="btn btn-default">Cerca</button>
					</form>
				</td>
		</table>
	</div>


</body>
</html>





