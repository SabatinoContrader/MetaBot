package main.view.nodes;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.NodesController;
import main.controller.Request;
import main.controller.SubNodesController;
import main.model.Nodes;
import main.view.View;

public class NodesDeleteView implements View {

	private NodesController nodesController;
	private Request request;

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<Nodes> nodes;
		Integer idNodes;

		nodes = nodesController.getAllNodes();
		System.out.println("----- Scegli Id per cancellare -----\n");
		nodes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println("id_nodes: \n");
		idNodes = Integer.parseInt(getInput());
		if (idNodes != null)
			nodesController.deleteNodes(idNodes);

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
		MainDispatcher.getInstance().callAction("Nodes", "doControl", request);
	}

}
