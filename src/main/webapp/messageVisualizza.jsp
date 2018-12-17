<%@ page import="com.virtualpairprogrammers.dto.MessageDTO"%>
<%@ page import="com.virtualpairprogrammers.utils.FunzioniDiUtilita"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<MessageDTO> allMessageDTO = (List<MessageDTO>) request.getAttribute("allMessageDTO");
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
			HashMap<MessageDTO, List<MessageDTO>> hashMessage = new HashMap<>();

			for (MessageDTO messageDTO : allMessageDTO) {
				if (!listaPadre.contains(messageDTO.getMessageFK().getMessageId())) {
					listaPadre.add(messageDTO.getMessageFK().getMessageId());
					List<MessageDTO> listaFigli = new ArrayList<>();
					hashMessage.put(messageDTO, listaFigli);
					for (MessageDTO lista2 : allMessageDTO) {
						if (messageDTO.getMessageFK().getMessageId() == lista2.getMessageFK().getMessageId()) {
							hashMessage.get(messageDTO).add(lista2);
						}
					}
				}
			}
		%>


		<table>
			<ul>
				<%
					for (MessageDTO allMess : allMessageDTO) {
						for (MessageDTO padre : hashMessage.keySet()) {
							if (allMess == padre) {
								
				%><li><%=padre.getMessageFK().getTesto()%><ul>
						<%
							List<MessageDTO> figli = hashMessage.get(padre);
										for (MessageDTO figlio : figli) {
						%><li><%=figlio.getTesto()%> <%
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