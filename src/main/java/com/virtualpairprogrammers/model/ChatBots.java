package com.virtualpairprogrammers.model;

public class ChatBots {

	private int chatBotsId;
	private String initialMessage;
	private Users usersFK;

	public ChatBots(int chatBotsId, String initialMessage, Users usersFK) {
		this.chatBotsId = chatBotsId;
		this.initialMessage = initialMessage;
		this.usersFK = usersFK;
	}

	public int getChatBotsId() {
		return chatBotsId;
	}

	public void setChatBotsId(int chatBotsId) {
		this.chatBotsId = chatBotsId;
	}

	public String getInitialMessage() {
		return initialMessage;
	}

	public void setInitialMessage(String initialMessage) {
		this.initialMessage = initialMessage;
	}

	public Users getUsersFK() {
		return usersFK;
	}

	public void setUsersFK(Users usersFK) {
		this.usersFK = usersFK;
	}

	@Override
	public String toString() {
		return "ChatBots [chatBotsId=" + chatBotsId + ", initialMessage=" + initialMessage + ", usersFK=" + usersFK
				+ "]";
	}

}
