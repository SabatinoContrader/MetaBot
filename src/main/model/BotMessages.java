package main.model;

public class BotMessages {
	
	private int botMessageId;
	private String botMessage;
	private int chatbotFk;

	public BotMessages(int botMessageId, String botMessage, int chatbotFk) {
		this.botMessageId = botMessageId;
		this.botMessage = botMessage;
		this.chatbotFk = chatbotFk;
	}

	public int getBotMessageId() {
		return botMessageId;
	}

	public void setBotMessageId(int botMessageId) {
		this.botMessageId = botMessageId;
	}

	public String getBotMessage() {
		return botMessage;
	}

	public void setBotMessage(String botMessage) {
		this.botMessage = botMessage;
	}

	public int getChatbotFk() {
		return chatbotFk;
	}

	public void setChatbotFk(int chatbotFk) {
		this.chatbotFk = chatbotFk;
	}

	@Override
	public String toString() {
		return "BotMessages [botMessageId=" + botMessageId + ", botMessage=" + botMessage + ", chatbotFk=" + chatbotFk
				+ "]";
	}
}
