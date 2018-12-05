<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.dto.UserDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Javascript -->
<script src="/css/googleApiManagerDriver.js"></script>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>


<form class="form-signin" action="/HomeUser/showUsers" method="post">

	<h1 class="element-margin-left">Ecco tutti gli utenti</h1>

		
		
		

<table class="bordo rcorners" >	
	     <tr>
     <th><h4>USERS</h4></th><td></td><td></td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td class="userimg"></td></tr>
     <tr>
	<tr>
        
         <th>
             ID utente
         </th>

         <th>
             Username
         </th>
         
         <th>
             Password
         </th>
         
         <th>
             Ragione Sociale
         </th>
         <th>
             Telefono
         </th>
         <th>
            Email
         </th>
         <th>
             Partita iva
         </th>
         <th>
            Ruolo
          </th>
          <th>
            Nome Abbonamento
          </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
	
        <c:forEach items="${users}" var="user">
     	
         <td>
             
             	<c:out value="${user.iduser}"></c:out>
             
         </td>
		 <td>
            <c:out value="${user.username}"></c:out>
         </td>
		 <td>
            <c:out value="${user.password}"></c:out>
         </td>

         <td>
             <c:out value="${user.ragioneSociale}"></c:out>
         </td>


         <td>
             <c:out value="${user.telefono}"></c:out>
         </td>
         <td>
             <c:out value="${user.mail}"></c:out>
         </td>
         <td>
            <c:out value="${user.partitaiva}"></c:out>
         </td>
         <td>
             <c:out value="${user.ruolo}"></c:out>
         </td>
         <td>
             <c:out value="${user.getAbbonamento().getNome()}"></c:out>
		</td>
		<td>
          
          <a class="btn lg btn-primary"
			href="/HomeUser/showUsers?choice=update&id=${user.iduser}">Modifica</a>
         </td>
         <td>
             <a class="btn lg btn-primary"
			href="/HomeUser/showUsers?choice=delete&id=${user.iduser}">Elimina</a>
         </td>
		
		
     </tr>
     </c:forEach>	
     
     
</table>

 <a class="btn lg btn-primary" href="/HomeUser/showUsers?choice=insert">
 	Inserisci
 </a>

<a class="btn lg btn-primary"
		href="/HomeUser/showUsers?choice=indietro">Indietro</a></br> 

</form>

</body>
</html>