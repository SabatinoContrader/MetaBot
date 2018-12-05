<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.dto.BadgeDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Javascript -->
<script src="/css/googleApiManagerDriver.js"></script>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form class="form-signin" action="/Badge/HomeBadge" method="post">
	<h1 class="element-margin-left">Elenco badges</h1>
	
<table class="border rcorners">	
	
	
	<tr><th><h4>Badges</h4></th><td></td><td></td><td></td><td class="imgB"></td></tr>
	<tr>
        
         <th>
             ID badge
         </th>

         <th>
             Tipologia
         </th>
         
         <th>
              Descrizione
         </th>
         </tr>
          <c:forEach items="${badges}" var="badge">
     	
         <td>
             
             	<c:out value="${badge.idBadge}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${badge.descrizione}"></c:out>
         </td>
         
         <td>
            <c:out value="${badge.tipologia}"></c:out>
         </td>
                  </td>
         
         <td>
          
          <a class="btn lg btn-primary btn-block"
			href="/Badge/modificaBadgeRedirect?id=${badge.idBadge}">Modifica</a>
         </td>
         <td>
             <a class="btn lg btn-primary btn-block"
			href="/Badge/HomeBadge?scelta=delete&id=${badge.idBadge}">Elimina</a>
         </td>
     </tr>
     </c:forEach>	
     </table>
<table>
<tr><td>
 <a class="btn lg btn-primary" 
 href="/Badge/HomeBadge?scelta=insert&id=${badge.idBadge}">Inserisci</a>
</td>
<td>
<a class="btn lg btn-primary" 
		href="/Badge/HomeBadge?scelta=indietro">Indietro</a>
</td></tr>
</table>
</body>
     
</html>