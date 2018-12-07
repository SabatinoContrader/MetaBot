package main.view.subnodes;

import main.MainDispatcher;
import main.controller.Request;
import main.model.SubNodes;
import main.model.UserTypes;
import main.view.View;
import main.controller.SubNodesController;

import java.util.List;
import java.util.Scanner;

public class SubNodesInsertView implements View {

	private SubNodesController subNodesController;
	private Request request;
	
	public SubNodesInsertView() {
		this.subNodesController = new SubNodesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
	
		 Integer idSubNodes;
		 Integer botMessageOptionFk;
		 Integer sequence;
		 Integer idNodeFk;
		 
			System.out.println("\n Inserisci i campi della Subnodes");
		    
			System.out.println("\nDigita l'ID Subnodes:");
			idSubNodes = Integer.parseInt(getInput());
			
			System.out.println("\nDigita il messaggio: ");
			botMessageOptionFk = Integer.parseInt(getInput());
			
			System.out.println("\nDigita la Sequenza");
			sequence = Integer.parseInt(getInput());
			System.out.println("\nDigita l'ID Nodes");
			idNodeFk = Integer.parseInt(getInput());
			
			if (idSubNodes!= null &&  botMessageOptionFk!= null && sequence!= null  && idNodeFk!= null   ){
				subNodesController.insertSubNodes(new SubNodes( idSubNodes, botMessageOptionFk,sequence ,idNodeFk  ));
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