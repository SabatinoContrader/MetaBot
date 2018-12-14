<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<NodesDTO> allNodes = (List<NodesDTO>) request.getAttribute("allNodes");
%>
<h1>------Modifica Nodes------</h1>
</head>
<body>
	<h1>
		SEI LOGGATO COME:
		<%=request.getSession().getAttribute("utente")%></h1>

	<form action="NodesServlet" method="post">
		<table border="2">
			<tr>
				<th>Id</th>
				<th>text</th>
				<th>nodoPadre</th>
			</tr>
			<%
				for (NodesDTO lista : allNodes) {
			%>
			<tr>

				<td> <input type="radio" name="id" value="<%=lista.getId()%>"></td>
				<td><%=lista.getText()%></td>
				<td><%=lista.getIdNodoPadre()%></td>
				<%
					}
				%>
			
		</table>
		<table>
			<tr>
				<td><h2>Inserisci il nuovo valore del testo</h2></td>
				<td><input type="text" name="text"
					placeholder="Nuovo valore"></td>
			</tr>
		</table>
		<table>
			<tr>
				<input type="submit" value="update" name="richiesta">
			</tr>
		</table>
	</form>
	<form action="NodesServlet" method=post>
		<button type="submit" value="Indietro" name="richiesta">Indietro</button>
	</form>
</body>
</html>