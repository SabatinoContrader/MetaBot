<%@ page import="com.virtualpairprogrammers.dto.ChatbotsDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.virtualpairprogrammers.dto.UsersDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function unhideInsertForm(){
            if(document.getElementById('insBtn').innerText == 'Nuovo Chatbot'){
                document.getElementById('divInsCB').style = "display: block;";
                document.getElementById('insBtn').innerText = 'Annulla';
            }
            else{
                document.getElementById('divInsCB').style = "display: none;";
                document.getElementById('insBtn').innerText = 'Nuovo Chatbot';
            }
        }
    </script>
    <%
        List<ChatbotsDTO> allMyChats = (List<ChatbotsDTO>) request.getAttribute("allChatbotsByUserId");
        UsersDTO current_user = (UsersDTO) request.getSession().getAttribute("utente");
    %>

</head>
<body>
    <div>
        <div>
            <div style='display: none;' id='divInsCB'>
<!-- CALL DA INSERIRE-->
                <form action ='ChatbotsServlet' method = 'post'>
                    <h4>Nome chat : <input type ="text" name ="nameChat"></h4>
                    <input type="hidden" name="idUserFk" value="<% request.getSession().getAttribute("utente");%>">
                    <input type = "submit" value ="creaChatbots" name="richiesta">
                </form>
            </div>
            <button onclick="unhideInsertForm()" id="insBtn">Nuovo Chatbot</button>
        </div>
        <div>
                <table>
                    <caption> Metabot - I tuoi Bot </caption>
                    <thead>
                        <th>  </th><th> Gestisci </th>
                    </thead>
                    <tbody>
        <%  for (ChatbotsDTO myBots : allMyChats){%>
                        <tr>
                            <td><h3><%= myBots.getId()%></h3></td>
                            <td>
<!-- CALL DA INSERIRE-->        <form action="ChatbotsServlet" method="post">
                                    <button type="submit" value="updateChatbots" name="richiesta"> MODIFICA</button>
                                </form>
<!-- CALL DA INSERIRE-->        <a href="ChatbotsServlet?richiesta=deleteChatbots&id=<%=myBots.getId()%>">ELIMINA</a>
                            </td>
                        </tr>
        <%  }   %>
                    </tbody>
                    <caption style ="float: right;">
                        <form action="LogoutServlet" method="post">
                        <input type="submit" value="Logout" name="Logout">
                        </form>
                    </caption>
                </table>
            </form>
        </div>
    </div>

</body>
</html>
