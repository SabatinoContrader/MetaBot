package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.converter.NodeConverter;
import com.virtualpairprogrammers.dao.NodeDAO;
import com.virtualpairprogrammers.dto.NodeDTO;
import com.virtualpairprogrammers.model.Node;


public class NodeServiceDTO {
	
	private final NodeDAO nodeDAO;

	public NodeServiceDTO() {
		this.nodeDAO = new NodeDAO();
	}
   
	public List<NodeDTO> getAllNode() {
    	
    	List<Node> list = nodeDAO.getAllNode();
    	List<NodeDTO> listDTO = new ArrayList<>();
    	
    	for (Node node : list) {
    		listDTO.add(NodeConverter.toDTO(node));
    		
    }
    
	return listDTO;
	
}

}

