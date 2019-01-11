<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>LOGIN PAGE</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

</head>

<body class="text-center">
	<form class="form-signin" action="/User/login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Metabot LOGIN PAGE</h1>

		<label for="inputUser" class="sr-only">Username</label> <input
			type="text" name="username" id="inputUser" class="form-control"
			placeholder="Username" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required> <input
			type="text" name="richiesta" value="login" hidden>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form>
</body>
</html>