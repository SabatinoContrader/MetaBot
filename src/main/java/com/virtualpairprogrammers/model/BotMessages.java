package com.virtualpairprogrammers.model;

public class BotMessages {
	
	private int botMessagesId;
	private String botMessages;
	
	public BotMessages(int botMessagesId, String botMessages) {
		this.botMessagesId = botMessagesId;
		this.botMessages = botMessages;
	}

	public int getBotMessagesId() {
		return botMessagesId;
	}

	public void setBotMessagesId(int botMessagesId) {
		this.botMessagesId = botMessagesId;
	}

	public String getBotMessages() {
		return botMessages;
	}

	public void setBotMessages(String botMessages) {
		this.botMessages = botMessages;
	}

	@Override
	public String toString() {
		return "BotMessages [botMessagesId=" + botMessagesId + ", botMessages=" + botMessages + "]";
	}
}
