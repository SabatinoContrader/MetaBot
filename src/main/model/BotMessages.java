package main.model;

public class BotMessages {
	
	private int botMessageId;
	private String botMessage;
	
	public BotMessages(int botMessageId, String botMessage) {
		this.botMessageId = botMessageId;
		this.botMessage = botMessage;
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

	@Override
	public String toString() {
		return "BotMessages [botMessageId=" + botMessageId + ", botMessage=" + botMessage + "]";
	}
}
