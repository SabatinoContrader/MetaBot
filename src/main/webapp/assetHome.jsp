<%@ page import="java.util.List"%>
<%@ page import="com.pCarpet.dto.AssetDTO"%>
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


<form class="form-signin" action="/Asset/homeAsset" method="post">

	<h1 class="element-margin-left">Ecco tutti gli asset</h1>

		
		
		

		<table class="border rcorners">	
	<tr><th><h4>ASSETS</h4></th><td></td><td></td><td></td><td></td><td></td></tr>
	<tr>
        
         <th>
             Id Asset
         </th>

         <th>
             Tipo
         </th>
         
         <th>
             Prezzo
         </th>
         
         <th>
             Descrizione
         </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
	<!--  $allassets collegato a riga 37 di asset controller -->
        <c:forEach items="${allAssets}" var="asset">
     	
         <td>
             
             	<c:out value="${asset.idAsset}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${asset.tipo}"></c:out>
         </td>
         
         <td>
            <c:out value="${asset.prezzo}"></c:out>
         </td>

         <td>
             <c:out value="${asset.descrizione}"></c:out>
         </td>

         <td>
          
          <a class="btn lg btn-primary btn-block"
			href="/Asset/homeAsset?scelta=update&id=${asset.idAsset}">Modifica</a>
         </td>
         <td>
             <a class="btn lg btn-primary btn-block"
			href="/Asset/homeAsset?scelta=delete&id=${asset.idAsset}">Elimina</a>
         </td>
		
		
     </tr>
     </c:forEach>	
     
     
</table>

 <a class="btn lg btn-primary" href="/Asset/homeAsset?scelta=insert">
 	Inserisci
 </a>

<a class="btn lg btn-primary" 
		href="/Asset/homeAsset?scelta=indietroAssBad">Indietro</a></br> 

</body>
</html>