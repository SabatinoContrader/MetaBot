package main.model;

public class ChatBots {

	private int chatbotId;
	private String initialMessage;

	public ChatBots(int chatbotId, String initialMessage) {
		this.chatbotId = chatbotId;
		this.initialMessage = initialMessage;
	}

	public int getChatbotId() {
		return chatbotId;
	}

	public void setChatbotId(int chatbotId) {
		this.chatbotId = chatbotId;
	}

	public String getInitialMessage() {
		return initialMessage;
	}

	public void setInitialMessage(String initialMessage) {
		this.initialMessage = initialMessage;
	}

	public String toString() {
		return "ChatBots [chatbotId=" + chatbotId + ", initialMessage=" + initialMessage + "]";
	}
	
}
