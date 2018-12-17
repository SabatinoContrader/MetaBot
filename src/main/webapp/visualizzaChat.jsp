<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page import="com.virtualpairprogrammers.utils.FunzioniDiUtilita"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<NodesDTO> allNodesDTO = (List<NodesDTO>) request.getAttribute("allNodesDTO");
	String sChat = request.getSession().getAttribute("sChatID").toString();
%>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>
		SEI LOGGATO COME:
		<%=request.getSession().getAttribute("utente")%></h1>
	<h2>
		------- MENU Message DI CHAT:
		<%=sChat%>
		-------
	</h2>

	<form action="MessageServlet" method="post">
		<%
			List<Integer> listaPadre = new ArrayList<>();
			HashMap<Integer, List<NodesDTO>> hashMessage = new HashMap<>();

			for (NodesDTO NodesDTO : allNodesDTO) {
				if (!listaPadre.contains(NodesDTO.getIdNodoPadre())) {
					listaPadre.add(NodesDTO.getIdNodoPadre());
					List<NodesDTO> listaFigli = new ArrayList<>();
					hashMessage.put(NodesDTO.getIdNodoPadre(), listaFigli);
					for (NodesDTO lista2 : allNodesDTO) {
						if (NodesDTO.getIdNodoPadre() == lista2.getIdNodoPadre()) {
							hashMessage.get(NodesDTO.getIdNodoPadre()).add(lista2);
						}
					}
				}
			}
		%>


		<table>
			<ul>
				<%
					for (NodesDTO allMess : allNodesDTO) {
						for (Integer padre : hashMessage.keySet()) {
							if (allMess.getIdNodoPadre() == padre) {
								
				%><li><%=padre%><ul>
						<%
							List<NodesDTO> figli = hashMessage.get(padre);
										for (NodesDTO figlio : figli) {
						%><li><%=figlio.getText()%> <%
 	}
 			}
 %></li>
					</ul> <%
 	}
 	}
 %></li>
			</ul>
		</table>
		<input type="submit" value="Indietro" name="richiesta">
	</form>
	<h2></h2>
	<h2></h2>
<form action="MessageServlet" method=post>
<button type="submit" value="simulaChat" name="richiesta" class="btn">Simula Chat</button>
</form>
</body>
</html>