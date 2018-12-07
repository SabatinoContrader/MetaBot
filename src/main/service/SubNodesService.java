package main.service;

import main.dao.SubNodesDAO;
import main.model.SubNodes;

import java.util.List;

public class SubNodesService {

    private SubNodesDAO subNodesDAO;

    public SubNodesService() {
        this.subNodesDAO = new SubNodesDAO();
    }

    public List<SubNodes> getAllSubNodes () {
        return this.subNodesDAO.getAllNodes();
    }
    
    public boolean insertSubNodes (SubNodes subNodes) {
        return this.subNodesDAO.insertSubNodes(subNodes);
    }

    public boolean updateSubNodes (SubNodes subNodes) {
        return this.subNodesDAO.updateSubNodes(subNodes);
    }
    
    public boolean deleteSubNodes (SubNodes subNodes) {
        return this.subNodesDAO.deleteSubNodes(subNodes);
    }
}


