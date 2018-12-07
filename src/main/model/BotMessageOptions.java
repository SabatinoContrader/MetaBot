package main.model;

public class BotMessageOptions {

	private int botMessageOptionId;
	private String botMessageOption;

	public BotMessageOptions(int botMessageOptionId, String botMessageOption) {
		this.botMessageOptionId = botMessageOptionId;
		this.botMessageOption = botMessageOption;
	}

	public int getBotMessageOptionId() {
		return botMessageOptionId;
	}

	public void setBotMessageOptionId(int botMessageOptionId) {
		this.botMessageOptionId = botMessageOptionId;
	}

	public String getBotMessageOption() {
		return botMessageOption;
	}

	public void setBotMessageOption(String botMessageOption) {
		this.botMessageOption = botMessageOption;
	}

	@Override
	public String toString() {
		return "BotMessageOptions [botMessageOptionId=" + botMessageOptionId + ", botMessageOption=" + botMessageOption
				+ "]";
	}
		
}
