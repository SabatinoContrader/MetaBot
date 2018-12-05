package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private RegisterService registerService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        registerService = new RegisterService();
        if (request != null) {
            String nomeUtente = request.getParameter("username").toString();
            String password = request.getParameter("password").toString();
            String nome = request.getParameter("nome").toString();
            String cognome = request.getParameter("cognome").toString();
            if (registerService.insert(new Utente(0, nomeUtente, password, nome, cognome)) > 0)
                response.sendRedirect("index.jsp");
            else
                response.sendRedirect("register.jsp");
        }

    }
}