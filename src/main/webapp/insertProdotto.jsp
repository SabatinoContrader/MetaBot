 <%@ page import="com.virtualpairprogrammers.model.Prodotto" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <% Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");

     if (prodotto == null)
     prodotto = new Prodotto();

     %>

</head>
<body>
<form action="ProdottoServlet" method="post">
    <h2>ID<input type="hidden" name="id" value="<%= prodotto.getId()%>"></h2>
    <h2>EAN<input type="text" name="ean" value="<%= prodotto.getEan()%>"></h2>
    <h2>Category<input type="text" name="category" value="<%= prodotto.getCategory()%>"></h2>
    <h2>Model<input type="text" name="model" value="<%= prodotto.getModel()%>"> </h2>
    <h2>Manufacturer<input type="text" name="manufacturer" value="<%= prodotto.getManufacturer()%>"></h2>
    <h2>Descrizione<input type="text" name="descrizione" value="<%= prodotto.getDescrizione()%>"></h2>
    <h2>Descrizione lunga<input type="text" name="descrizioneLunga" value="<%= prodotto.getDescrizioneLunga()%>"></h2>
    <h2>Prezzo di Vendita<input type="text" name="prezzoVendita" value="<%= prodotto.getPrezzoVendita()%>"></h2>
    <input type="submit" value="UpdateProdotto" name="richiesta">
</form>
</body>
</html>