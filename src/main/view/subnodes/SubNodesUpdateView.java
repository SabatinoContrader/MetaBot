package main.view.subnodes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.SubNodes;
import main.view.View;
import main.dao.UserTypesDAO;
import main.controller.UserTypesController;
import main.controller.SubNodesController;
import java.util.List;
import java.util.Scanner;

public class SubNodesUpdateView implements View {

	private SubNodesController subNodesController;
	private Request request;

	public SubNodesUpdateView() {
		this.subNodesController = new SubNodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<SubNodes> subNodes;
		 Integer idSubNodes;
		 Integer BotMessageOptionFk;
		 Integer sequence;
		 
		subNodes = subNodesController.getAllSubNodes();
		System.out.println("----- Scegli Id per modificare ----- \n");

		subNodes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("\n id_sub_nodes:");
		idSubNodes = Integer.parseInt(getInput());
		
		subNodes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("\n sequence:");
		sequence = Integer.parseInt(getInput());
		
		if (idSubNodes != null && sequence != null) {
			subNodesController.updateSubNodes(new SubNodes(idSubNodes, 0,sequence,0));
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", 0);
		MainDispatcher.getInstance().callAction("SubNodes", "doControl", request);
	}

}

