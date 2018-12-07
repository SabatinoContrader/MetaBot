package main.view.subnodes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.SubNodes;
import main.view.View;
import main.controller.SubNodesController;

import java.util.List;
import java.util.Scanner;

public class SubNodesDeleteView implements View {

	private SubNodesController subNodesController;
	private Request request;

	public SubNodesDeleteView() {
		this.subNodesController = new SubNodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<SubNodes> subNodes;
		Integer idSubNodes;

		subNodes = subNodesController.getAllSubNodes();
		System.out.println("----- Scegli Id per cancellare -----\n");
		subNodes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("id_sub_nodes: \n");
		idSubNodes = Integer.parseInt(getInput());
		if (idSubNodes != null)
			subNodesController.deleteSubNodes(new SubNodes(idSubNodes, 0, 0, 0));
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
