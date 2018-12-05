<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2><center>------- INSERT USER -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>

     <h3>Inserisci i dati dell'utente</h3>
     <form action="CustomersServlet?richiesta=insertUser" method="post">
     	
     	<h4>Username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h4>
     	
     	<h4>Password: <input type = "password" id = "user" name ="password" placeholder = "inserisci la password"></h4>
     	
     	<h4>Nome: <input type = "text" id = "user" name ="nome" placeholder = "inserisci nome"></h4>
     	
     	<h4>Cognome: <input type = "text" id = "user" name ="cognome" placeholder = "inserisci cognome"></h4>
     	
     	<h4>Telefono: <input type = "text" id = "user" name ="telefono" placeholder = "inserisci telefono"></h4>
     	
     	<h4>Mail: <input type = "text" id = "user" name ="mail" placeholder = "inserisci mail"></h4>
     	
     	<h4>Partita iva: <input type = "text" id = "user" name ="partitaiva" placeholder = "inserisci partita iva"></h4>
     	
     	<h4>Ruolo: <input type = "text" id = "user" name ="ruolo" placeholder = "inserisci ruolo"></h4>

     	
     	<input type="submit" value="Inserisci Utente" name="richiesta">
     	
     </form>

     

</body>
</html>