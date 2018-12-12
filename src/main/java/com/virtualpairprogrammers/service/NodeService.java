package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.NodeDAO;
import com.virtualpairprogrammers.model.Node;

import java.util.List;

public class NodeService {
    private NodeDAO nodeDAO;
    
    public NodeService () {
        this.nodeDAO = new NodeDAO();
    }
    
    public List<Node> getAllNodes () {
        return this.nodeDAO.getAllNodes();
    }
    
    public List<Node> getAllValidNodes () {
        return this.nodeDAO.getAllValidNodes();
    }
    
    public boolean insertNode (Node node) {
        return this.nodeDAO.insertNode(node);
    }
    
    public boolean updateNode (Node node) {
        return this.nodeDAO.updateNode(node);
    }
    
    public boolean softDeleteNode (Node node) {
        return this.nodeDAO.softDeleteNode(node);
    }
    
    public boolean deleteNode (Node node) {
        return this.nodeDAO.deleteNode(node);
    }
}
