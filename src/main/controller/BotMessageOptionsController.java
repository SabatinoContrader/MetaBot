package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.BotMessageOptions;
import main.service.BotMessageOptionsService;

public class BotMessageOptionsController implements Controller {

	private static String sub_package = "botmessageoptions.";
	private BotMessageOptionsService botMessageOptionsService;
	private Request request;
	
	public BotMessageOptionsController() {
        this.botMessageOptionsService = new BotMessageOptionsService();
    }
	
	public List<BotMessageOptions> getAllBotMessageOptions() {
		return this.botMessageOptionsService.getAllBotMessageOptions();
	}
	    
	public boolean insertBotMessageOptions (BotMessageOptions botMessageOptions) {
	    return this.botMessageOptionsService.insertBotMessageOptions(botMessageOptions);
	}

    public boolean updateBotMessageOptions (BotMessageOptions botMessageOptions) {
        return this.botMessageOptionsService.updateBotMessageOptions(botMessageOptions);
    }
    
    public boolean deleteBotMessageOptions (BotMessageOptions botMessageOptions) {
    	return this.botMessageOptionsService.deleteBotMessageOptions(botMessageOptions);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("BotMessageOptions", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(sub_package + "BotMessageOptionsRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(sub_package + "BotMessageOptionsInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(sub_package + "BotMessageOptionsUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(sub_package + "BotMessageOptionsDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }
}
