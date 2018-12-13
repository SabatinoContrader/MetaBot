<%@ page import="com.virtualpairprogrammers.model.User"%>
<%@ page import="com.virtualpairprogrammers.model.UserType"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>
		SEI LOGGATO COME:
		<%=request.getSession().getAttribute("utente")%></h1>
		<h2>Crea nuovo utente</h2>
	<form action="UsersServlet" method="post">

		<h3>
			Username<input type="text" name="username">
		</h3>
		<h3>
			Password<input type="text" name="password">
		</h3>
		<h3>
			firstName<input type="text" name="firstName">
		</h3>
		<h3>
			lastName<input type="text" name="lastName">
		</h3>
		<h3>
			email<input type="text" name="email">
		</h3>
		<h3>
			userTypeFK<input type="text" name="userTypeFK">
		</h3>


		<input type="submit" value="insertUser" name="richiesta">
	</form>
</body>
</html>