package main.view.nodes;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.NodesController;
import main.controller.Request;

import main.model.Nodes;

import main.view.View;

public class NodesInsertView implements View {

	private NodesController nodesController;
	private Request request;
	
	public NodesInsertView() {
		this.nodesController = new NodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
	
		 Integer nodesId;
		 Integer chatbotsIdFK;
		 Integer usersIdFK;
		 Integer botMessagesIdFK;
		 Integer sequence;
		 
		    System.out.println("Inserisci i dati Nodes:");
		    
			System.out.println("nodes_id:");
			nodesId = Integer.parseInt(getInput());
			
			System.out.println("chat_Bots_Id_FK:");
			chatbotsIdFK = Integer.parseInt(getInput());
			
			System.out.println("users_Id_FK:");
			usersIdFK = Integer.parseInt(getInput());
			
			System.out.println("bot_Messages_Id_FK:");
			botMessagesIdFK = Integer.parseInt(getInput());
			
			System.out.println("sequence:");
			sequence = Integer.parseInt(getInput());
			
			if (nodesId!= null &&  chatbotsIdFK!= null && usersIdFK!= null  && botMessagesIdFK!= null && sequence!=null  ){
				nodesController.insertNodes(new Nodes(nodesId,  chatbotsIdFK, usersIdFK,botMessagesIdFK,sequence ));
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
