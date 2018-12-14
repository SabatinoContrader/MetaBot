
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head any other head content must come *after* these tags -->
<title>Crea Chatbot</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/creaChatbot.css" rel="stylesheet">

<%
	List<NodesDTO> allNodesCurrentChat = (List<NodesDTO>) request.getAttribute("allNodesCurrentChat");
%>
</head>
<body>

	<h1 id="titoloPagina">Crea ChatBot</h1>
	<div class="container">
		<div class="bottoneAiuto">
			Aiuto
			<div class="descrizioneAiuto">//TODO</div>
		</div>


		<div class="row">
			<div class=" col-lg-5 col-md-5 col-xs-5">la chat</div>
			<div class=" col-lg-1 col-md-1 col-xs-1 divider-vertical"></div>
			<div id="" class=" col-lg-4 col-md-4 col-xs-4">i nodi</div>
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
					if(allNodesCurrentChat.isEmpty()){
						%>
					<form action="ChatbotServlet" method="post">
						<input type="submit" value="insertRootNode" name="richiesta">
					</form>
					<%}else{
						for (NodesDTO nodes : allNodesCurrentChat) {
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
					}
					%>
				</table>
			</form>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-3.1.1.min.js"></script>

	<!--  my js -->
	<script src="js/creaChatbot.js" type="text/javascript"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>