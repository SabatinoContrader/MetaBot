<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>   
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>   
    <!-- jquery validazioni //-->   
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"></script>   
<script type="text/javascript" src="/validate/validation_user.js">
</script>  
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js" type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>
 <h2>Inserisci i dati dell'utente</h2>
 
 <br>
 
     <form action="/HomeUser/showUsers" method="post" id="form_register">
     
     	
     
        <table class="border rcorners">
        <tr><th><h4>Inserimento User</h4></th><td class="userimg"></td><td></td><td></td></tr>
        <tr>
     	<th>Username:</th> <td><input type = "text" id = "username" name ="username" placeholder = "inserisci username"></td></tr>
     	
     	<tr><th>Password:</th> <td> <input type = "password" id = "password" name ="password" placeholder = "inserisci la password"></td></tr>
     	
     	<tr><th>Ragione Sociale:</th> <td> <input type = "text" id = "user" name ="ragioneSociale" placeholder = "inserisci ragione sociale"></td></tr>
     	
     	<tr><th>Telefono:</th> <td> <input type = "text" id = "telefono" name ="telefono" placeholder = "inserisci telefono"></td></tr>
     	
     	<tr><th>Mail:</th> <td> <input type = "text" id = "mail" name ="mail" placeholder = "inserisci mail"></td></tr>
     	
     	<tr><th>Partita iva:</th> <td> <input type = "text" id = "partitaiva" class="partitaiva" name ="partitaiva" placeholder = "inserisci partita iva"></td></tr>
     	
     	<tr><th>Ruolo:</th> <td><select id="ruolo" name = "ruolo">
		<option value ="segretaria">Segretaria</option>
		<option value ="cliente">Cliente</option>
		<option value ="owner">Owner</option>
		</select></td></tr>

		<tr><th>Nome Abbonamento:</th> <td>
		<select id="user" name = "nomeAbb">
		<option value ="3">gold</option>
		<option value ="2">silver</option>
		<option value ="1">normale</option>
		<option value ="4">business</option></select>
		</td></tr>

		<%-- ${User u= new User(0,username,password,nome,congome,telefono,mail,partitaiva,ruolo,nomeAbb)}
         <input type="hidden" name="User" value="${u}"/> --%>
		
     	<%-- <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=insertUser&User=${u}">Inserisci</a> --%>
			
		<button class="btn lg btn-primary" type="submit"  value="insert" name="choice">Inserisci</button>
		
		<a class="btn lg btn-primary" 
		href="/HomeUser/showUsers?choice=indietroManagementUser">Indietro</a></br>
     </table>
     </form>
     
</body>
</html>