<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>File</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

	DA COPIARE E SISTEMARE PER UN CERTO ID NODO PASSANDO L'ID E FARE OPPORTUNE VERIFICHE OPPURE CON JSTL FARE QUI IL CONTROLLO
	<form action="/File/upload" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<input type="file" class="form-control-file" name="file"> <input
				type="submit">
		</div>
	</form>
	
	</br>
	</br>
	</br>
	</br>
	</br>
	
	IL DOWNLOAD DEL FILE
	<form action="/File/download" method="get" >
		<div class="form-group">
		 <input
				type="submit">
		</div>
	</form>
	
	


</body>
</html>