package com.virtualpairprogrammers.model;

public class Nodes {

	private Integer nodesId;
	private ChatBots chatbotsIdFK;
	private BotMessages botMessagesIdFK;
	private Integer sequence;

	public Nodes(Integer nodesId, ChatBots chatbotsIdFK, BotMessages botMessagesIdFK, Integer sequence) {
		this.nodesId = nodesId;
		this.chatbotsIdFK = chatbotsIdFK;
		this.botMessagesIdFK = botMessagesIdFK;
		this.sequence = sequence;
	}

	public Integer getNodesId() {
		return nodesId;
	}

	public void setNodesId(Integer nodesId) {
		this.nodesId = nodesId;
	}

	public ChatBots getChatbotsIdFK() {
		return chatbotsIdFK;
	}

	public void setChatbotsIdFK(ChatBots chatbotsIdFK) {
		this.chatbotsIdFK = chatbotsIdFK;
	}

	public BotMessages getBotMessagesIdFK() {
		return botMessagesIdFK;
	}

	public void setBotMessagesIdFK(BotMessages botMessagesIdFK) {
		this.botMessagesIdFK = botMessagesIdFK;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "Nodes [nodesId=" + nodesId + ", chatbotsIdFK=" + chatbotsIdFK + ", botMessagesIdFK=" + botMessagesIdFK
				+ ", sequence=" + sequence + "]";
	}

}
