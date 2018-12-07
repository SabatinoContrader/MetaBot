package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Nodes;
import main.service.NodesService;
import main.service.SubNodesService;

public class NodesController implements Controller {

	// indica il sub package per le view corrispondenti al model Nodes
	private static final String SUB_PACKAGE = "nodes.";
	private NodesService nodesService;
	private Request request;

	public List<Nodes> getAllNodes() {
		return this.nodesService.getAllNodes();
	}

	public boolean insertNodes(Nodes nodes) {
		return this.nodesService.insertNodes(nodes);
	}

	public boolean updateNodes(Integer nodesId, Integer sequence) {
		return this.nodesService.updateNodes(nodesId, sequence);
	}

	public boolean deleteNodes(Integer nodesId) {
		return this.nodesService.deleteNodes(nodesId);
	}

	@Override
	public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("Nodes", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(SUB_PACKAGE + "NodesRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(SUB_PACKAGE + "NodesInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(SUB_PACKAGE + "NodesUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(SUB_PACKAGE + "NodesDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }

}
