package main.model;

public class Nodes {
	
	private Integer nodesId;
	private Integer chatbotsIdFK;
	private Integer usersIdFK;
	private Integer botMessagesIdFK;
	private Integer sequence;
	
	public Nodes() {
		// TODO Auto-generated constructor stub
	}
	public Nodes(Integer nodesId, Integer chatbotsIdFK, Integer usersIdFK, Integer botMessagesIdFK, Integer sequence) {
		this.nodesId = nodesId;
		this.chatbotsIdFK = chatbotsIdFK;
		this.usersIdFK = usersIdFK;
		this.botMessagesIdFK = botMessagesIdFK;
		this.sequence = sequence;
		
		
		// TODO Auto-generated constructor stub
	}
	public Integer getNodesId() {
		return nodesId;
	}
	public void setNodesId(Integer nodesId) {
		this.nodesId = nodesId;
	}
	public Integer getChatbotsIdFK() {
		return chatbotsIdFK;
	}
	public void setChatbotsIdFK(Integer chatbotsIdFK) {
		this.chatbotsIdFK = chatbotsIdFK;
	}
	public Integer getUsersIdFK() {
		return usersIdFK;
	}
	public void setUsersIdFK(Integer usersIdFK) {
		this.usersIdFK = usersIdFK;
	}
	public Integer getBotMessagesIdFK() {
		return botMessagesIdFK;
	}
	public void setBotMessagesIdFK(Integer botMessagesIdFK) {
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
		return "Nodes [nodesId=" + nodesId + ", chatbotsIdFK=" + chatbotsIdFK + ", usersIdFK=" + usersIdFK
				+ ", botMessagesIdFK=" + botMessagesIdFK + ", sequence=" + sequence + "]";
	}
	

}
