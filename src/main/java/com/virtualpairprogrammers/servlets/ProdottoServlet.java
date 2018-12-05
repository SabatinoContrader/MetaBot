package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.service.ProdottoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoServlet extends HttpServlet {

    private ProdottoService prodottoService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        prodottoService =  new ProdottoService();
        switch (scelta) {
            case "ModificaProdotto":
                int prodottoModifica = Integer.parseInt(request.getParameter("id"));
                Prodotto prodotto = prodottoService.get(prodottoModifica);
                //session.setAttribute("prodotto", prodotto);
                request.setAttribute("prodotto", prodotto);
                getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response);
                //response.sendRedirect("insertProdotto.jsp");
                break;
            case "ViewListProduct":
                List<Prodotto> allProdotti = this.prodottoService.getAllProdotti();
                request.setAttribute("all_product_fornitore", allProdotti);
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                break;
            case "SearchCategory":
                String fieldOne = request.getParameter("colonna");
                String fieldTwo = request.getParameter("campoRiga");
                List<Prodotto> filterProduct = prodottoService.searchProduct(fieldOne,fieldTwo);
                request.setAttribute("all_product_fornitore",filterProduct);
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                //System.out.println(filterProduct.get(0).getId()); <-- trucchetto per verificare se i dati arrivano fin qui
                //response.sendRedirect("listProdotti.jsp");
            case "SellProducts":
                String[] prodottiSell = request.getParameterValues("products");
                for (String prodottoSell : prodottiSell) {
                    System.out.println("ProdottoSell: " + prodottoSell);
                }
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
            case "ViewListProductFornitore":
                request.setAttribute("all_product_fornitore", prodottoService.getProdottiDisponibili());
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                //response.sendRedirect("listProdotti.jsp");
            case "UpdateProdotto":
                int id = 0;
                try{
                    id = Integer.parseInt(request.getParameter("id"));
                }catch(Exception e){}
                String ean = request.getParameter("ean");
                String category = request.getParameter("category");
                String model = request.getParameter("model");
                String manufacturer = request.getParameter("manufacturer");
                String descrizione = request.getParameter("descrizione");
                String descrizioneLunga = request.getParameter("descrizioneLunga");
                double prezzoVendita = Double.parseDouble(request.getParameter("prezzoVendita"));
                Prodotto newInsert = new Prodotto(id, ean, category, model, manufacturer, descrizione, descrizioneLunga, prezzoVendita);
                if(id == 0)
                    this.prodottoService.insert(newInsert);
                else
                    this.prodottoService.update(newInsert);
                request.setAttribute("all_product_fornitore", prodottoService.getAllProdotti());
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                //response.sendRedirect("listProdotti.jsp");
                break;
            case "EliminaProdotto":
                int idDelete=Integer.parseInt(request.getParameter("id"));
                this.prodottoService.delete(idDelete);
                request.setAttribute("all_product_fornitore",prodottoService.getAllProdotti());
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                break;
        }

    }

}
