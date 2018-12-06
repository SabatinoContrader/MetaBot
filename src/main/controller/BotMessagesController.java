package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.BotMessages;
import main.service.BotMessagesService;

public class BotMessagesController implements Controller {

	private static String sub_package = "botmessages.";
	private BotMessagesService botMessagesService;
	private Request request;
	
	public BotMessagesController() {
        this.botMessagesService = new BotMessagesService();
    }
	
	public List<BotMessages> getAllBotMessages() {
		return this.botMessagesService.getAllBotMessages();
	}
	    
	public boolean insertBotMessages (BotMessages botMessages) {
	    return this.botMessagesService.insertBotMessages(botMessages);
	}

    public boolean updateBotMessages (BotMessages botMessages) {
        return this.botMessagesService.updateBotMessages(botMessages);
    }
    
    public boolean deleteBotMessages (BotMessages botMessages) {
    	return this.botMessagesService.deleteBotMessages(botMessages);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("BotMessages", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(sub_package + "BotMessagesRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(sub_package + "BotMessagesInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(sub_package + "BotMessagesUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(sub_package + "BotMessagesDelete", null);
			break;
		default:
			MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }
}
