<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HomeNodo</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<form class="example" action="/Chatbot/cercaChatbot" method="get">
  <input type="text" placeholder="Search.." name="search">
  <button type="submit">Cerca<i class="fa fa-search"></i></button>
</form>
 
 <jstl:forEach items="${chatbots}" var="chatbot">
				<tbody>
					<tr>
						<td><jstl:out value="${chatbot.nomeChatbot}"></jstl:out></td>
						
						
					</tr>
				</tbody>
			</jstl:forEach>
















</body>
</html>