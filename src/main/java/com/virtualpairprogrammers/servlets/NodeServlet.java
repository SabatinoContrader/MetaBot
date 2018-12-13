package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import com.virtualpairprogrammers.service.NodeService;
import com.virtualpairprogrammers.model.Node;

public class NodeServlet extends HttpServlet {
    
    private NodeService    nodeSERVICE;
    private List<Node>     allNodes;
    
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String      request_choice = request.getParameter("richiesta");
        HttpSession session        = request.getSession(true);
        nodeSERVICE = new NodeService();
        
        switch (request_choice) {
            case "nodeManagement": {
                this.allNodes = this.nodeSERVICE.getAllNodes();
                request.setAttribute("allNodes", this.allNodes);
                getServletContext().getRequestDispatcher("/nodes.jsp").forward(request, response);
            } break;
            case "insertNode": {
                if (request != null) {
                    Integer chatbot_FK = Integer.parseInt(request.getParameter("chatbot_FK"));
                    String  content    = request.getParameter("content");
                    Node new_node = new Node(null,chatbot_FK,content,null,null,null);
                    nodeSERVICE.insertNode(new_node);
                    request.setAttribute("allNodes", nodeSERVICE.getAllNodes());
                    getServletContext().getRequestDispatcher("/nodes.jsp").forward(request,response);
                }
            } break;
            case "updateNode":{
                this.nodeSERVICE.updateNode((Node)request.getAttribute("node_to_update"));
                request.setAttribute("allNodes", nodeSERVICE.getAllNodes());
                getServletContext().getRequestDispatcher("/nodes.jsp").forward(request, response);
            }
            case "deleteNode": {
                this.nodeSERVICE.deleteNode((Node)request.getAttribute("node_to_delete"));
                request.setAttribute("allNodes", nodeSERVICE.getAllNodes());
                getServletContext().getRequestDispatcher("/nodes.jsp").forward(request, response);
            }
        }
    }
}
