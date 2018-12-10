package com.virtualpairprogrammers.model;

public class BotMessageOptions {

	private int botMessageOptionsId;
	private String botMessageOptions;

	public BotMessageOptions(int botMessageOptionsId, String botMessageOptions) {
		this.botMessageOptionsId = botMessageOptionsId;
		this.botMessageOptions = botMessageOptions;
	}

	public int getBotMessageOptionsId() {
		return botMessageOptionsId;
	}

	public void setBotMessageOptionsId(int botMessageOptionsId) {
		this.botMessageOptionsId = botMessageOptionsId;
	}

	public String getBotMessageOptions() {
		return botMessageOptions;
	}

	public void setBotMessageOptions(String botMessageOptions) {
		this.botMessageOptions = botMessageOptions;
	}

	@Override
	public String toString() {
		return "BotMessageOptions [botMessageOptionsId=" + botMessageOptionsId + ", botMessageOptions=" + botMessageOptions
				+ "]";
	}
		
}
