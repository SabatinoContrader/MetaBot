package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.EsempioDTO;
import com.virtualpairprogrammers.model.Esempio;
import com.virtualpairprogrammers.service.EsempioServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class EsempioServlet extends HttpServlet {

	private final EsempioServiceDTO esempioServiceDTO = new EsempioServiceDTO();
	private List<EsempioDTO> allEsempi= new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "esempioManager":
			allEsempi = this.esempioServiceDTO.getAllEsempio();
			request.setAttribute("allEsempi", allEsempi);
			getServletContext().getRequestDispatcher("/esempio.jsp").forward(request, response);
			break;			

		case "Indietro":
			response.sendRedirect("home.jsp");
			break;

		}

	}
}