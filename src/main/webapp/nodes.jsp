<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<NodesDTO> allNodes = (List<NodesDTO>) request.getAttribute("allNodes");
%>
</head>
<body>
	<h1>
		Benvenuto
		<%=request.getSession().getAttribute("utente")%></h1>
	<form action="InsertRedirectServlet" method="post">
		<input type="submit" value="nodesInsert" name="richiesta">
	</form>

	<form action="NodesServlet" method="post">
		<table border="2">
			<tr>
				<th>ID</th>
				<th>text</th>
				<th>idNodoPadre</th>
			</tr>
			<%
				for (NodesDTO nodes : allNodes) {
			%>
			<tr>
				<td><%=nodes.getId()%></td>
				<td><%=nodes.getText()%></td>
				<td><%=nodes.getIdNodoPadre()%></td>

				<td>
					<form action="UpdateRedirectServlet" method="post">
						<input type="submit" value="nodesUpdate" name="richiesta">
					</form>
				</td>
				<td><a
					href="NodesServlet?richiesta=delete&id=<%=nodes.getId()%>">Elimina</a>
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