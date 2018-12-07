package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.NodesController;
import main.controller.Request;
import main.controller.SubNodesController;

public class NodesView implements View {

	private NodesController nodesController;
	private Request request;
	private int choice;

	public NodesView() {
		this.nodesController = new NodesController();
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU Nodes Controller-------");
		System.out.println("Scegli l'operazione che vuoi fare:");
		System.out.println("1) Visualizza Nodes Controller");
		System.out.println("2) Inserisci Nodes Controller");
		System.out.println("3) Modifica Nodes Controller");
		System.out.println("4) Cancella Nodes Controller");
		System.out.println("5) Logout");
		try {
			this.choice = Integer.parseInt(getInput());
		} catch (Exception e) {
			this.choice = 0;
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Nodes", "doControl", this.request);
	}
}
