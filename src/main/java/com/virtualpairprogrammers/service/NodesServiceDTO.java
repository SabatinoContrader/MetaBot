package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.NodesConverter;
import com.virtualpairprogrammers.dao.NodesDAO;
import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.model.Nodes;


public class NodesServiceDTO {
	
	private final NodesDAO nodeDAO;

	public NodesServiceDTO() {
		this.nodeDAO = new NodesDAO();
	}
   
	public List<NodesDTO> getAllNodes () {
    	
    	List<Nodes> list = nodeDAO.getAllNodes();
    	List<NodesDTO> listDTO = new ArrayList<>();
    	
    	for (Nodes node : list) {
    		listDTO.add(NodesConverter.toDTO(node));
    		
    }
    	
    
    
	return listDTO;
	
	
}

	public boolean updateNodes (Nodes nodes) {
		return this.nodeDAO.updateNode(nodes);
		
}
	
	public boolean deleteNodes (Integer Id) {
		return this.nodeDAO.deleteNodes(Id);
		
}
	
	public boolean insertNodes (Nodes nodes) {
		return this.nodeDAO.insertNodes(nodes);
	
}
	

	
}

