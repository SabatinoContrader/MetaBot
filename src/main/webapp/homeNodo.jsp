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

	<div class="container">
		<table class="table table-dark table-borderedtable-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Messaggio</th>
					<th scope="col">Nodo padre</th>
				</tr>
			</thead>
			<jstl:forEach items="${allNodeDTO}" var="node">
				<tbody>
					<tr>
						<td><jstl:out value="${node.idNodo}"></jstl:out></td>
						<td><jstl:out value="${node.text}"></jstl:out></td>
						<td><jstl:out value="${node.nodoPadre.idNodo}"></jstl:out></td>
						<td><a class="btn btn-lg btn-danger btn-block"
							href="/Nodo/nodoDirectory/?choice=elimina&id=${node.idNodo}">Elimina</a></td>
					</tr>
				</tbody>
			</jstl:forEach>
			<br>
			<tr>
				<td><a class="btn btn-lg btn-secondary btn-block"
					href="/Home/homeDirectory/?choice=indietro">Indietro</a></td>
			</tr>
			<br>
		</table>
	</div>


</body>
</html>