<%@ page import="com.virtualpairprogrammers.model.Prodotto" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Prodotto> all_product_fornitore = (List<Prodotto>) request.getAttribute("all_product_fornitore");%>
 </head>
 <body>
<h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
<form action="ProdottoServlet" method="post">
    <input type="text" name="colonna">
    <input type="text" name="campoRiga">
    <input type="submit" value="SearchCategory" name="richiesta">
</form>

<form action="ProdottoServlet" method="post">
 <table>
 <tr>
   <td>
      Categoria:
   </td>
   <td>
   </td>
   </td>
   </tr>
     <tr>
        <th></th>
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
            DESCRIZIONE
         </th>
         <th>
             DESCRIZIONE LUNGA
         </th>
         <th>
            PREZZO DI VENDITA
          </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
        <%for (Prodotto prodotti : all_product_fornitore) { %>
     <tr>
         <td>
             <input type="checkbox" name="products" value="<%= prodotti.getId()%>"/>
         </td>

         <td>
             <%= prodotti.getId()%>
         </td>

         <td>
             <%=  prodotti.getEan()%>
         </td>

         <td>
             <%=  prodotti.getCategory()%>
         </td>

         <td>
             <%=  prodotti.getModel()%>
         </td>

         <td>
             <%=  prodotti.getManufacturer()%>
         </td>
         <td>
             <%=  prodotti.getDescrizione()%>
         </td>
         <td>
             <%=  prodotti.getDescrizioneLunga()%>
         </td>
         <td>
             <%=  prodotti.getPrezzoVendita()%>
         </td>
         <td>
             <a href="ProdottoServlet?richiesta=ModificaProdotto&id=<%=  prodotti.getId()%>">Modifica</a>
         </td>
         <td>
             <a href="ProdottoServlet?richiesta=EliminaProdotto&id=<%= prodotti.getId()%>">Elimina</a>
         </td>

     </tr>
     <% }%>
 </table>
<input type="submit" value="SellProducts" name="richiesta"> <a href="home.jsp">Home <h3><a href="insertProdotto.jsp">Inserisci Prodotto</a></h3>
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci un nuovo Prodotto</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>