package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.virtualpairprogrammers.model.Chat;
import com.virtualpairprogrammers.model.Message;
import com.virtualpairprogrammers.dto.ChatDTO;
import com.virtualpairprogrammers.dto.MessageDTO;
import com.virtualpairprogrammers.service.MessageService;
import com.virtualpairprogrammers.utils.FunzioniDiUtilita;
import com.virtualpairprogrammers.service.ChatService;

public class MessageServlet extends HttpServlet {

	private MessageService messageService;
	private ChatService chatService;
	private List<MessageDTO> allMessageDTO;
	private List<ChatDTO> allChatDTO;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scelta = request.getParameter("richiesta");
		HttpSession session = request.getSession(true);
		chatService = new ChatService();
		messageService = new MessageService();

		switch (scelta) {
		case "messageManagementMenu":
			int iduserIDLOGGATO = Integer.parseInt(session.getAttribute("userIDLOGGATO").toString());
			this.allChatDTO = this.chatService.getAllChatByUserID(iduserIDLOGGATO);
			request.setAttribute("allChatDTO", allChatDTO);
			getServletContext().getRequestDispatcher("/messageManagementMenu.jsp").forward(request, response);
			break;
		case "messageManagement":
			int sChatID = Integer.parseInt(request.getParameter("sChatID").toString());
			session.setAttribute("sChatID", sChatID);
			this.allMessageDTO = this.messageService.getAllMessageByChatID(sChatID);
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
			break;
		case "insert":
			this.allMessageDTO = this.messageService
					.getAllMessageByChatID(Integer.parseInt(session.getAttribute("sChatID").toString()));
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/insertMessage.jsp").forward(request, response);
			break;
		case "insertMessage":
			if (request != null) {
				int id = 0;
				String testo = request.getParameter("testo").toString();
				MessageDTO messageFK = null;
				int messageFKID = 0;

				int idChatId = Integer.parseInt(request.getParameter("sChat").toString());
				ChatDTO chat = new ChatDTO(idChatId, "", null);
				if (request.getParameter("choice") != null) {
					messageFKID = Integer.parseInt(request.getParameter("choice").toString());
					messageFK = new MessageDTO(messageFKID, "", null, null);
				}

				if (messageService.insertMessage(new MessageDTO(id, testo, chat, messageFK))) {
					this.allMessageDTO = this.messageService
							.getAllMessageByChatID(Integer.parseInt(session.getAttribute("sChatID").toString()));
					request.setAttribute("allMessageDTO", this.allMessageDTO);
					getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
				} else {
					response.sendRedirect("insertMessage.jsp");
				}
			}
			break;
		case "eliminaMessage":

			this.messageService.deleteMessage(Integer.parseInt(request.getParameter("id")));
			this.allMessageDTO = this.messageService
					.getAllMessageByChatID(Integer.parseInt(session.getAttribute("sChatID").toString()));
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
			break;
		case "Indietro":
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			this.allMessageDTO = this.messageService.getMessage(id);
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/updateMessage.jsp").forward(request, response);
			break;
		case "updateMessage":
			this.messageService.updateMessage(request);
			this.allMessageDTO = this.messageService
					.getAllMessageByChatID(Integer.parseInt(session.getAttribute("sChatID").toString()));
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
			break;
		case "messageVisualizzaMenu":
			this.allChatDTO = this.chatService
					.getAllChatByUserID(Integer.parseInt(session.getAttribute("userIDLOGGATO").toString()));
			request.setAttribute("allChatDTO", allChatDTO);
			getServletContext().getRequestDispatcher("/messageVisualizzaMenu.jsp").forward(request, response);
			break;
		case "messageVisualizza":
			int sChatID2 = Integer.parseInt(request.getParameter("sChatID").toString());
			session.setAttribute("sChatID", sChatID2);
			this.allMessageDTO = FunzioniDiUtilita.stampaChat(this.messageService.getAllMessageByChatID(sChatID2), 0,
					12);
			request.setAttribute("allMessageDTO", this.allMessageDTO);
			getServletContext().getRequestDispatcher("/messageVisualizza.jsp").forward(request, response);
			break;
		case "simulaChat":
			sChatID2 = Integer.parseInt(session.getAttribute("sChatID").toString());
			session.setAttribute("sChatID", sChatID2);
			this.allMessageDTO = FunzioniDiUtilita.stampaChat(this.messageService.getAllMessageByChatID(sChatID2), 0,
					12);
			List<Integer> listaPadre = new ArrayList<>();
			HashMap<MessageDTO, List<MessageDTO>> hashMessage = new HashMap<>();

			for (MessageDTO messageDTO : this.allMessageDTO) {
				if (!listaPadre.contains(messageDTO.getMessageFK().getMessageId())) {
					listaPadre.add(messageDTO.getMessageFK().getMessageId());
					List<MessageDTO> listaFigli = new ArrayList<>();
					hashMessage.put(messageDTO, listaFigli);
					for (MessageDTO lista2 : this.allMessageDTO) {
						if (messageDTO.getMessageFK().getMessageId() == lista2.getMessageFK().getMessageId()) {
							hashMessage.get(messageDTO).add(lista2);
						}
					}

				}
			}
			session.setAttribute("hashMessage", hashMessage);
			request.setAttribute("list", hashMessage.get(allMessageDTO.get(0)));
			// request.setAttribute("padre",
			// allMessageDTO.get(0).getMessageFK().getMessageId());
			getServletContext().getRequestDispatcher("/simulaChat.jsp").forward(request, response);
			break;
		case "NovoChat":
			hashMessage = (HashMap<MessageDTO, List<MessageDTO>>) session.getAttribute("hashMessage");
			Integer nuovoPadre = Integer.parseInt(request.getParameter("prossimoPadre"));
			MessageDTO find = null;
			for (MessageDTO padreHash : hashMessage.keySet()) {
				if( padreHash.getMessageFK().getMessageId() == nuovoPadre) {
					find = padreHash;
					//System.out.println("padreHash: " + padreHash);
				}
			}
			if (find != null) {
				request.setAttribute("list", hashMessage.get(find));
			}else {
				request.setAttribute("foglia", "foglia");
			}
			//System.out.println("padre: " + find);
			//System.out.println("hash: " + hashMessage.get(find));
			//request.setAttribute("list", hashMessage.get(find));
			getServletContext().getRequestDispatcher("/simulaChat.jsp").forward(request, response);
			break;
		}
	}
}
