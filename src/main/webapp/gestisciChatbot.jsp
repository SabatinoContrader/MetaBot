<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestisci Chatbot</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<h1>Gestisci la tua Chatbot: ${chatbotDTODaGestire.nomeChatbot}</h1>
	<div class="container text-center">
		
		<!-- row requires "row-divided" class -->
		<div class="row row-divided offset-md-3">
			<div class="col-md-4  column-one"></div>
		</div>
		<div class="vertical-divider"></div>
		<div class="col-md-5 column-two">
			<table class="table table-dark table-borderedtable-hover">
				<thead>
					<tr>
						<th scope="col">ID Nodo</th>
						<th scope="col">Text</th>

					</tr>
				</thead>
				<jstl:forEach items="${listDTOOrdinata}" var="nodo">
					<tbody>
						<tr>
							<td><jstl:out value="${nodo.idNodo}"></jstl:out></td>
							<td><jstl:out value="${nodo.text}"></jstl:out></td>
							<td><a class="btn btn-lg btn-secondary btn-block" href="">rimuovi</a></td>
						</tr>
					</tbody>
				</jstl:forEach>
				<tr>
					<td><a class="btn btn-lg btn-secondary btn-block"
						href="/Home/homeDirectory/?choice=indietro">Indietro</a></td>
				</tr>
			</table>
		</div>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/js/jquery-3.1.1.min.js"></script>

	<!--  my js -->
	<script src="/js/creaChatbot.js" type="text/javascript"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>

</body>
</html>