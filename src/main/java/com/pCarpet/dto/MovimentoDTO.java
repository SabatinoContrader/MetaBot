package com.pCarpet.dto;


public class MovimentoDTO {

	private BadgeReaderDTO badgereader;
	private BadgeDTO badge;
	private String orainizio;
	private String orafine;
	private AssegnazioneDTO assDTO;
	
	public MovimentoDTO() {
		
	}
	
	
	public MovimentoDTO(BadgeReaderDTO badgereader, BadgeDTO badge, String orainizio, String orafine, AssegnazioneDTO assDTO) {
		this();
		this.badgereader = badgereader;
		this.badge = badge;
		this.orainizio = orainizio;
		this.orafine = orafine;
		this.assDTO=assDTO;
	}


	public BadgeReaderDTO getBadgereader() {
		return badgereader;
	}


	public void setBadgereader(BadgeReaderDTO badgereader) {
		this.badgereader = badgereader;
	}



	public BadgeDTO getBadge() {
		return badge;
	}


	public void setBadge(BadgeDTO badge) {
		this.badge = badge;
	}


	public String getOrainizio() {
		return orainizio;
	}


	public void setOrainizio(String orainizio) {
		this.orainizio = orainizio;
	}


	public String getOrafine() {
		return orafine;
	}


	public void setOrafine(String orafine) {
		this.orafine = orafine;
	}


	public AssegnazioneDTO getAssDTO() {
		return assDTO;
	}


	public void setAssDTO(AssegnazioneDTO assDTO) {
		this.assDTO = assDTO;
	}
	
	
	
}
