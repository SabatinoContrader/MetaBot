package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.NodeToNodeDAO;
import com.virtualpairprogrammers.model.NodeToNode;

public class NodeToNodeService {

  private NodeToNodeDAO nodetonodeDAO;
  
  public NodeToNodeService() {
	  this.nodetonodeDAO = new NodeToNodeDAO();
	  
  }
  
 public List<NodeToNode> getAllNodeToNode () {
	 return this.nodetonodeDAO.getAllNodeToNode();
   
 }
 public boolean insertNodeToNode (NodeToNode nodetonode) {
     return this.nodetonodeDAO.insertNodeToNode(nodetonode);

 }
 
 
 public boolean deleteNodeToNode (NodeToNode nodetonode) {
     return this.nodetonodeDAO.deleteNodeToNode(nodetonode);
 }
 
}