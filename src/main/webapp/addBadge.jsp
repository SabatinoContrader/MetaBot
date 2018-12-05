<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>   
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>   
    <!-- jquery validazioni //-->   
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"></script>   
<script type="text/javascript" src="/validate/validation_badge.js">
</script>  
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>


	<h3>Inserisci i dati del badge</h3>
     <form action="/Badge/addBadge" method="post" id= badge_insert>
     	
     	 <table class="border rcorners">
     	 
     	 <tr><th><h4>Inserimento Badge</h4></th><td class="imgB"></td><td></td> </tr>
     	 <tr>
     	<th>Descrizione: </th><td><textarea type = "text" id = "user" name ="descrizione" placeholder = "inserisci descrizione" ></textarea></td></tr>
     	<tr>
     	<tr><th>Tipologia:</th> <td>
		<select id="user" name = "tipologia">
		<option value ="PVC_ISO7810">PVC_ISO7810</option>
		</select>
		</td></tr>
     	
		</table>
		<table>
		<tr>
		<td>	
		<button class="btn lg btn-primary" type="submit">Inserisci Badge</button>
		</td><td>
		<a class="btn lg btn-primary" 
		href="/Badge/HomeBadge?scelta=indietrobadgemanagement">Indietro</a></br>
     </td></tr>
     </table>
     	
     	
     </form>
	
</body>
</html>