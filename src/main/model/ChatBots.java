package main.model;

public class ChatBots {

	private int chatbotId;
	private String initialMessage;
	private String userFk;

	public ChatBots(int chatbotId, String initialMessage, String userFk) {
		this.chatbotId = chatbotId;
		this.initialMessage = initialMessage;
		this.userFk = userFk;
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

	public String getUserFk() {
		return userFk;
	}

	public void setUserFk(String userFk) {
		this.userFk = userFk;
	}

	@Override
	public String toString() {
		return "ChatBots [chatbotId=" + chatbotId + ", initialMessage=" + initialMessage + ", userFk=" + userFk + "]";
	}
	
}
