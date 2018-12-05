<html>
<head>
<title>Menu Principale AMEBA</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU LOGS -------</h2>
     <h2>    <h2>

     <h3>1. Logs</h3>
     <form action="MovimentoServlet" method="post">
     <input type="submit" value="movimentiManagement" name="richiesta">
     </form>
     
     <h3>2. Export</h3>
     <form action="MovimentoServlet" method="post">
     <input type="submit" value="export" name="richiesta">
     </form>
     
     <h3>3. Indietro</h3>
     <form action="MovimentoServlet" method="post">
     <input type="submit" value="indietro" name="richiesta">
     </form>
     
       <h3>4.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>