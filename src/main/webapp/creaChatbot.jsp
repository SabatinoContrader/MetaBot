<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Crea Chatbot</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/chatManagement/">Indietro</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
	<div class="container text-center">
		<div class="row">
			<div class="col-xs-12">
				<h1>Crea la tua Chatbot</h1>
			</div>
		</div>
		<!-- row requires "row-divided" class -->
		<div class="row row-divided offset-md-3">
			<div class="col-md-4  column-one">
				<form action="/Chatbot/creaChatbot" id="formCreaChatbot" method="get">
					<div class="form-group">
						<label for="nomeChatbot">Nome Chatbot:</label> <input type="text"
							class="form-control" id="nomeChatbot"
							placeholder="Inserisci il nome della tua chat" name="nomeChatbot">
					</div>
					<div class="form-group">
						<label for="nodiPadre">Messaggi iniziali disponibili</label> <select
							class="form-control" name="nodoPadreSelezionato">
							<jstl:forEach items="${listNodesDTONodoPadreNull}" var="nodo">
								<option value="${nodo.idNodo}">
									<jstl:out value="${nodo.idNodo}"></jstl:out>
									<jstl:out value="${nodo.text}"></jstl:out>
								</option>
							</jstl:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
				</form>


			</div>
			<div class="vertical-divider"></div>
			<div class="col-md-5 column-two">
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
										href="/Chatbot/chatbotDirectory/?choice=gestisci&idChatDaGestire=${chatbot.idChatbot}">Gestisci</a></td>
								</tr>
							</tbody>
						</jstl:forEach>
					</table>

			</div>
		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/js/jquery-3.1.1.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>

</body>
</html>