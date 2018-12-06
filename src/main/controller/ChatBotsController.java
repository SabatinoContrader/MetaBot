package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.ChatBots;
import main.service.ChatBotsService;

public class ChatBotsController implements Controller {

	private static String sub_package = "chatbots.";
	private ChatBotsService chatBotsService;
	private Request request;
	
	public ChatBotsController() {
        this.chatBotsService = new ChatBotsService();
    }
	
	public List<ChatBots> getAllChatBots() {
		return this.chatBotsService.getAllUserType();
	}
	    
	public boolean insertChatBots (ChatBots chatBots) {
	    return this.chatBotsService.insertChatBots(chatBots);
	}

    public boolean updateChatBots (ChatBots chatBots) {
        return this.chatBotsService.updateChatBots(chatBots);
    }
    
    public boolean deleteChatBots (ChatBots chatBots) {
    	return this.chatBotsService.deleteChatBots(chatBots);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        int choice = (int) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("ChatBots", null);
        }else {
        switch (choice) {
		case 1:
			MainDispatcher.getInstance().callView(sub_package + "ChatBotsRead", null);
			break;
		case 2:
			MainDispatcher.getInstance().callView(sub_package + "ChatBotsInsert", null);
			break;
		case 3:
			MainDispatcher.getInstance().callView(sub_package + "ChatBotsUpdate", null);
			break;
		case 4:
			MainDispatcher.getInstance().callView(sub_package + "ChatBotsDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }
}
