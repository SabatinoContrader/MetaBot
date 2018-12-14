<html>
<head>
<title>Login Trader</title>
</head>
<body>
	<div>
	
		<h3>1. Esempio</h3>
	<form action="EsempioServlet" method="post">
		<button type="submit" value="esempioManager" name="richiesta">
			bottone esempio</button>
	</form>
	
		<form action="LoginServlet" method="post">
			<h3>
				username: <input type="text" id="user" name="username"
					placeholder="inserisci username">
			</h3>
			<h3>
				password: <input type="password" id="pass" name="password"
					placeholder="inserisci password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Login</button>
			<br> <a href="register.jsp"> Registrati </a>
		</form>
	</div>
</body>
</html>