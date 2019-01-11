<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Crea User</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/userManagement/">Indietro</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
	<div class="container text-center">
		<div class="row">
			<div class="col-xs-12">
				<h1>Crea User</h1>
			</div>
		</div>
		<!-- row requires "row-divided" class -->
		<div class="row row-divided offset-md-3">
			<div class="col-md-4  column-one">
				<form action="/User/creaUser" id="formCreaUser" method="post">
					<div class="form-group">
						<label for="username">Nome User:</label> <input type="text"
							class="form-control" id="username"
							placeholder="Inserisci il nome dell tuo user" name="username">
					</div>
					<div class="form-group">
						<label for="password">Password User:</label> <input type="text"
							class="form-control" id="password"
							placeholder="Inserisci il password dell tuo user" name="password">
					</div>

					<div class="form-group">
						<label for="ruolo">Ruolo User:</label> <input type="radio"
							name="ruolo" value="ADMIN">ADMIN  <input type="radio"
							name="ruolo" value="CHAT_MASTER">CHAT_MASTER  <input type="radio"
							name="ruolo" value="UTENTE">UTENTE
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
				</form>


			</div>
			<div class="vertical-divider"></div>
		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/js/jquery-3.1.1.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>

</body>
</html>