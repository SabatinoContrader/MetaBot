<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

</head>
<body>
	

	<h2>Modifica la prenotazione</h2>
 
 </br>
 
<form action="/HomePrenotazione/showPrenotazione" method="post">
        
<table class="bordo rcorners">	
	<tr>
        
         <th>
             Id Utente
         </th>

         <th>
             Id Asset
         </th>
         
         <th>
             Ora inizio
         </th>
         
         <th>
             Ora fine
         </th>
         

	</tr>
	<tr>
	
       	<tr>
	
        <td>
            <input type="text" value="${p.getUser().getIduser()}" name="id1" disabled class="labcor">
         </td>

		<td>
             <input type="text" value="${p.getAsset().getIdAsset()}" name="id2" disabled class="labcor">
         </td>
         
         <td>
            <input type="datetime-local" value="${p.orainizio}" name="orainizio" class="labcor">
         </td>

         <td>
             <input type="datetime-local" value="${p.orafine}" name="orafine" class="labcor">
         </td>
         
     </tr>
   
     
</table>

</br>

<table>	

	<tr>		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		
		
	</tr>

</table>

</br>
<input type="hidden" value="${p.getUser().getIduser()}" name="id1">
<input type="hidden" value="${p.getAsset().getIdAsset()}" name="id2">
<button class="btn btn-lg btn-primary" type="submit" value="update" name="choice">Effettua Modifica</button>

<a class="btn btn-lg btn-primary" 
		href="/HomePrenotazione/showPrenotazione?choice=indietro">Indietro</a></br>


 <c:choose>
     
			<c:when test="${feedback == 'success'}">
				<div class="alert alert-success">
    				<strong>Success!</strong> Registrazione effettuata con successo.
  				</div>
			</c:when>
			
			<c:when test="${feedback == 'wrong'}">
				<div class="alert alert-danger">
    				<strong>Error!</strong> Prenotazione già presente o data errata, riprova.
  				</div>
			</c:when>
			
</c:choose>

</form>


</body>
</html>