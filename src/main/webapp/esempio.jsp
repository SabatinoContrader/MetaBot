<%@ page import="com.virtualpairprogrammers.dto.EsempioDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<EsempioDTO> allEsempi = (List<EsempioDTO>) request.getAttribute("allEsempi");
%>
</head>
<body>
	<h1>
		Benvenuto
		<%=request.getSession().getAttribute("utente")%></h1>


			<%
				for (EsempioDTO esempi : allEsempi) {
			%>
			<tr>
				<td><%=esempi.getColonna_id_esempio()%></td>
				<td><%=esempi.getColonna2_esempio()%></td>

			
			</tr>
			<%
				}
			%>

		<input type="submit" value="Indietro" name="richiesta">
</body>
</html>