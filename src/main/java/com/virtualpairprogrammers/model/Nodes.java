package com.virtualpairprogrammers.model;

public class Nodes {

	private Integer nodesId;
	private ChatBots chatbotsIdFK;
	private Integer sequence;

	public Nodes(Integer nodesId, ChatBots chatbotsIdFK, Integer sequence) {
		this.nodesId = nodesId;
		this.chatbotsIdFK = chatbotsIdFK;
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
