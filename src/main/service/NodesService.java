package main.service;

import main.dao.NodesDAO;
import main.model.Nodes;

import java.util.List;

public class NodesService {

    private NodesDAO nodesDAO;

    public NodesService() {
        this.nodesDAO = new NodesDAO();
    }

    public List<Nodes> getAllNodes () {
        return this.nodesDAO.getAllNodes();
    }
    
    public boolean insertNodes (Nodes nodes) {
        return this.nodesDAO.insertNodes(nodes);
    }

    public boolean updateNodes (Integer nodesId, Integer sequence) {
        return this.nodesDAO.updateNodes(nodesId,sequence);
    }
    
    public boolean deleteNodes (Integer nodesId) {
        return this.nodesDAO.deleteNodes(nodesId);
    }
}


