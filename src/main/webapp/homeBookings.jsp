<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.pCarpet.dto.PrenotazioneDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>AMEBA</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->

<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

</head>

<body class="text-center">
	<!-- <form class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">
		Bookings Home
		</h1>
		<a class="btn btn-lg btn-primary btn-block"
		href="/Home/homeAssBadRead">Inserisci Prenotazione</a></br> 
		<a class="btn btn-lg btn-primary btn-block"
		href="/HomePrenotazione/showPrenotazione?choice=managementPrenotazioni">Visualizzazione Prenotazioni</a></br>
		<a class="btn btn-lg btn-primary btn-block"
		href="/Home/homeAssBadRead">Modifica Prenotazione</a></br>
		<a class="btn btn-lg btn-primary btn-block"
		href="/Home/homeAssBadRead">Elimina Prenotazione</a></br>
			 
		<a class="btn btn-lg btn-primary btn-block" href="/Home/homeDirectory?scelta=indietro">Indietro</a></br> 
		<a class="btn btn-lg btn-primary btn-block" href="/Login/logoutControl">Logout</a></br>

	</form> -->
	
	
	<form  class="form-signin" action="/HomePrenotazione/showPrenotazione" method="post">
	
	<table class="border rcorners" id="mytable">	
	
	
	
	
	<tr>
        <th></th>
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
         

     </tr>
	
        <c:forEach items="${listPrenotazione}" var="prenotazioni">
     	
         <td>
             
             	<c:out value="${prenotazioni.iduser}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${prenotazioni.idasset}"></c:out>
         </td>
         
         <td>
            <c:out value="${prenotazioni.orainizio}"></c:out>
         </td>

         <td>
             <c:out value="${prenotazioni.orafine}"></c:out>
         </td>

         
         
          <td>
          <a class="btn lg primary btn-block"
			href="/HomeUser/showUsers?choice=update&id=${user.iduser}">Modifica</a>
         </td>
         <td>
             <a class="btn lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=delete&id=${user.iduser}">Elimina</a>
         </td>
		
		
     	</tr>
     	
     	
     	</c:forEach>	
     
     
	</table>
	
	 <a class="btn lg btn-primary" 
	 href="/HomePrenotazione/showPrenotazione?choice=insert">
 	 Inserisci
 	 </a>
 	 
	<a class="btn lg btn-primary" 
		href="/HomePrenotazione/showPrenotazione?choice=indietro">Indietro</a>
 	
	</form>

</body>
</html>