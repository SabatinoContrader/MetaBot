<%@ page import="com.pCarpet.dto.AssegnazioneDTO" %>
<%@ page import="com.pCarpet.dto.BadgeDTO" %>
<%@ page import="com.pCarpet.dto.UserDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
 <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">


     <% List<AssegnazioneDTO> allAssegnazioni = (List<AssegnazioneDTO>) request.getAttribute("visualAssegnazioni");%>
 	<% List<UserDTO> allUsers = (List<UserDTO>) request.getAttribute("visualUsers");%>
 	<% List<BadgeDTO> allBadges = (List<BadgeDTO>) request.getAttribute("visualBadges");%>
 </head>
 <body class="text-center">
 <table class="bordo rcorners" width="500px">
 <tr><th><h4>ASSEGNAZIONI</h4></th><td></td></tr>
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
         <th>
         	Nome
         </th>
         <th>
        	Cognome
         </th>
       


     </tr>
        <%for (AssegnazioneDTO ass : allAssegnazioni) { %>
     <tr>

         <td>
             <%= ass.getUser().getIduser()%>
         </td>

         <td>
             <%=  ass.getBadge().getIdBadge()%>
         </td>

         <td>
            <input type="datetime-local" class="labcor" value="<%=  ass.getDataassegnazione()%>" disabled>
         </td>
<td>
<%=ass.getNome()%>
</td>
<td>
<%= ass.getCognome() %>
    </td>
          
         <td>
            <a class="btn lg btn-primary" href="/Assegnazione/homeAssegnazione?scelta=rimuovi&idUser=<%=  ass.getUser().getIduser()%>&idBadge=<%=ass.getBadge().getIdBadge() %>">Rimuovi</a>
         </td>

     </tr>
     <% }%>
 </table>
  <br>
 
<form action="/Assegnazione/homeAssegnazione" method="post" class="form-signin">
 
  <table class="bordo rcorners" width="500px">
     <tr>
     <th><h4>USERS</h4></th><td></td><td></td><td></td><td class="userimg"></td></tr>
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
             Ragione Sociale
         </th>
          <th>
             Partita Iva
         </th>
	 </tr>
        <%for (UserDTO u : allUsers) { %>
     <tr>
	
		<td>
			<input type="radio" name="user" value="<%= u.getIduser()%>"/>
		</td>
		
         <td>
             <%= u.getIduser()%>
         </td>

         <td>
             <%=  u.getUsername()%>
         </td>

         <td>
             <%=  u.getRagioneSociale()%>
         </td>
         
          <td>
             <%=  u.getPartitaiva()%>
         </td>

        

     </tr>
     <% }%>
 </table>
 
 
 </br>
 
  <table class="bordo rcorners" width="500" border="0">
  <tr>
  <th><h5 align="left">BADGES LIBERI</h5></th><td></td><td></td><td></td><td class="imgB"></td>
  </tr>
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
        <%for (BadgeDTO b : allBadges) { %>
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
 </table><br>
 <table class="bordo rcorners" width="500" border="0">
 <tr>
 	<h4>Inserire nome e cognome dell'utente a cui assegnare il badge</h4>
 	</tr><tr></tr>
 	<tr>
 	<th><h4>Nome:</h4></th><th></th><td> <input type = "text" id = "nome" name ="nome" placeholder = "inserisci nome"></td>
 	<th><h4>Cognome:</h4></th><th></th><td> <input type = "text" id = "cognome" name ="cognome" placeholder = "inserisci cognome"></td>
 	</tr>
 
 </table>
  </br>
<table>
<tr>
 <td><button class="btn btn-lg btn-primary" type="submit" value="insert" name="scelta">Assegna</button>
</td>
 </form>
 
 
 <form action="/Assegnazione/homeAssegnazione" method=get class="form-signin">

<td><button class="btn lg btn-primary" type="submit" value="indietro" name="scelta">Indietro</button>
</td></tr>
</form>
</table>


 </body>
</html>