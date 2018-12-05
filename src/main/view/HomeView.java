package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

	private int choice;

	public void showResults(Request request) {

	}

	public void showOptions() {
		System.out.println("Benvenuto in ContraderFramework");
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU-------");
		System.out.println("Scegli quali entità vuoi visualizzare:");
		System.out.println("1) Visualizza lista UserType");
		System.out.println("2) Visualizza lista User");
		System.out.println("3) Visualizza lista Opzioni");
		System.out.println("4) Visualizza lista Risposta");
		System.out.println("5) Visualizza lista ChatBot");
		System.out.println("6) Logout");
		this.choice = Integer.parseInt(getInput());
	}

	public void submit() {
//        if (choice < 1 || choice > 3 )
//            MainDispatcher.getInstance().callAction("Home", "doControl", null);
//        else if (choice == 3)
//            MainDispatcher.getInstance().callAction("Login", "doControl", null);
//        else {
//            Request request = new Request();
//            request.put("choice", choice);
//            MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
//        }
		if (choice == 1) {
			Request request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("UserType", "doControl", request);

		}
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
