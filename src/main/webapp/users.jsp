<%@ page import="com.virtualpairprogrammers.model.User"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<User> allUsers = (List<User>) request.getAttribute("allUsers");
%>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>
		SEI LOGGATO COME:
		<%=request.getSession().getAttribute("utente")%></h1>
	<h2>------- MENU Users -------</h2>
	<form action="UsersServlet" method="post">
		<input type="submit" value="insert" name="richiesta">
	</form>

	<form action="UsersServlet" method="post">
		<table border="2">
			<tr>
				<th>ID</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>FIRSTNAME</th>
				<th>LASTNAME</th>
				<th>EMAIL</th>
				<th>RUOLO</th>
			</tr>
			<%
				for (User lista : allUsers) {
			%>
			<tr>
				<td><%=lista.getUserID()%></td>
				<td><%=lista.getUsername()%></td>
				<td><%=lista.getPassword()%></td>
				<td><%=lista.getFirstName()%></td>
				<td><%=lista.getLastName()%></td>
				<td><%=lista.getEmail()%></td>
				<td><%=lista.getUserTypeFK()%></td>
				<td><a
					href="UsersServlet?richiesta=update&id=<%=lista.getUserID()%>">Modifica</a></td>
				<td><a
					href="UsersServlet?richiesta=eliminaUsers&id=<%=lista.getUserID()%>">Elimina</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<h2></h2>
		<h2></h2>
		<input type="submit" value="Indietro" name="richiesta">
	</form>
	<h2></h2>
	<h2></h2>
	<form action="" method="post">
		<h3></h3>

	</form>
</body>
</html>