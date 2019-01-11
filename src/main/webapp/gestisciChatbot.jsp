<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Gestisci è Chatbot</title>

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
	<form class="form-signin" action="/Nodo/nodoDirectory/" method="post"
		enctype="multipart/form-data">

		<h1>Gestisci la tua Chatbot: ${chatbotDTODaGestire.nomeChatbot}</h1>


		<div class="container">
			<div>

				<table class="table table-dark table-borderedtable-hover">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">ID Nodo</th>
							<th scope="col">Messaggio</th>
							<th scope="col">Tipo nodo</th>
							<th scope="col">Nodo Padre</th>
						</tr>
					</thead>
					<jstl:forEach items="${listDTOOrdinata}" var="nodo">
						<tbody>
							<tr>

								<td><input type="radio" id="choiceIdNodoPadre"
									name="choiceIdNodoPadre" value="${nodo.idNodo}"></td>
								<td><jstl:out value="${nodo.idNodo}"></jstl:out></td>
								<td><jstl:out value="${nodo.text}"></jstl:out></td>
								<td><jstl:out value="${nodo.tipoNodo}"></jstl:out></td>
								<td><jstl:out value="${nodo.nodoPadre.idNodo}"></jstl:out></td>
								<jstl:forEach items="${hashElimina}" var="padre">
									<jstl:if test="${nodo == padre.key}">
										<jstl:if test="${0 == padre.value}">
											<td><a class="btn btn-lg btn-secondary btn-block"
												href="/Nodo/eliminaNodo/?id=${nodo.idNodo}&idChatDaGestire=${idChatDaGestire}">Elimina</a>
											</td>
										</jstl:if>

									</jstl:if>

								</jstl:forEach>
								<td>
									<div class="form-group">
										<a class="btn btn-lg btn-secondary btn-block"
											href="/Nodo/download/?idNodoPerPath=${nodo.idNodo}">DOWNLOAD</a>
									</div>
								</td>

							</tr>
						</tbody>

					</jstl:forEach>
				</table>

			</div>
			<div class="vertical divider"></div>
			<div>

				<table class="table table-dark table-borderedtable-hover">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">ID</th>
							<th scope="col">Messaggio</th>
							<th scope="col">Tipo Nodo</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<jstl:forEach items="${nodiSenzaPadreDisponibili}" var="node">
						<tbody>
							<tr>
								<td><input type="radio" id="choiceIdNodoFiglio"
									name="choiceIdNodoFiglio" value="${node.idNodo}"></td>
								<td><jstl:out value="${node.idNodo}"></jstl:out></td>
								<td><jstl:out value="${node.text}"></jstl:out></td>
								<td><jstl:out value="${node.tipoNodo}"></jstl:out></td>
								<td><a class="btn btn-lg btn-danger btn-block"
									href="/Nodo/eliminaNodo/?id=${node.idNodo}&idChatDaGestire=${idChatDaGestire}">Elimina</a></td>
								<td>
									<div class="form-group">
										<input type="file" class="form-control-file" name="file">
										<input type="submit" name="choice" value="upload"
											type="submit">
									</div>
								</td>

							</tr>

						</tbody>
					</jstl:forEach>
					<tr>
						<td>
							<button class="btn btn-lg btn-primary btn-block" name="choice"
								value="Aggiungi" type="submit">Aggiungi</button>
						</td>

					</tr>
					<tr>
						<table class="table table-dark table-borderedtable-hover">

							<thead>
								<tr>

									<th scope="col">Messaggio</th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col">Tipo Nodo</th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>

								</tr>
							</thead>
							<tr>
								<td><input type="text" name="text" id="text"> <input
									type="hidden" id="idChatDaGestire" name="idChatDaGestire"
									value="${idChatDaGestire}"></td>
								<td><input type="radio" name="tipoNodo" value="DOMANDA"></td>
								<td>DOMANDA</td>
								<td><input type="radio" name="tipoNodo" value="OPZIONE"></td>
								<td>OPZIONE</td>
								<td><input type="radio" name="tipoNodo" value="RISPOSTA"></td>
								<td>RISPOSTA</td>
								<td><button class="btn btn-lg btn-primary btn-block"
										name="choice" value="creanodo" type="submit">Crea
										Nodo</button></td>
							</tr>
						</table>

					</tr>

		


				</table>
			</div>
		</div>
	</form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/js/jquery-3.1.1.min.js"></script>

	<!--  my js -->
	<script src="/js/creaChatbot.js" type="text/javascript"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>