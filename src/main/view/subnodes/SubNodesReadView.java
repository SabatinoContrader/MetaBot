package main.view.subnodes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.SubNodes;
import main.view.View;
import main.controller.SubNodesController;

import java.util.List;
import java.util.Scanner;

public class SubNodesReadView implements View {

	private SubNodesController subNodesController;
	private Request request;
	
	public SubNodesReadView() {
		this.subNodesController = new SubNodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		List<SubNodes> subNodes = subNodesController.getAllSubNodes();
		System.out.println("----- Gli sub_nodes nel tuo database sono -----");
		System.out.println();
		subNodes.forEach(us_type -> System.out.println(us_type.toString()));
		System.out.println();
		
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
