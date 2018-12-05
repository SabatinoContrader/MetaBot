<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.virtualpairprogrammers.model.User"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<title>Insert title here</title>
<% User user = (User) request.getAttribute("allUsers");%>
</head>
<body>


<h2><center>------- UPDATE USER -------</center></h2>
<form action="CustomersServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>


<form action="CustomersServlet" method="post">
 <table>	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             USERNAME
         </th>
         <th>
             NOME
         </th>
         <th>
             COGNOME
         </th>
         <th>
             TELEFONO
         </th>
         <th>
            EMAIL
         </th>
         <th>
             PARTITA IVA
         </th>
         <th>
            RUOLO
          </th>

	</tr>
	<tr>
	
        <td>
             
             	<%= user.getIdutente()%>
             
         </td>

		<td>
             <%=  user.getUsername()%>
         </td>

         <td>
             <%=  user.getNome()%>
         </td>

         <td>
             <%=  user.getCognome()%>
         </td>

         <td>
             <%=  user.getTelefono()%>
         </td>
         <td>
             <%=  user.getMail()%>
         </td>.
         <td>
             <%=  user.getPartitaiva()%>
         </td>
         <td>
             <%=  user.getRuolo()%>
         </td>
         
     </tr>
   
     
</table>


<table>

	<tr>
	
		<td>
			<input type = "radio" value="username" name="campo">Username
		</td>
		
		<td>
			<input type = "radio" value="nome" name="campo">Nome
		</td>
		
		<td>
			<input type = "radio" value="cognome" name="campo">Cognome
		</td>
		
		<td>
			<input type = "radio" value="telefono" name="campo">Telefono
		</td>
		
		<td>
			<input type = "radio" value="mail" name="campo">Mail
		</td>
		
		<td>
			<input type = "radio" value="partitaiva" name="campo">Partita Iva
		</td>
		
		<td>
			<input type = "radio" value="ruolo" name="campo">Ruolo
		</td>
		
		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		<td>
			<h4>Inserisci il valore del nuovo campo: <input type = "text" id = "nuovoCampo" name ="nuovoCampo" placeholder = "inserisci nuovo campo"></h4>
		</td>
	</tr>

</table>
<%final int a= user.getIdutente();%>
         <input type="hidden" name="User" value="<%=a%>"/>
<button type="submit" value="updateUser" name="richiesta">Effettua Modifica
</button>

</form>

</body>
</html>