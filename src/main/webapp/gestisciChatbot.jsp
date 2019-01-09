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
<form class="form-signin" action="/Chatbot/chatbotDirectory/" method="post">
<body>

	<h1>Gestisci la tua Chatbot: ${chatbotDTODaGestire.nomeChatbot}</h1>
	
		
		<div class ="container text-center">
		    <div class="col-md-6 column-one">
		       
			<table class="table table-dark table-borderedtable-hover">
				<thead>
					<tr>
						<th scope="col"></th>
						<th scope="col">ID Nodo</th>
						<th scope="col">Messaggio</th>
                        <th scope="col">Nodo Padre</th>
					</tr>
				</thead>
				<jstl:forEach items="${listDTOOrdinata}" var="nodo">
					<tbody>
						<tr>
						
							<td><input type="radio" id="choiceIdNodoPadre" name="choiceIdNodoPadre" value="${nodo.idNodo}" ></td>
							<td><jstl:out value="${nodo.idNodo}"></jstl:out></td>
							<td><jstl:out value="${nodo.text}"></jstl:out></td>
							<td><jstl:out value="${nodo.nodoPadre.idNodo}"></jstl:out></td>
							<td><a class="btn btn-lg btn-secondary btn-block" href="">Elimina</a></td>
						</tr>
					</tbody>
				
				</jstl:forEach>
				</table>
				
	 </div>
	 		<div class ="vertical divider"></div>
		        <div class="col-md-6 column-two">
			
		<table class="table table-dark table-borderedtable-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Messaggio</th>
				</tr>
			</thead>
			<jstl:forEach items="${nodiSenzaPadreDisponibili}" var="node">
				<tbody>
					<tr>
						<td><jstl:out value="${node.idNodo}"></jstl:out></td>
						<td><jstl:out value="${node.text}"></jstl:out></td>
						<td><a class="btn btn-lg btn-danger btn-block"
							href="/Nodo/nodoDirectory/?choice=elimina&id=${node.idNodo}">Elimina</a></td>
							<td>
							
							<input type="text" hidden id="idNode" name="idNode" value="${node.idNodo}" >
						    <button class="btn btn-lg btn-primary btn-block" name="choice" value="Aggiungi"  type="submit" >Aggiungi</button></td>
						    
					</tr>
					
				</tbody>
			</jstl:forEach>

	       			<tr>
						<td></td>
						<td><input type="text" name="text" id="text" ></td>
						<td><button class="btn btn-lg btn-primary btn-block" name="choice" value="creanodo"  type="submit" >Crea Nodo</button></td>
					</tr>
				<tr>
					<td><a class="btn btn-lg btn-secondary btn-block"
						href="/Home/homeDirectory/?choice=indietro">Indietro</a></td>
				</tr>
			</table>
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