<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>AMEBA LOGIN PAGE</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

</head>

<body class="text-center">
	<form class="form-signin" action="/Login/loginControl" method="post">
		<h1 class="h3 mb-3 font-weight-normal">AMEBA LOGIN PAGE</h1>
		<h2 class="h3 mb-3 font-weight-normal">Login</h2>
		<label for="inputUser" class="sr-only">Username</label> <input
			type="text" name="username" id="inputUser" class="form-control"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required> <input
			type="text" name="richiesta" value="login" hidden>
		</p>
		
		<c:choose>
			<c:when test="${feedback == 'success'}">
				<p>Registrazione effettuata con successo</p>
			</c:when>

			<c:when test="${feedback == 'failed'}">
				<p>Registrazione non effettuata</p>
			</c:when>
			
			<c:when test="${feedback == 'wrong'}">
				<p>Username o password sbagliati</p>
			</c:when>
		</c:choose>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</body>
</html>