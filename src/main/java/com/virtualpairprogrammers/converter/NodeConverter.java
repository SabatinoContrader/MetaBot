package com.virtualpairprogrammers.converter;

import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.dto.NodeDTO;
import com.virtualpairprogrammers.model.Node;

public class NodeConverter {
	
	public static Node toEntity(NodeDTO nodeDTO) {
		
		Node node = null;
		if (nodeDTO != null) {
			node = new Node(NodeDTO.getId(), nodeDTO.getId_user_fk(), nodeDTO.getId_nodo_root_fk(), nodeDTO.getName_chat());
		}
		
		return node;
	
	}
	
	public static NodeDTO toDTO(Node node) {
		
		NodeDTO nodeDTO = null;
		if (node != null) {
			nodeDTO = new NodeDTO (node.getId(), node.getId_user_fk(), node.getId_nodo_root_fk(), node.getName_chat());
		}
		
		return nodeDTO;
	}
	
}