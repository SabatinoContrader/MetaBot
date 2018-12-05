<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><center>------- INSERT BADGE -------</center></h2>
<form action="BadgeServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>
	
	<h3>Inserisci i dati del badge</h3>
     <form action="BadgeServlet?richiesta=insertBadge" method="post">
     	
     	<h4>Descrizione: <input type = "text" id = "user" name ="descrizione" placeholder = "inserisci descrizione"></h4>
     	
     	<h4>Tipologia: <input type = "text" id = "user" name ="tipologia" placeholder = "inserisci tipologia"></h4>
     	
     	
     	
     	<input type="submit" value="Inserisci Badge" name="richiesta">
     	
     </form>
	
</body>
</html>