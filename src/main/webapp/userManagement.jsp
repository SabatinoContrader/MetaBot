<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<User> allUsers = (List<User>) request.getAttribute("allUsers");%>

</head>

<body>

	<h2><center>------- MANAGEMENT USER -------</center></h2>
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
         <th>
          </th>
         <th>
          </th>

     </tr>
	
        <%for (User user : allUsers) { %>
     	<!--  
         <td>
             <input type="checkbox" name="users" value="<%= user.getIdutente()%>"/>
         </td>
		-->
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
         </td>
         <td>
             <%=  user.getPartitaiva()%>
         </td>
         <td>
             <%=  user.getRuolo()%>
         </td>
         <td>
             <a href="CustomersServlet?richiesta=update&id=<%= user.getIdutente() %>">Modifica</a>
         </td>
         <td>
             <a href="CustomersServlet?richiesta=deleteUser&id=<%= user.getIdutente() %>"  >
             	Elimina
             </a>
         </td>

     </tr>
     <% }%>
     
</table>
<a href="CustomersServlet?richiesta=insert" >
             	Inserisci
</a>
</form>

    
	

</body>
</html>