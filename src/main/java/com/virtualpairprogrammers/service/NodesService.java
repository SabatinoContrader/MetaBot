package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.NodesDAO;
import com.virtualpairprogrammers.model.Nodes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NodesService {

    private NodesDAO nodesDAO;

    public NodesService() {
        this.nodesDAO = new NodesDAO();
    }

    public List<Nodes> getAllNodes () {
        return this.nodesDAO.getAllNodes();
    }
    
    public List<Nodes> getNodes (int id) {
        return this.nodesDAO.getNodes(id);
    }
    
    public boolean insertNodes (Nodes nodes) {
        return this.nodesDAO.insertNodes(nodes);
    }

    public boolean updateNodes (HttpServletRequest request) {
        return this.nodesDAO.updateNodes(request);
    }
    
    public boolean deleteNodes (Integer nodesId) {
        return this.nodesDAO.deleteNodes(nodesId);
    }
}


