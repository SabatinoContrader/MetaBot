package main.controller;

import main.MainDispatcher;

public class HomeController implements Controller {

    public HomeController() {
    }

    public void doControl(Request request) {
    	MainDispatcher.getInstance().callView("Home", null);

    }
}
