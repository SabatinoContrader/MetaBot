<html>
<head>
<title>Menu Principale METABOT</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
     <h1>BENVENUTO <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE METABOT -------</h2>
<table>
	<tr><th>  <form action="UserTypesServlet" method="post"> 1. UserTypes
	</th><th> <input type="submit" value="userTypesManagement" name="richiesta">  </form> </th></tr>
	<tr><th>  <form action="UsersServlet" method="post"> 2. Users
    </th><th> <input type="submit" value="usersManagement" name="richiesta"> </form> </th></tr>
	
	<tr><th>  <form action="BotMessageOptionsServlet" method="post"> 3. BotMessageOptions
	</th><th> <input type="submit" value="botMessageOptionsManagement" name="richiesta"> </form> </th></tr>
	   
	<tr><th>  <form action="BotMessagesServlet" method="post"> 4. BotMessages
</th><th> <input type="submit" value="botMessagesManagement" name="richiesta"> </form> </th></tr>
	   
	<tr><th>  <form action="ChatBotsServlet" method="post"> 5. ChatBots
</th><th>  <input type="submit" value="chatBotsManagement" name="richiesta"> </form> </th></tr>
	   
	<tr><th>  <form action="NodesServlet" method="post"> 6. Nodes
	  </th><th>  <input type="submit"value="nodesManagement" name="richiesta"> </form> </th></tr>
	
	<tr><th>  <form action="SubNodesServlet" method="post"> 7. SubNodes
	  </th><th>  <input type="submit" value="subNodesManagement" name="richiesta"> </form> </th></tr>
	
	<tr><th>  <form action="LogoutServlet" method="post"> 8. Logout
	 </th><th>   <input type="submit" value="Logout" name="richiesta"> </form> </th></tr>
</table>
</body>
</html>