<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

<script>var flag=false;</script>

</head>
<body>

<h2>Inserisci i dati dell'utente</h2>
 
 </br>
 
<form action="/HomeUser/showUsers" method="post">
        
<table class="bordo rcorners">	
	<tr>
        
         <th>
             Id Utente
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
            Nome abbonamento
          </th>
	</tr>
	<tr>
	
        <td>
           <input type="text" id = "iduser" value="${user.iduser}" disabled class="labcor" text-align="center">
         </td>

		<td>
             <input type="text" id = "username" value="${user.username}" name="username"class="labcor">
         </td>
         
         <td>
              <input type="text" id = "nome" value="${user.password}" name="password" class="labcor">
         </td>

         <td>
              <input type="text" id = "cognome" value="${user.ragioneSociale}" name="ragioneSociale" class="labcor">
         </td>

         <td>
              <input type="text" id = "telefono" value="${user.telefono}" name="telefono" class="labcor">
         </td>
         <td>
              <input type="text" id = "mail" value="${user.mail}" name="mail" class="labcor">
         </td>
         <td>
              <input type="text" id = "partitaiva" value="${user.partitaiva}" name="partitaiva" class="labcor">
         </td>
         <td>
             <select id="ruolo" name="ruolo" class="labcor">
        <option value="${user.ruolo}">${user.ruolo}</option>
        <option value ="segretaria">segretaria</option>
		<option value ="cliente">cliente</option>
		<option value ="owner">owner</option>
		</select>
         </td>
          <td>
             <select id="nomeAbb" name="nomeAbb" class="labcor">
        <option value="${user.getAbbonamento().getNome()}">${user.getAbbonamento().getNome()}</option>
        <option value ="3">gold</option>
		<option value ="2">silver</option>
		<option value ="1">normale</option>
		<option value ="4">business</option></select>
         </td>
     </tr>
   
     
</table>

</br>

</br>
<input type="hidden" value="${user.iduser}" name="id">
<button class="btn btn-lg btn-primary" type="submit" value="update" name="choice">Effettua Modifica</button>

<a class="btn btn-lg btn-primary" 
		href="/HomeUser/showUsers?choice=indietroManagementUser">Indietro</a></br>

</form>

</body>
</html>