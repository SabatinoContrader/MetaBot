<%@ page import="com.virtualpairprogrammers.domain.Annunci" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<Prodotto> prodotti_selezionati = (List<Prodotto>) session.getAttribute("listProdottiRicercati"); %>
</head>
<body>
<table>
    <tr>
        <th>
            ID_PRODUCT
        </th>
        <th>
            EAN
        </th>
        <th>
            CATEGORY
        </th>
        <th>
            MODEL
        </th>
        <th>
             MANUFACTURER
        </th>
        <th>
            PREZZOACQUISTO
        </th>
        <th>
            PREZZOVENDITA
        </th>

    </tr>

    <%for (Prodotto prodotti : prodotti_selezionati) { %>
    <tr>

        <td>
            <%= prodotti.getIdProduct()%>
        </td>

        <td>
            <%= prodotti.getEan()%>
        </td>

        <td>
            <%= prodotti.getCategory()%>
        </td>

        <td>
            <%= prodotti.getModel()%>
        </td>

        <td>
            <%= prodotti.getManufacturer()%>
        </td>

        <td>
            <%= prodotti.getPrezzoAcquisto()%>
        </td>

        <td>
           <%= prodotti.getPrezzoVendita()%>
        </td>

    </tr>
    <% }%>
</table>