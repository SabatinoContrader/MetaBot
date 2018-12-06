package main.model;

public class BotMessageOptions {

	private int botMessageOptionId;
	private String botMessageOption;
	private int botMessageFk;

	public BotMessageOptions(int botMessageOptionId, String botMessageOption, int botMessageFk) {
		this.botMessageOptionId = botMessageOptionId;
		this.botMessageOption = botMessageOption;
		this.botMessageFk = botMessageFk;
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

	public int getBotMessageFk() {
		return botMessageFk;
	}

	public void setBotMessageFk(int botMessageFk) {
		this.botMessageFk = botMessageFk;
	}

	@Override
	public String toString() {
		return "BotMessageOptions [botMessageOptionId=" + botMessageOptionId + ", botMessageOption=" + botMessageOption
				+ ", botMessageFk=" + botMessageFk + "]";
	}
		
}
