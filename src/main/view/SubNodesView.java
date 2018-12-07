package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.controller.SubNodesController;
import java.util.Scanner;

public class SubNodesView implements View {

	private SubNodesController subNodesController;
	private Request request;
	private int choice;
	
	public SubNodesView() {
		this.subNodesController = new SubNodesController ();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU SubNodes Controller-------");
		System.out.println("Scegli l'operazione che vuoi fare:");
		System.out.println("1) Visualizza SubNodes Controller");
		System.out.println("2) Inserisci SubNodes Controller");
		System.out.println("3) Modifica SubNodes Controller");
		System.out.println("4) Cancella SubNodes Controller");
		System.out.println("5) Logout");
		try {
			this.choice = Integer.parseInt(getInput());
		} catch(Exception e) {
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
		    MainDispatcher.getInstance().callAction("SubNodes", "doControl", this.request);
	}

}
