package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.service.AssetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuServlet extends HttpServlet {

    private AssetService assetService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        assetService =  new AssetService();
        switch (scelta) {
            case "AssetMenu":
            	response.sendRedirect("homeAsset.jsp");
//                List<Prodotto> allProdotti = this.prodottoService.getAllProdotti();
//                request.setAttribute("all_product_fornitore", allProdotti);
//                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request,response);
                break;
            case "CustomersMenu":
            	response.sendRedirect("homeCustomers.jsp");
                break;
            case "Indietro":
            	response.sendRedirect("home.jsp");
                break;
            case "LogsMenu":
            	response.sendRedirect("homeLogs.jsp");
                break;
        
        }

    }

}
