<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

</head>
<body>
	<form action="NodesServlet" method="post">
		<table>


			<tr>
				<td><h3>Id</h3></td>
				<td>
					<h3>
						<input type="text" name="id">
					</h3>
				</td>
			</tr>
			<tr>
				<td><h2>text</h2></td>
				<td>
					<h3>
						<input type="text" name="text">
					</h3>
				</td>
			</tr>

			<tr>
				<td><h3>id Nodo Padre</h3></td>
				<td>
					<h3>
						<input type="text" name="idNodoPadre">
					</h3>
				</td>
			</tr>

		</table>
			<tr>
				<input type="submit" value="insert" name="richiesta">
			</tr>
	</form>

	<form action="NodesServlet" method="post">
		<input type="submit" value="Indietro" name="richiesta">
	</form>

</body>
</html>