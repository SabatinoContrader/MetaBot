package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.NodesDAO;
import com.virtualpairprogrammers.model.Nodes;

import java.util.List;

public class NodesService {
    private NodesDAO nodeDAO;
    
    public NodesService () {
        this.nodeDAO = new NodesDAO();
    }
    
    public List<Nodes> getAllNodes () {
        return this.nodeDAO.getAllNodes();
    }
    
    public List<Nodes> getAllValidNodes () {
        return this.nodeDAO.getAllValidNodes();
    }
    
    public boolean insertNode (Nodes node) {
        return this.nodeDAO.insertNode(node);
    }
    
    public boolean updateNode (Nodes node) {
        return this.nodeDAO.updateNode(node);
    }
    
    public boolean softDeleteNode (Nodes node) {
        return this.nodeDAO.softDeleteNode(node);
    }
    
    public boolean deleteNode (Nodes node) {
        return this.nodeDAO.deleteNode(node);
    }
}
