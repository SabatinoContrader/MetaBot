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
   
	public List<NodesDTO> getAllNode() {
    	
    	List<Nodes> list = NodesDAO.getAllNode();
    	List<NodesDTO> listDTO = new ArrayList<>();
    	
    	for (Nodes node : list) {
    		listDTO.add(NodesConverter.toDTO(node));
    		
    }
    
	return listDTO;
	
}

}

