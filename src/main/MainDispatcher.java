package main;

import main.controller.Controller;
import main.controller.GestoreEccezioni;
import main.controller.Request;
import main.view.View;

import java.io.IOException;
import java.lang.reflect.Method;

public class MainDispatcher {

    private MainDispatcher() {
    }

    private static MainDispatcher instance;

    public static MainDispatcher getInstance() {
        if (instance == null) {
            instance = new MainDispatcher();
        }
        return instance;
    }

    public void callAction(String controller, String action, Request request) {
        Controller oggettoController = (Controller) ReflectionUtils.instantiateClass("main.controller." + controller + "Controller");
        try {
             Method metodo = oggettoController.getClass().getMethod(action, Request.class);
            metodo.invoke(oggettoController, request);
        } catch (Throwable e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }
    }

    public void callView(String view, Request request) {
        View oggettoView = (View) ReflectionUtils.instantiateClass("main.view." + view + "View");
        oggettoView.showResults(request);
        oggettoView.showOptions();
        oggettoView.submit();
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
