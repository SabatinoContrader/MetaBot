<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.dto.PrenotazioneDTO"%>
<%@ page import="com.pCarpet.dto.AssetDTO"%>
<%@ page import="com.pCarpet.dto.UserDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>   
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>   
    <!-- jquery validazioni //-->   
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"></script>   
<script type="text/javascript" src="/validate/validation_prenot.js">




</script> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>



<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

</head>
<body>

	<h2><center>Inserisci la tua prenotazione</center></h2>
 
 </br>
 		<table class="border rcorners" align="left">	
	<tr><th><h4>ASSETS</h4></th><td></td><td></td><td></td></tr>
	<tr>
        
         <th>
             Id Asset
         </th>

         <th>
             Descrizione
         </th>
         
         <th>
             Tipo
         </th>
         
         <th>
             Prezzo
         </th>

     </tr>
	<!--  $allassets collegato a riga 37 di asset controller -->
        <c:forEach items="${listAssets}" var="asset">
     	
         <td>
             
             	<c:out value="${asset.idAsset}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${asset.tipo}"></c:out>
         </td>
         
         <td>
            <c:out value="${asset.descrizione}"></c:out>
         </td>

         <td>
             <c:out value="${asset.prezzo}"></c:out>
         </td>		
     </tr>
     </c:forEach>	
     
     
</table>

 		<table class="border rcorners" align=right">	
	<tr><th><h4>USERS</h4></th><td></td><td></td><td class="userimg"></td></tr>
	<tr>
        
         <th>
             Id User
         </th>

         <th>
             Username
         </th>
         
         <th>
             Ragione Sociale
         </th>
         
         <th>
             Partita iva
         </th>

     </tr>
	<!--  $allassets collegato a riga 37 di asset controller -->
        <c:forEach items="${listUsers}" var="user">
     	
         <td>
             
             	<c:out value="${user.iduser}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${user.username}"></c:out>
         </td>
         
         <td>
            <c:out value="${user.ragioneSociale}"></c:out>
         </td>

         <td>
             <c:out value="${user.partitaiva}"></c:out>
         </td>		
     </tr>
     </c:forEach>	
</table>







	<form class="form-signin" action="/HomePrenotazione/showPrenotazione" method="post" id="form_prenot">
     
     <div id="container">
     <div id="left">
     <table class="border rcorners" id="mytable">	
	
		
	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             ID ASSET
         </th>
         
         <th>
             ORA INIZIO
         </th>
         
         <th>
             ORA FINE
         </th>
         
         <th>
         	EFFETTUA MODIFICHE
          </th>

     </tr>
	
        <c:forEach items="${listPrenotazione}" var="prenotazioni">
     	
         <td>
             
             	<c:out value="${prenotazioni.getUser().getIduser()}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${prenotazioni.getAsset().getIdAsset()}"></c:out>
         </td>
         
         <td>
           <input type="datetime-local" class="labcor" value="<c:out  value="${prenotazioni.orainizio}"> </c:out>" disabled>
         </td>

         <td>
            <input type="datetime-local" class="labcor" value="<c:out value="${prenotazioni.orafine}"> </c:out>" disabled>
         </td>

         
          <td>
          <a class="btn lg btn-primary btn-block"
			href="/HomePrenotazione/showPrenotazione?choice=update&idP=${prenotazioni.getIdprenotazione()}">Modifica</a>
         </td>
         
         
<%--          <td>
             <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=delete&id=${user.iduser}">Elimina</a>
         </td> --%>
		
		
     	</tr>
     	</c:forEach>	
     
     
	</table>
    </div>
    </div>
    
    </br>
    
     
  	 <div id="right">
  	 
     <table id="mytable">
     	<tr><td>
     	<h4>ID UTENTE: <input type = "text" id = "iduser" class="labcor" name ="iduser" placeholder = "Inserisci ID utente" ></h4>
     	</td>
     	
     	<td>
     	<h4>ID ASSET: <input type = "text" id = "idasset" class="labcor" name ="idasset" placeholder = "Inserisci ID asset" ></h4>
     	</td>
     	
     	<td>
     	<h4>ORA INIZIO: <input type="datetime-local" class="labcor" name="orainizio" required autofocus></h4>
     	</td>
     	
     	<td>
     	<h4>ORA FINE: <input type="datetime-local"  class="labcor" name="orafine" required autofocus></h4>
		</td></tr>
			
		
		</table>
	<table border="0">
		<tr>
		<td>
		<button class="btn lg btn-primary" type="submit" value="insert" name="choice">Inserisci</button>
		</td>
		
	    <td>
		<a class="btn lg btn-primary" 
		href="/HomePrenotazione/showPrenotazione?choice=indietroManagementBookings">Indietro</a></br>
		</td>
		</tr>
     </table>
     
    </div>
  
     </br>
     
     
     
     
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