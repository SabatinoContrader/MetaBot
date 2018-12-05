<%@ page import="com.virtualpairprogrammers.model.Assegnazione" %>
<%@ page import="com.virtualpairprogrammers.model.User" %>
<%@ page import="com.virtualpairprogrammers.model.Badge" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Assegnazione> allAssegnazioni = (List<Assegnazione>) request.getAttribute("visualAssegnazioni");%>
 	<% List<User> allUsers = (List<User>) request.getAttribute("visualUsers");%>
 	<% List<Badge> allBadges = (List<Badge>) request.getAttribute("visualBadges");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>
<form action="AssegnazioneServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>

 <table border="2">
     <tr>
         <th>
             ID User
         </th>

         <th>
             ID Badge
         </th>
         <th>
             Data Assegnazione
         </th>
       


     </tr>
        <%for (Assegnazione ass : allAssegnazioni) { %>
     <tr>

         <td>
             <%= ass.getIdUtente()%>
         </td>

         <td>
             <%=  ass.getIdBadge()%>
         </td>

         <td>
             <%=  ass.getData()%>
         </td>

    
          
         <td>
            <a href="AssegnazioneServlet?richiesta=delete&idUser=<%=  ass.getIdUtente()%>&idBadge=<%=ass.getIdBadge() %>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
  </br>
 </form>
 
<form action="AssegnazioneServlet" method="post">
 
  <table border="2">
     <tr>
     
     	<th>
     	</th>
         <th>
             ID User
         </th>

         <th>
             Username
         </th>
         <th>
             Nome
         </th>
         <th>
             Cognome
         </th>
          <th>
             Partita Iva
         </th>


     </tr>
        <%for (User u : allUsers) { %>
     <tr>
	
		<td>
			<input type="radio" name="user" value="<%= u.getIdutente()%>"/>
		</td>
		
         <td>
             <%= u.getIdutente()%>
         </td>

         <td>
             <%=  u.getUsername()%>
         </td>

         <td>
             <%=  u.getNome()%>
         </td>

         <td>
             <%=  u.getCognome()%>
         </td>
         
          <td>
             <%=  u.getPartitaiva()%>
         </td>

        

     </tr>
     <% }%>
 </table>
 
 
 </br>
 
  <table border="2">
     <tr>
     	<th>
     		
     	</th>
         <th>
             ID Badge
         </th>


         <th>
             Descrizione
         </th>
         <th>
             Tipologia
         </th>


     </tr>
        <%for (Badge b : allBadges) { %>
     <tr>
		
		<td>
		
		<input type="radio" name="badge" value="<%= b.getIdBadge()%>"/>
		</td>
		
         <td>
             <%= b.getIdBadge()%>
         </td>

         <td>
             <%=  b.getDescrizione()%>
         </td>


         <td>
             <%=  b.getTipologia()%>
         </td>

          

     </tr>
     <% }%>
 </table>
  </br>
 <button type="submit" value="insert" name="richiesta">Assegna</button>
 </form>
 
 <form action="AssegnazioneServlet" method=post>
<button type="submit" value="indietro" name="richiesta">Indietro</button>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>


 </body>
</html>