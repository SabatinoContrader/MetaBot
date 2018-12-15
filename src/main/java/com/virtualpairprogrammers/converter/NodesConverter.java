package com.virtualpairprogrammers.converter;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.dto.NodesDTO;
import com.virtualpairprogrammers.model.Nodes;

public class NodesConverter {
	
	public static Nodes toEntity(NodesDTO nodeDTO) {
		
		Nodes node = null;
		if (nodeDTO != null) {
			node = new Nodes(nodeDTO.getId(), nodeDTO.getText(), nodeDTO.getIdNodoPadre());
		}
		return node;		
	}
	
	public static NodesDTO toDTO(Nodes node) {
		
		NodesDTO nodeDTO = null;
		if (node != null) {
			nodeDTO = new NodesDTO (node.getId(), node.getText(), node.getIdNodoPadre());
		}
		
		return nodeDTO;
	}
	
}