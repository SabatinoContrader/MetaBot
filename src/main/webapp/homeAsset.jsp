<html>
<head>
<title>Menu Principale AMEBA</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE AMEBA -------</h2>
     <h2>    <h2>

     <h3>1. Assets</h3>
     <form action="AssetServlet" method="post">
     <button type="submit" value="assetsManagement" name="richiesta">Asset</button>
     </form>
     
     <h3>2. Badge Readers</h3>
     <form action="BadgeReaderServlet" method="post">
     <button type="submit" value="badgesReaderManagement" name="richiesta">Badge Reader</button>
     </form>
     
     <h3>3. Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
     
       <h3>4. Logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>