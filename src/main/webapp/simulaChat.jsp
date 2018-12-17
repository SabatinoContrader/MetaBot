<%@ page import="com.virtualpairprogrammers.dto.NodesDTO"%>
<%@ page import="com.virtualpairprogrammers.utils.FunzioniDiUtilita"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%
	List<NodesDTO> allNodesDTO = null;
    if (request.getAttribute("list") != null){
    	allNodesDTO = (List<NodesDTO>) request.getAttribute("list");
    }
    String foglia = "";
	if (request.getAttribute("foglia") != null){
		foglia = request.getAttribute("foglia").toString();
	}
//System.out.println(allMessageDTO);
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
	<% if (foglia == ""){%>
	<%for (NodesDTO messageDTO : allNodesDTO){
		%>
			<form action="MessageServlet">
			<div><%=messageDTO.getText()%>
				<input type="submit" value="NovoChat"
					name="richiesta">
				
				<input type="hidden" value="<%=messageDTO.getId()%>"
					name="prossimoPadre">
			
			</form>
		
	<%
	}
	
	%>
		<%	}%>

<form action="MessageServlet" method="post">
		<input type="submit" value="Indietro" name="richiesta">
	</form>
	
	
	<h2></h2>
	<h2></h2>
</body>
</html>