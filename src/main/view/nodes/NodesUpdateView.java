package main.view.nodes;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.NodesController;
import main.controller.Request;
import main.controller.SubNodesController;
import main.model.ChatBots;
import main.model.Nodes;
import main.view.View;

public class NodesUpdateView implements View {

	private NodesController nodesController;
	private Request request;

	public NodesUpdateView() {
		this.nodesController = new NodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<Nodes> nodes;
		Integer nodesId;
		Integer sequence;

		nodes = nodesController.getAllNodes();
		System.out.println("----- Scegli Id per modificare -----");
		System.out.println();
		nodes.forEach(node -> System.out.println(node.toString()));
		System.out.println();
		System.out.println("nodes_id:");
		nodesId = Integer.parseInt(getInput());
		System.out.println("sequence:");
		sequence = Integer.parseInt(getInput());

		if (nodesId != null && sequence!= null) {
			nodesController.updateNodes(nodesId, sequence);
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
		MainDispatcher.getInstance().callAction("Nodes", "doControl", request);

	}

}
