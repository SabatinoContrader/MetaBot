<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/navbar.css" rel="stylesheet">
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<form class="form-signin">
						<h1 class="h3 mb-3 font-weight-normal">HOME</h1>

						<a class="btn btn-lg btn-primary btn-block"
							href="/Home/homeDirectory/?choice=Chatbot">Chatbot</a><br> <a
							class="btn btn-lg btn-primary btn-block"
							href="/Home/homeDirectory/">User</a><br> <br> <a
							class="btn btn-lg btn-primary btn-block"
							href="/Home/homeDirectory/">Logout</a><br> 

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>