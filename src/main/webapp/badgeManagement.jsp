<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.virtualpairprogrammers.model.Badge"%>
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
<% List<Badge> allBadge = (List<Badge>) request.getAttribute("allBadges");%>
</head>
<body>
<h2><center>------- MANAGEMENT BADGE -------</center></h2>
<form action="BadgeServlet?richiesta=home" method="post">
	<input type="submit" value="HOME" name="richiesta">
</form>
	
<form action="BadgeServlet" method="post">
 <table>	
	
	<tr>
        
         <th>
             ID BADGE
         </th>

         <th>
             TIPOLOGIA
         </th>
         <th>
             DESCRIZIONE
         </th>
         
         <th>
          </th>
         <th>
          </th>

     </tr>
	
        <%for (Badge badge : allBadge) { %>
     	
         <td>
             
             	<%= badge.getIdBadge()%>
             
         </td>

		<td>
             <%=  badge.getDescrizione()%>
         </td>

         <td>
             <%=  badge.getTipologia()%>
         </td>

         
         <td>
             <a href="BadgeServlet?richiesta=update&id=<%= badge.getIdBadge() %>">Modifica</a>
         </td>
         <td>
             <a href="BadgeServlet?richiesta=deleteBadge&id=<%= badge.getIdBadge() %>"  >
             	Elimina
             </a>
         </td>

     </tr>
     <% }%>
     
</table>
<a href="BadgeServlet?richiesta=insert" >
             	Inserisci
</a>
</form>
	
	
</body>
</html>