package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.SubNodes;
import main.service.SubNodesService;

public class SubNodesController implements Controller {

	private static String sub_package = "subnodes.";
	private SubNodesService subNodesService;
	private Request request;
	
	public SubNodesController() {
        this.subNodesService = new SubNodesService();
    }
	
	public List<SubNodes> getAllSubNodes() {
		return this.subNodesService.getAllSubNodes();
	}
	    
	public boolean insertSubNodes (SubNodes subNodes) {
	    return this.subNodesService.insertSubNodes(subNodes);
	}

    public boolean updateSubNodes (SubNodes subNodes) {
        return this.subNodesService.updateSubNodes(subNodes);
    }
    
    public boolean deleteSubNodes (SubNodes subNodes) {
    	return this.subNodesService.deleteSubNodes(subNodes);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("SubNodes", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(sub_package + "SubNodesRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(sub_package + "SubNodesInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(sub_package + "SubNodesUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(sub_package + "SubNodesDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }

}
