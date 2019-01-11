
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
            <li><a href="/Home/chatManagement/">Chatbot</a></li>
            <li><a href="/Home/indietro/">Indietro</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
	<div class="container">
		<table class="table table-dark table-borderedtable-hover">
			<thead>
				<tr>
					<th scope="col">ID User</th>
					<th scope="col">Nome</th>
					<th scope="col">Password</th>
					<th scope="col">Ruolo</th>

				</tr>
			</thead>
			<jstl:forEach items="${allUserDTO}" var="user">
				<tbody>
					<tr>
						<td><jstl:out value="${user.idUser}"></jstl:out></td>
						<td><jstl:out value="${user.username}"></jstl:out></td>
						<td><jstl:out value="${user.password}"></jstl:out></td>
						<td><jstl:out value="${user.ruolo}"></jstl:out></td>
						<td><a class="btn btn-lg btn-secondary btn-block"
							href="/User/delete/?id=${user.idUser}">Elimina</a></td>
					</tr>
				</tbody>
			</jstl:forEach>
			<tr>
				<td><a class="btn btn-lg btn-success btn-block"
					href="/User/crea">Crea nuovo User</a></td>
				<td>
					<form class="example" action="/User/cercaUser" method="get">
						<input type="text" placeholder="Search.." name="search"
							class="btn btn-default">
						<button type="submit" class="btn btn-default">Cerca</button>
					</form>
				</td>
		</table>
	</div>


</body>
</html>





