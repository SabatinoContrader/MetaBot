<%@ page import="com.virtualpairprogrammers.dto.UsersDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<UsersDTO> allUsers = (List<UsersDTO>) request.getAttribute("allUsers");
%>
</head>
<body>
	<h1>
		Benvenuto
		<%=request.getSession().getAttribute("utente")%></h1>
	<form action="InsertRedirectServlet" method="post">
		<input type="submit" value="usersInsert" name="richiesta">
	</form>

	<form action="Servlet" method="post">
		<table border="2">
			<tr>
				<th>ID</th>
				<th>username</th>
				<th>password</th>
				<th>ruolo</th>
			</tr>
			<%
				for (UsersDTO users : allUsers) {
			%>
			<tr>
				<td><%=users.getId()%></td>
				<td><%=users.getUsername()%></td>
				<td><%=users.getPassword()%></td>
				<td><%=users.getRuolo()%></td>

				<td>
					<form action="UpdateRedirectServlet" method="post">
						<input type="submit" value="usersUpdate" name="richiesta">
					</form>
				</td>
				<td><a
					href="UsersServlet?richiesta=delete&id=<%=users.getId()%>">Elimina</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>

		<input type="submit" value="Indietro" name="richiesta">
	</form>
</body>
</html>